package com.newlecture.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//Controller��� ����
@Controller
@RequestMapping("/joinus/*")
public class JoinusController {

/*	private MemberDao memberDao;

	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
*/
	
	//����� ��û URL=�Լ���(�Լ����� ū �ǹ̰� ����. ���� �˾ƺ��� ���� �ϱ� ����) �� ������̼����� ����
	@RequestMapping("login")
	public String login(){
		
		return "joinus.login";
	}
	
/*	@RequestMapping(value="login", method=RequestMethod.POST)
	public String notice(Model model){
		
		return "/WEB-INF/view/joinus/login.jsp";
	}*/
	

}
