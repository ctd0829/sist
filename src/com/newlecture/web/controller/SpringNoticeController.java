package com.newlecture.web.controller;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.mybatis.MyBatisNoticeDao;
import com.newlecture.web.vo.Notice;

public class SpringNoticeController implements Controller{
		
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		NoticeDao ND = new MyBatisNoticeDao(); //���Ѱ���
		List<Notice> list = ND.getNotices();
		
		//dispatcher�� ������ �ϱ� ���ؼ��� �𵨰��� ��� ����� URL�� �ʿ�.
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/view/customer/notice.jsp");
		mv.addObject("list", list);
		
		/*//������ = �̾ / ����Ʈ = �ݰ�
		request.setAttribute("list", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/customer/notice.jsp");
		dispatcher.forward(request,response);*/
			
		return mv;
	}
	
}
