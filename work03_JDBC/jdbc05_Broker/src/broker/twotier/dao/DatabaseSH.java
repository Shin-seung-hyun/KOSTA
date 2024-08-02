package broker.twotier.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import broker.twotier.exception.DuplicateSSNException;
import broker.twotier.exception.InvalidTransactionException;
import broker.twotier.exception.RecordNotFoundException;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.SharesRec;
import broker.twotier.vo.StockRec;
import config.ServerInfo;

public class DatabaseSH implements DatabaseTemplate{
	
	private static DatabaseSH db = new DatabaseSH();
	private DatabaseSH()  {
		try {
			
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
	}
	public static DatabaseSH getInstance() {
		return db;
	}

	@Override
	public Connection getConnect() throws SQLException {
		
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("디비 연결 성공");
		
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps != null) ps.close();
		if(conn != null) conn.close();
		
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		
		if(rs != null) rs.close();
		closeAll(ps, conn);
		
	}
	
	//존재 유무를 확인하는 비즈니스 로직
	private boolean isExist(String ssn, Connection conn) throws SQLException{
		String query = "select ssn from customer where ssn =?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, ssn);
		
		ResultSet rs = ps.executeQuery();
		return rs.next();
		
	}
	
	
	/////////////////////////////////////////////////////////  비즈니스 로직 /////////////////////////////////////////////////////////////
	@Override
	public void addCustomer(CustomerRec cust) throws SQLException, DuplicateSSNException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			if(!isExist(cust.getSsn(), conn)) { // 추가하려는 ssn이 존재하지 않는다면

				String query = "insert into customer(ssn,cust_name,address) values (?,?,?)";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, cust.getSsn());
				ps.setString(2, cust.getName());
				ps.setString(3, cust.getAddress());
				
