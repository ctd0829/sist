package com.newlecture.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.vo.Member;

public class MyBatisMemberDao implements MemberDao{
	
	@Autowired
	private SqlSession session;
	
	//SqlSessionFactory factory = new SqlNewlecSessionFactory().getSqlSessionFactory();

	@Override
	public Member getMember(String uid) {
		
		//SqlSession session = factory.openSession(); //담겨진 dao를 꺼내오는 작업
		MemberDao dao = session.getMapper(MemberDao.class);//DAO는 오버로드 불가.
		
		return dao.getMember(uid);
	}


}
