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
		// chain전에(servlet 전에)
		request.setCharacterEncoding(encoding); // 다른 인코딩 방식도 설정가능하도록 변수사용
		chain.doFilter(request,response);

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		//톰캣이 필터를 실행(new) 따라서 xml에서 설정 (어노테이션'@'으로 설정하기도... /최근 선호도가 높으나 코드에 포함되므로 수정은 불가)
		encoding = config.getInitParameter("encoding");
		
	}

}
