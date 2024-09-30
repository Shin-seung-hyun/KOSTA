package mybatis.services.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import mybatis.services.domain.User;
import mybatis.services.user.UserDAO;

/*
 Componet
  
  Layer 별로 조금 더 디테일하게 부를 수 있는 명칭이 있다.
  1. Presentation Layer | 2. Service Layer | 3. Persistance Layer
     @Controller             @Service             @Repository
  
 */

@Repository
public class MyBatisUserDAOImpl13 implements UserDAO{

	
	//Dependency Injection :: MyBatis의 SqlSession이 필요하다 :: setter 주입해보자
	
	@Autowired
	private SqlSession sqlSession;
	
	public static final String NS = "UserMapper10.";

	@Override
	public int addUser(User user) throws Exception {
		int result = sqlSession.insert(NS + "addUser", user);
		//sqlSession.commit();
		
		return result;
	}

	@Override
	public int removeUser(String userId) throws Exception {
		int result = sqlSession.delete(NS  + "removeUser", userId);
		//sqlSession.commit();
		
		return result;
	}

	@Override
	public int updateUser(User user) throws Exception {
		int result = sqlSession.update( NS + "updateUser", user);
		//sqlSession.commit();
		
		return result;
	}

	@Override
	public User getUser(String userId) throws Exception {
		
		return sqlSession.selectOne(NS + "getUser" , userId);
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		
		return sqlSession.selectList(NS + "getUserList" , user);
	}

}
