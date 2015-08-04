package com.newlecture.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.mybatis.MyBatisNoticeDao;
import com.newlecture.web.vo.Notice;

public class NoticeConsole {

	NoticeDao noticeDao;

	@Autowired //class(=type) Resource가 선언되어있지 않아도 NoticeDao의 명의 bean의 id가 같으면 우선순위에 의해 실행됨.
	@Resource(name="noticeDao") //id
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	public void print() {
		
		List<Notice> list = noticeDao.getNotices();
		
		for(Notice n : list)
			System.out.printf("title : %s\n", n.getTitle());

	}
}
