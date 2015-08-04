package com.newlecture.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.vo.Member;

public class NewlecAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	private MemberDao memberDao;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		
		String uid = authentication.getName(); //우선적으로 로그인 사용자의 id필요
		//역활이 2가지 이상이면 안됨(역활별로 보여지는 페이지가 다르게 할 때) 기본역활을 테이블에 미리 설정해둠
		
		//dao는 IoC container에
		Member m = memberDao.getMember(uid);
		String type = m.getDefaultRole();
		
		String targetUrl = "/customer/notice";
		
		if(type.equals("ROLE_TEACHER"))
			targetUrl = "/customer/noticeDetail?c=5";
		
		RedirectStrategy redirectStrategy = new DefaultRedirectStrategy(); //targetUrl로 가라
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}
	
}
