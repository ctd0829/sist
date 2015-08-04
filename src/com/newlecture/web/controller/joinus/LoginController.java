package com.newlecture.web.controller.joinus;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.dao.mybatis.MyBatisMemberDao;
import com.newlecture.web.vo.Member;

//@WebServlet("/joinus/login")
public class LoginController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		if(request.getMethod().equals("POST")){
			
			//POST일때 받아올 내용
			String uid = request.getParameter("uid");
			String pwd = request.getParameter("pwd");
			
			MemberDao memberDao = new MyBatisMemberDao();
			Member m = memberDao.getMember(uid);
			
			if(m == null)
			{				
				request.setAttribute("error", "사용자 정보가 올바르지 않습니다.");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/joinus/login.jsp");
				dispatcher.forward(request,response);
				
			}
			else if(!m.getPwd().equals(pwd)){				
				request.setAttribute("error", "사용자 정보가 올바르지 않습니다.");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/joinus/login.jsp");
				dispatcher.forward(request,response);
			}
			else{				
				HttpSession session = request.getSession();
				session.setAttribute("uid", uid);//세션에 id를 넘겨줌
				
				response.sendRedirect("../customer/notice");
			}

			
		}
		else{			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/joinus/login.jsp");
			dispatcher.forward(request,response);
		}
	}
	

}
