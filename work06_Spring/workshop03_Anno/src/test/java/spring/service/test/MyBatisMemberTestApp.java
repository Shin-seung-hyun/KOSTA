package spring.service.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import spring.service.domain.MemberVO;

public class MyBatisMemberTestApp {
	///Main method
	public static void main(String[] args) throws Exception{

		SqlSession session = null;
		SqlSessionFactory factory = TestUtil.getSqlSessionFactory();
		session=factory.openSession();
		
		MemberVO member = new MemberVO("abcd", "1234","홍종각","종각");
		
		//registerMember
		System.out.println(":: 1. registerMember(INSERT)  ? "
												+ session.insert("MemberMapper.registerMember",member)); //1
												  session.commit();
		
		//getMember 
		System.out.println(":: 2. getMember(SELECT)  ? ");
		System.out.println(" :: "+session.selectOne("MemberMapper.getMember", member.getId()) );
														  
	  
		//updateMember
		member.setName("홍마포");
		System.out.println(":: 3. updateMember(UPDATE)  ? "
													+ session.update("MemberMapper.updateMember",member));//1
											  		  session.commit();
											  		  
		//showAllMember									  		  
		System.out.println(":: 4. showAllMember ? ");
		member.setName(null);
		TestUtil.printList((List) session.selectList("MemberMapper.showAllMember", member ));

		//idExist
		System.out.println(":: 5. idExist ? ");
		System.out.println(" :: " + session.selectOne("MemberMapper.idExist", member.getId()) );
		
		
		//login
		System.out.println(":: 6. login ? ");
		System.out.println(" :: " + session.selectOne("MemberMapper.login", member) );
		
		
		//deleteMember									  		  
  		System.out.println(":: 7. deleteMember (DELETE)  ? "
				+session.delete("MemberMapper.deleteMember",member.getId()) );//1
				 session.commit();		
				 
				 
											  		  
	}
}