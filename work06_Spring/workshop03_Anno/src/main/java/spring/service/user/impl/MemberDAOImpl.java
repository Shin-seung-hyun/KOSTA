package spring.service.user.impl;

import java.util.List;

import spring.service.domain.MemberVO;
import spring.service.user.MemberDAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	public static final String NS = "MemberMapper.";

	@Override
	public void registerMember(MemberVO member) {
		sqlSession.insert(NS + "registerMember", member);
	}

	@Override
	public MemberVO getMember(String id) {
		return sqlSession.selectOne(NS  + "getMember", id);
	}

	@Override
	public void updateMember(MemberVO member) {
		sqlSession.update( NS + "updateMember", member);
		
	}

	@Override
	public List<MemberVO> showAllMember(MemberVO member) {
		return sqlSession.selectList(NS + "showAllMember" , member);
	}

	@Override
	public boolean idExist(String id) {
		MemberVO vo = (MemberVO)sqlSession.selectOne(NS  + "idExist", id);
		
		if(vo == null) return false;
		else return true;
	}

	@Override
	public boolean login(MemberVO member) {
		
		MemberVO vo = (MemberVO)sqlSession.selectOne(NS  + "login", member);
		
		if(vo == null) return false;
		else return true;
	}

	@Override
	public void deleteMember(String id) {
		sqlSession.delete(NS  + "deleteMember", id);

	}

}
