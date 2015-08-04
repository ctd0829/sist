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
		
		NoticeDao ND = new MyBatisNoticeDao(); //강한결합
		List<Notice> list = ND.getNotices();
		
		//dispatcher가 포워드 하기 위해서는 모델값과 뷰로 사용할 URL이 필요.
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/view/customer/notice.jsp");
		mv.addObject("list", list);
		
		/*//포워드 = 이어서 / 리디렉트 = 닫고
		request.setAttribute("list", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/customer/notice.jsp");
		dispatcher.forward(request,response);*/
			
		return mv;
	}
	
}
