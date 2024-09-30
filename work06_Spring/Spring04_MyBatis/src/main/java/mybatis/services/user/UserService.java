package mybatis.services.user;

import java.util.List;

import mybatis.services.domain.User;

//데이터 가공과 연관되는 레이어
public interface UserService {
	
	
	void addUser(User user)throws Exception;
	
	//delete는 데이터 가공과 상관없다.
	//void removeUser(String userId)throws Exception;
	
	int updateUser(User user)throws Exception;
	
	//service 레이어와 직결되는 메소드
	User getUser(String userId) throws Exception;
	List<User> getUserList(User user) throws Exception;	
	
}