				System.out.println(ps.executeUpdate() + " 명 insert ok .. addCustomer...");
			}
			else {
				throw new DuplicateSSNException(" 고객님은 이미 회원이십니다.");
			}
			
		}finally {
			closeAll(ps, conn);
		}
		
	}

	@Override
	public void deleteCustomer(String ssn) throws SQLException, RecordNotFoundException {
		Connection conn =null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			if( isExist(ssn, conn)) {
				String query = "delete from customer where ssn =?";
				
				ps = conn.prepareStatement(query);
				ps.setString(1, ssn);
				
				System.out.println(ps.executeUpdate() + " 명 delete ok .. deleteCustomer ");
				
			}
			else {
				throw new RecordNotFoundException("삭제할 고객이 없습니다.");
			}
			
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void updateCustomer(CustomerRec cust) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			if(isExist(cust.getSsn(), conn)) {
				
				String query = "update customer set cust_name =?, address = ? where ssn =?";		
				ps = conn.prepareStatement(query);
				ps.setString(1, cust.getName());
				ps.setString(2, cust.getAddress());
				ps.setString(3, cust.getSsn());
				
				System.out.println(ps.executeUpdate() + " 명 update ok .. updateCustomer");
				
			}
			else {
				throw new RecordNotFoundException("수정할 고객이 없습니다.");
			}
			
		} finally {
			closeAll(ps, conn);
		}
		
	}

	@Override
	public ArrayList<SharesRec> getPortfolio(String ssn) throws SQLException {
		ArrayList<SharesRec> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			
			String query = " select ssn, symbol, quantity from shares where ssn =?";
			
			ps = conn.prepareStatement(query);
			ps.setString(1, ssn);
			rs = ps.executeQuery();
			
			while(rs.next()){
				list.add( new SharesRec( rs.getString(1), rs.getString(2), rs.getShort(3)));	
			}
		
			
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return list;
	}

	
	// 주식을 보유한 사용자의 보유 지식 리스트를 
	@Override
	public CustomerRec getCustomer(String ssn) throws SQLException {
		
		CustomerRec customer = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =  null;
		
		try {
			conn = getConnect();
			
			if( isExist(ssn, conn)) {
				String query = " select ssn, cust_name, address from customer where ssn =?";
				
				ps = conn.prepareStatement(query);
				ps.setString(1, ssn);
				rs = ps.executeQuery();
				
				rs.next();
				
				//customer = new CustomerRec(rs.getString(1), rs.getString(2), rs.getObject(query, null) );
				
				ArrayList<SharesRec> list = getPortfolio(ssn);
				
				if( list == null) { // 보유한 주식이 없는 사용자라면
					customer = new CustomerRec( ssn, rs.getString("cust_name"), rs.getString("address")); 
				}
				else customer = new CustomerRec( ssn, rs.getString("cust_name"), rs.getString("address"), list);
			}
			
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return customer;
	}

	@Override
	public ArrayList<CustomerRec> getAllCustomers() throws SQLException {
		
		ArrayList<CustomerRec> customers = new ArrayList<CustomerRec>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =  null;
		
		try {
			conn = getConnect();
			
			String query = " select ssn, cust_name, address from customer";
			
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			String ssn;
			while(rs.next()) {
				ssn = rs.getString(1);
				customers.add(getCustomer(ssn));
			}
			
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return customers;
	}

	@Override
	public ArrayList<StockRec> getAllStocks() throws SQLException {
		ArrayList<StockRec> stocks = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =  null;
		
		try {
			conn = getConnect();
			String query = " select ssn, symbol, quantity from shares";
			
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				stocks.add(new StockRec(rs.getString(1), rs.getFloat(2)));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		
		return stocks;
	}

	//주식 구매
	@Override
	public void buyShares(String ssn, String symbol, int quantity) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =  null;
		
		try {
			conn = getConnect();

			CustomerRec consumer = getCustomer(ssn);
			ArrayList<SharesRec> list = consumer.getPortfolio();
			
			System.out.println(list.size());
			
			if(list.size() !=0) {
				
				//보유 주식을 또 사는 경우
				for( SharesRec r : list)
					if(r.getSymbol() == symbol) {
						String query = " update shares set quantity = ? where ssn =?";
						ps = conn.prepareStatement(query);
						ps.setInt(1,r.getQuantity()+ quantity );
						ps.setString(2,ssn);
						ps.executeUpdate();
						
						System.out.println("주식 구매 성공");
					}
					return;
			}
			
			//새로운 주식을 사는 경우
			String query = "insert into shares(ssn, symbol, quantity) values(?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, ssn );
			ps.setString(2,symbol);
			ps.setInt(3,quantity);
			ps.executeUpdate();
			
			System.out.println("주식 구매 성공");			
			
		}finally {
			closeAll(rs, ps, conn);
		}

	}

	@Override
	public void sellShares(String ssn, String symbol, int quantity)
			throws SQLException, InvalidTransactionException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =  null;
		
		try {
			conn = getConnect();

			CustomerRec consumer = getCustomer(ssn);
			ArrayList<SharesRec> list = consumer.getPortfolio();
			
			System.out.println(list.size());
			
			if(list.size() !=0) {
				for( SharesRec r : list) {
					
					if(r.getSymbol().equals(symbol)) {
				
						
						// 전체 주식을 파는 경우
						if( r.getQuantity() == quantity) {
					
							String query = " delete from shares where ssn =?";
							ps.setString(1,ssn);
							ps = conn.prepareStatement(query);
							ps.executeUpdate();
							
							System.out.println("주식 판매 성공");
							
							return;
						}

						// 보유 주식 중 일부만 파는 경우
						else if(r.getQuantity() > quantity ) {
							
							String query = "update shares set quantity = ? where ssn =?";
							ps = conn.prepareStatement(query);
							ps.setInt(1,r.getQuantity()- quantity );
							ps.setString(2,ssn);
							ps.executeUpdate();
							
							System.out.println("일부 판매 성공");
							return;
						}
						
						else {
							System.out.println("판매 수량을 초과했습니다.");
							return;
						}
						
					}
				}
				System.out.println("해당 주식을 보유하고 있지 않습니다.");
				
			}
			System.out.println(" 주식을 보유하고 있지 않습니다.");
			
			
			

			
		}finally {
			closeAll(rs, ps, conn);
		}
		
		
	}
	
	
	/////////////////////////////////////////////////////////  단위 테스트 용도 /////////////////////////////////////////////////////////////
	
	public static void main(String arg[]) throws SQLException, DuplicateSSNException, RecordNotFoundException, InvalidTransactionException { // 단위 테스트 용도
		DatabaseSH db = DatabaseSH.getInstance();
		
		//db.addCustomer(new CustomerRec("111-120", "shin", "Busan"));
		//db.deleteCustomer("111-120");
		//db.updateCustomer(new CustomerRec("111-119", "shin", "Busan"));
		
		//db.getPortfolio("111-111").stream().forEach(System.out::println);
		//db.getCustomer("111-111").toString();
		System.out.println();
		//db.getAllCustomers().stream().forEach(System.out::println);
		
		//db.buyShares("111-112", "JDK", 5);
		
		db.sellShares("111-111", "JDK", 5);
		
	
	}
	

}