package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.mybatis.SqlNewlecSessionFactory;
import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.vo.Notice;

public class MyBatisNoticeDao implements NoticeDao{
	
	@Autowired
	private SqlSession session;
	
	//SqlSessionFactory factory = new SqlNewlecSessionFactory().getSqlSessionFactory();

/*	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
	}*/

	@Override
	public List<Notice> getNotices(int page, String field, String query) {
		
		//SqlSession session = factory.openSession();
		NoticeDao dao = session.getMapper(NoticeDao.class);
		NoticeFileDao fileDao = session.getMapper(NoticeFileDao.class);
		
		List<Notice> list = dao.getNotices(page, field, query);

		for(Notice n:list)
			n.setFiles(fileDao.getNoticeFilesOfNotice(n.getCode()));

		return list;
	}

	@Override
	public Notice getNotice(String code) {
		//SqlSession session = factory.openSession();
		NoticeDao dao = session.getMapper(NoticeDao.class);
		
		return dao.getNotice(code);
	}

	@Override
	public List<Notice> getNotices(int page) {
		// TODO Auto-generated method stub
		return getNotices(page, "TITLE", "");
	}

	@Override
	public List<Notice> getNotices() {
		
		return getNotices(1, "TITLE", "");
	}

	@Override
	public int addNotice(Notice notice) {
		NoticeDao dao = session.getMapper(NoticeDao.class);
		
		return dao.addNotice(notice);
		
		/*int result = 0;
		
		//SqlSession session = factory.openSession(); // true = autocommit
		try{
			NoticeDao dao = session.getMapper(NoticeDao.class);
			
			result = dao.addNotice(notice);
			session.commit();
				
		}finally{
			session.rollback();
			session.close();
		}
		return result;*/
	}

	@Override
	public String getLastCode() {
		
		//SqlSession session = factory.openSession();
		NoticeDao dao = session.getMapper(NoticeDao.class);
		
		
		return dao.getLastCode();
	}


}
