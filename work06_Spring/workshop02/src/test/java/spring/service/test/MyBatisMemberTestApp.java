package spring.service.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import spring.service.domain.MemberVO;

public class MyBatisMemberTestApp {

	public static void main(String[] args) throws IOException {
	
		// 3. SqlSession 생성
		SqlSessionFactory factory = TestUtil.getFactory();
		SqlSession session = factory.openSession();
		System.out.println("SqlSession .. Creating ...");
		
//		//회원가입 ID – registerMember
//		MemberVO pvo = new MemberVO();
//		pvo.setAddress("종각");
//		pvo.setId("mybatis");
//		pvo.setName("홍길동");
//		pvo.setPassword("12345");
//		
//		session.insert("MemberMapper.registerMember", pvo);
//		System.out.println(pvo.getName() + "님 회원 등록 성공^^");
//		System.out.println();
//		
//		//전체회원보기 ID - findAllMember
//		session.selectList("MemberMapper.findAllMember")
//			.forEach(c -> System.out.println(c));

		
		//아이디가 k로 시작하는 회원
		List<MemberVO> list =session.selectList("MemberMapper.getMember", "k" );
		list.forEach(c -> System.out.println(c));
		System.out.println();
		
		//아이디가 mybatis인 회원을 삭제
		int deleteResult = session.delete("MemberMapper.deleteMember", "mybatis");
		System.out.println("removeUser : "+deleteResult);
		
		session.commit();
		
		session.close();
		
	}

}
