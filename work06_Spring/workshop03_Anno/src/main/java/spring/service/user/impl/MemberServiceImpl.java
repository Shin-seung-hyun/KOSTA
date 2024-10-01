package spring.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.service.domain.MemberVO;
import spring.service.user.MemberDAO;
import spring.service.user.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public void registerMember(MemberVO member) {
		memberDAO.registerMember(member);
	}

	@Override
	public void updateMember(MemberVO member) {
		memberDAO.updateMember(member);
	}

	@Override
	public MemberVO getMember(String id) {
		return memberDAO.getMember(id);
	}

	@Override
	public List<MemberVO> showAllMember(MemberVO member) {
		return memberDAO.showAllMember(member);
	}

}
