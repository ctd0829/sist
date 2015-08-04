package com.newlecture.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(
		urlPatterns = {"/*"},
		initParams = {@WebInitParam(name="encoding", value="UTF-8")}
)
public class CharacterEncodingFilter implements Filter {
	private String encoding;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// chain����(servlet ����)
		request.setCharacterEncoding(encoding); // �ٸ� ���ڵ� ��ĵ� ���������ϵ��� �������
		chain.doFilter(request,response);

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		//��Ĺ�� ���͸� ����(new) ���� xml���� ���� (������̼�'@'���� �����ϱ⵵... /�ֱ� ��ȣ���� ������ �ڵ忡 ���ԵǹǷ� ������ �Ұ�)
		encoding = config.getInitParameter("encoding");
		
	}

}