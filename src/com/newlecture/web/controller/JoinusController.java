package com.newlecture.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//Controller라는 문패
@Controller
@RequestMapping("/joinus/*")
public class JoinusController {

/*	private MemberDao memberDao;

	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
*/
	
	//사용자 요청 URL=함수명(함수명은 큰 의미가 없음. 그저 알아보기 쉽게 하기 위함) 을 어노테이션으로 설정
	@RequestMapping("login")
	public String login(){
		
		return "joinus.login";
	}
	
/*	@RequestMapping(value="login", method=RequestMethod.POST)
	public String notice(Model model){
		
		return "/WEB-INF/view/joinus/login.jsp";
	}*/
	

}
