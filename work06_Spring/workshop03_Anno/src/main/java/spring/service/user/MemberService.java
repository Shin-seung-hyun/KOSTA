package spring.service.user;

import java.util.List;

import spring.service.domain.MemberVO;

public interface MemberService {
	
	void registerMember(MemberVO member);
	void updateMember(MemberVO member);
	MemberVO getMember(String id);
	List<MemberVO>showAllMember(MemberVO member);

}
