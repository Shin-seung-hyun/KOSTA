package spring.service.dao;


//비즈니스 로직의 템플릿을 담고 있어야 한다.
public interface MemberDAO {
	
	void register(String id, String pass);
	void delete(String id);
	
}
