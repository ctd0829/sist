package com.newlecture.web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.dao.mybatis.MyBatisNoticeDao;
import com.newlecture.web.dao.mybatis.MyBatisNoticeFileDao;
import com.newlecture.web.vo.Notice;
import com.newlecture.web.vo.NoticeFile;

//Controller라는 문패
@Controller
@RequestMapping("/customer/*")
public class CustomerController {

	private NoticeDao noticeDao;
	private NoticeFileDao noticeFileDao;

	
	@Autowired
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	@Autowired
	public void setNoticeFileDao(NoticeFileDao noticeFileDao) {
		this.noticeFileDao = noticeFileDao;
	}
/*	public CustomerController() {
		ND = new MyBatisNoticeDao();
	}*/
	
	//사용자 요청 URL=함수명(함수명은 큰 의미가 없음. 그저 알아보기 쉽게 하기 위함) 을 어노테이션으로 설정
	@RequestMapping("notice")
	public String notice(Model model){
		//NoticeDao ND = new MyBatisNoticeDao(); //강한결합
		List<Notice> list = noticeDao.getNotices();
		
		//ModelAndView mv = new ModelAndView();
		//mv.setViewName("/WEB-INF/view/customer/notice.jsp");
		//mv.addObject("list", list);
		
		model.addAttribute("list", list);
		
		return "customer.notice";
	}
	@RequestMapping("noticeDetail")
	public String noticeDetail(String c, Model model){
		//NoticeDao ND = new MyBatisNoticeDao(); //강한결합
		Notice n = noticeDao.getNotice(c);
		
		model.addAttribute("n", n);
		
		NoticeFile nf = noticeFileDao.getNF(c);
		model.addAttribute("nf", nf);
		
		return "customer.noticeDetail";
	}
	
	
	@RequestMapping(value="noticeReg", method=RequestMethod.GET)
	public String noticeReg(){
		//get요청
		return "customer.noticeReg";
	}
	@RequestMapping(value="noticeReg", method=RequestMethod.POST)
	public String noticeReg(Notice n, MultipartFile file, Principal principal,
			HttpServletRequest request, //SecurityContextHolder holder,
			SecurityContext context) throws IOException{
		//문자는 n으로 파일은 file으로 / 파일 자체를 n에 setter를 만들어서 받는 경우도 있음
		//post요청
		
		if(request.isUserInRole("ROLE_ADMIN")){
			
		}
		
		//holder.getContext();
		context.getAuthentication().getAuthorities();
		context.getAuthentication().isAuthenticated();//인증된 정보가 있는지(login했는지)

		//Part part = request.getPart("file");
		ServletContext application = request.getServletContext();
		
		String url = "/resource/customer/upload";
		String path = application.getRealPath(url); // 상대적 경로를 물리적 경로로...
		String temp = file.getOriginalFilename();//part.getSubmittedFileName();
		String fname = temp.substring(temp.lastIndexOf("\\")+1);
		String fpath = path +"\\"+ fname;

		if (!file.isEmpty()){
			InputStream ins = file.getInputStream();//part.getInputStream(); //stream = 저장(할) 버퍼
			OutputStream outs = new FileOutputStream(fpath);
			
			byte[] 대야 = new byte[1024]; // 대야 크기 = 1024
			int len = 0;
			
			
			while((len = ins.read(대야, 0, 1024))>=0)
				outs.write(대야, 0, len); //읽어온 만큼
			
			outs.flush();
			outs.close();
			ins.close();
		}
		n.setWriter(principal.getName()); //사용자 ID를 받아옴
		noticeDao.addNotice(n);
		String lastCode = noticeDao.getLastCode();
		
		if (!file.isEmpty()){
			NoticeFile noticeFile = new NoticeFile();
			noticeFile.setNoticeCode(lastCode);
			noticeFile.setName(fname);
			noticeFileDao.addNoticeFile(noticeFile);
		}
		
		return "redirect:notice";
	}

}
