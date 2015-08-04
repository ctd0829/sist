package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * 0626
 */

@WebServlet("/myPage")
public class MyPage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//한글깨짐방지
		response.setCharacterEncoding("UTF-8"); //던지는 문자의 인코딩형식 세팅 
		response.setContentType("text/html; charset=UTF-8"); //현재 페이지의 문자타입이 무엇인지 세팅. 이것에 맞게 문자형을 출력
		
		ServletContext application = request.getServletContext(); //어플리케이션 저장소
		HttpSession session = request.getSession(); //세션 저장소
		
		PrintWriter out = response.getWriter();
		
		int app = 0;
		int ss = 0;
		int ck = 0;
		
		Object _app = application.getAttribute("app");
		Object _ss = session.getAttribute("ss");
		
		Cookie[] cookies = request.getCookies();
		String _ck = "";
		
		if(cookies != null)
			for (Cookie cookie : cookies)
				if("ck".equals(cookie.getName())) // 꺼낸 쿠키의 이름이 찾고자 하는 것과 같은가
					_ck = cookie.getValue();
		
		if(_app != null)
			app = (int) _app;
		
		if(_ss != null)
			ss = (int) _ss;
		
		if(_ck != null)
			ck = Integer.parseInt(_ck);
		
		out.printf("Application: %d<br>", app);
		out.printf("Session: %d<br>", ss);
		out.printf("Cookie: %d<br>", ck);
		out.println("<a href=\"add\">이전페이지</a>");

	}

}
