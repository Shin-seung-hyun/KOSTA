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
		
		MemberVO member = new MemberVO("abcd", "5678","곽종각","종각");
		
		System.out.println(":: 1. registerMember(INSERT)  ? ");
		memberService.registerMember(member);
		System.out.println();
		
		member = memberService.getMember("abcd");
		System.out.println(":: 2. get(SELECT)  ? " + member);
		System.out.println();
		
		
		System.out.println(":: 3. update(UPDATE)  ? ");
		member.setAddress("마포");
		member.setName("박마포");
		memberService.updateMember(member);
		System.out.println();
		

		System.out.println(":: 4. all User(SELECT)  ? ");
		member.setName(null);
		member.setAddress(null);
		List<MemberVO> list = memberService.showAllMember(member);
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.print( "<"+ ( i +1 )+"> 번째 회원 정보... ");
			System.out.println( list.get(i).toString() );
		}
		System.out.println();

		//==> MemberService 에  없으므로, DAO에서 직접 호출 Test
		MemberDAO memberDAO = (MemberDAO)context.getBean("memberDAOImpl");
		System.out.println(":: 5. login(DELETE)  ? " + memberDAO.login(member));
		System.out.println();
		
		System.out.println(":: 6. idExist(DELETE)  ? " + memberDAO.idExist(member.getId()) );
		System.out.println();
		
		System.out.println(":: 7. remove(DELETE)  ? ");
		memberDAO.deleteMember("abcd");
		
	}
	
}
