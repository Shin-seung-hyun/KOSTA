package mybatis.services.user.test;


import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.services.domain.User;

/*
 * FileName : MyBatisTestApp05.java
  * ㅇ SqlMapConfig01.xml / mybatis-userservice-mapping05.xml
  * ㅇ My Framework 이용 QUERY ( SELECT ) TEST 
  */
public class MyBatisTestApp05 {
	///Main method
	public static void main(String[] args) throws Exception{
		
		Reader reader=Resources.getResourceAsReader("config/SqlMapConfig01.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();
		
		//==> Test 용 User instance 생성 및 age / regData null setting
		//==>@@@ null값을 허용할려면 SqlMapConfig01.xml에 Settings 태그를 부착해야한다.@@@
		User user = new User("user04","주몽","user04",null,1);
		user.setRegDate(null);
		
	
		//1. User05.addUser Test  :: users table age/grade/redDate 입력값 확인할것 : OK 
		System.out.println(":: 1. addUser(INSERT)  ? "
												+ session.insert("UserMapper05.addUser", user)); //1.
		session.commit();
		System.out.println("\n");
		
		
		//2. User05.addUser Test :: users table age/grade/redDate 입력값 확인할것 : OK
		// id 변경.. pk 변경으로 새로운 User 생성됨
		user.setUserId("user05");
		System.out.println(":: 2. addUser(INSERT)  ? "
										+ session.insert("UserMapper05.addUser", user));//1
		session.commit();
		System.out.println("\n");
		
		
		//3. User05.uadateUser Test  :: users table age/redDate 입력값 확인할것 : OK
		//                                                    :: 주몽 ==> 온달 수정
		//user05,주몽 -> 온달로 변경
		user.setUserName("온달");
		System.out.println(":: 3. update(UPDATE)  ? "
													+ session.update("UserMapper05.updateUser", user));//1
		session.commit();
		System.out.println("\n");
		
		//4. user05 id를 가진 사람을 삭제하는 단위 테스트를 작성
		System.out.println(":: 3. delete(DELETE)  ? "
												+ session.delete("UserMapper05.removeUser", user.getUserId())); // user05,1
		session.commit();
		
	}
}







