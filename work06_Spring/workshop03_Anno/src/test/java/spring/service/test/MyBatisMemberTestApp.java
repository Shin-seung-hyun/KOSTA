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
		
		MemberVO member = new MemberVO("abcd", "5678","곽종각","종각");
		
		//registerMember
		System.out.println(":: 1. registerMember(INSERT)  ? "
												+ session.insert("MemberMapper.registerMember",member)); //1
												  session.commit();
        System.out.println();
		
		//getMember 
		System.out.println(":: 2. getMember(SELECT)  ? ");
		System.out.println(":: "+session.selectOne("MemberMapper.getMember", member.getId()) );
        System.out.println();													  
	  
		//updateMember : address
		member.setAddress("마포");
		member.setName("박마포");
		System.out.println(":: 3. updateMember(UPDATE)  ? "
													+ session.update("MemberMapper.updateMember", member));//1
											  		  session.commit();
		 System.out.println();
		 
		//showAllMember									  		  
		System.out.println(":: 4. showAllMember ?  이름이 같은 사람 출력");
		member.setName(null);
		TestUtil.printList((List) session.selectList("MemberMapper.showAllMember", member ));
        
		System.out.println(":: 4. showAllMember ?  전체 출력");
		member.setName(null);
		member.setAddress(null);
		TestUtil.printList((List) session.selectList("MemberMapper.showAllMember", member ));
        
		//idExist
		System.out.println(":: 5. idExist ? ");
		System.out.println(" :: " + session.selectOne("MemberMapper.idExist", member.getId()) );
        System.out.println();
		
		//login
		System.out.println(":: 6. login ? ");
		System.out.println(" :: " + session.selectOne("MemberMapper.login", member) );
        System.out.println();
		
		//deleteMember									  		  
  		System.out.println(":: 7. deleteMember (DELETE)  ? "
				+session.delete("MemberMapper.deleteMember",member.getId()) );
				 session.commit();		
			        		 						  		  
	}
}