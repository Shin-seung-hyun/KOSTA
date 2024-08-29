package web.servlet.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProductDAOImpl implements ProductDAO {
	
	private DataSource ds = null;
	
	private static final ProductDAOImpl dao = new ProductDAOImpl();
	private ProductDAOImpl() {
		//Naming Service 작업을 진행...
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql"); //컨테이너에서 외부로 접근할 때 java:comp/env/.... 문법 사용
			System.out.println("DataSource lookup...Success~~!!");
		} catch(NamingException e) {
			System.out.println("DataSource lookup...Fail~~!!");
		}
	}
	public static ProductDAOImpl getInstance() { return dao; }

	//공통적인 로직
	@Override
	public Connection getConnect() throws SQLException {
		System.out.println("디비 연결 성공...");
		return ds.getConnection(); //Pool 에서 하나씩 꺼내오는 방식
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

	@Override
	public void registerProduct(Product vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			String query = "INSERT INTO product(name, price, detail) VALUES(?,?,?)";
			
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getName());
			ps.setInt(2, vo.getPrice());
			ps.setString(3, vo.getDetail());
			
			ps.executeUpdate();
		} finally {
			closeAll(ps, conn);
		}
		
	}

	@Override
	public ArrayList<Product> findProducts() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<Product> list = new ArrayList<Product>();
		
		try {
			conn = getConnect();
			String query = "SELECT product_no, name, price, detail FROM product";
			
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Product(rs.getInt("product_no"), rs.getString("name"), rs.getInt("price"), rs.getString("detail")));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
		
	}
	
	
}
