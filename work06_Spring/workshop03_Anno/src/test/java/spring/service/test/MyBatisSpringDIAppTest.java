package spring.service.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.domain.MemberVO;
import spring.service.user.MemberDAO;
import spring.service.user.MemberService;

public class MyBatisSpringDIAppTest {
	
	public static void main(String[] args) throws Exception{
	
		ApplicationContext context =
				new ClassPathXmlApplicationContext(
								new String[] {"/bean/memeberservice.xml" });
		
		MemberService memberService = (MemberService)context.getBean("memberServiceImpl");
		
		MemberVO member = new MemberVO("abcd", "1234", "홍종각", "종각");
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		System.out.println(":: 1. registerMember(INSERT)  ? ");
		memberService.registerMember(member);
	
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		System.out.println(":: 2. update(UPDATE)  ? ");
		member.setName("장보고");
		memberService.updateMember(member);
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		System.out.println(":: 3. get(SELECT)  ? "+ member);
		member = memberService.getMember(member);
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		System.out.println(":: 4. all User(SELECT)  ? ");
		List<MemberVO> list = memberService.showAllMember(member);
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.print( "<"+ ( i +1 )+"> 번째 회원 정보... ");
			System.out.println( list.get(i).toString() );
		}
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//==> MemberService 에는 deleteMember 없으므로, DAO에서 직접 호출 Test
		MemberDAO memberDAO = (MemberDAO)context.getBean("memberDAOImpl");
		System.out.println(":: 5. remove(DELETE)  ? ");
		memberDAO.deleteMember("abcd");
		
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		System.out.println(":: 6. login(DELETE)  ? " + memberDAO.login(member));
		
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		System.out.println(":: 7. idExist(DELETE)  ? " + memberDAO.idExist(member.getId()) );
	
	}
	
	

}
