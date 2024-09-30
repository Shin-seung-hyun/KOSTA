package spring.service.user;

import java.util.List;

import spring.service.domain.MemberVO;


public interface MemberDAO {
	
	void registerMember(MemberVO member);
	MemberVO getMember(MemberVO member);
	void updateMember(MemberVO member);
	List<MemberVO>showAllMember(MemberVO member);
	boolean idExist(String id);
	boolean login(MemberVO member);
	void deleteMember(String id);

}
