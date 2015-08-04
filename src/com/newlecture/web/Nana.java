package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 0625
 */
/**
 * Servlet implementation class Nana
 */
@WebServlet("/hello")
public class Nana extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//한글깨짐방지
		response.setCharacterEncoding("UTF-8"); //던지는 문자의 인코딩형식 세팅 
		response.setContentType("text/html; charset=UTF-8"); //현재 페이지의 문자타입이 무엇인지 세팅. 이것에 맞게 문자형을 출력
		
		String _cnt = request.getParameter("cnt"); // 사용자 입력값을 받는 임시변수
		
		int cnt = 10;
		if(_cnt != null && !_cnt.isEmpty())
			cnt = Integer.parseInt(_cnt);

		// 출력
		PrintWriter out = response.getWriter();
		for(int i=0; i<cnt; i++)			
			out.printf("<b>%d</b> hello 안녕<br>\n", i+1);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//한글깨짐방지
				response.setCharacterEncoding("UTF-8"); //던지는 문자의 인코딩형식 세팅 
				response.setContentType("text/html; charset=UTF-8"); //현재 페이지의 문자타입이 무엇인지 세팅. 이것에 맞게 문자형을 출력

		//form이 필요
		String _x = request.getParameter("x");
		String _y = request.getParameter("y");
		
		int x=0;
		int y=0;
		
		if(_x != null && !_x.isEmpty())
			x = Integer.parseInt(_x);
		
		if(_y != null && !_y.isEmpty())
			y = Integer.parseInt(_y);
		
		int result = x+y;
		
		PrintWriter out = response.getWriter();
		
		out.write("<form action=\"hello\" method=\"post\">");
		out.write("	<ul>");
		out.write("		<li><label for = \"x\">X: </label><input name=\"x\" /></li>");
		out.write("		<li><label for = \"y\">Y: </label><input name=\"y\" /></li>");
		out.write("	</ul>");
		out.write("	<p><input type = \"submit\" value=\"덧셈\" /></p>");
		out.write("</form>");
		out.printf("덧셈결과 : %d<br>", result);
	}
	
	

}
