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

//Controller��� ����
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
	
	//����� ��û URL=�Լ���(�Լ����� ū �ǹ̰� ����. ���� �˾ƺ��� ���� �ϱ� ����) �� ������̼����� ����
	@RequestMapping("notice")
	public String notice(Model model){
		//NoticeDao ND = new MyBatisNoticeDao(); //���Ѱ���
		List<Notice> list = noticeDao.getNotices();
		
		//ModelAndView mv = new ModelAndView();
		//mv.setViewName("/WEB-INF/view/customer/notice.jsp");
		//mv.addObject("list", list);
		
		model.addAttribute("list", list);
		
		return "customer.notice";
	}
	@RequestMapping("noticeDetail")
	public String noticeDetail(String c, Model model){
		//NoticeDao ND = new MyBatisNoticeDao(); //���Ѱ���
		Notice n = noticeDao.getNotice(c);
		
		model.addAttribute("n", n);
		
		NoticeFile nf = noticeFileDao.getNF(c);
		model.addAttribute("nf", nf);
		
		return "customer.noticeDetail";
	}
	
	
	@RequestMapping(value="noticeReg", method=RequestMethod.GET)
	public String noticeReg(){
		//get��û
		return "customer.noticeReg";
	}
	@RequestMapping(value="noticeReg", method=RequestMethod.POST)
	public String noticeReg(Notice n, MultipartFile file, Principal principal,
			HttpServletRequest request, //SecurityContextHolder holder,
			SecurityContext context) throws IOException{
		//���ڴ� n���� ������ file���� / ���� ��ü�� n�� setter�� ���� �޴� ��쵵 ����
		//post��û
		
		if(request.isUserInRole("ROLE_ADMIN")){
			
		}
		
		//holder.getContext();
		context.getAuthentication().getAuthorities();
		context.getAuthentication().isAuthenticated();//������ ������ �ִ���(login�ߴ���)

		//Part part = request.getPart("file");
		ServletContext application = request.getServletContext();
		
		String url = "/resource/customer/upload";
		String path = application.getRealPath(url); // ����� ��θ� ������ ��η�...
		String temp = file.getOriginalFilename();//part.getSubmittedFileName();
		String fname = temp.substring(temp.lastIndexOf("\\")+1);
		String fpath = path +"\\"+ fname;

		if (!file.isEmpty()){
			InputStream ins = file.getInputStream();//part.getInputStream(); //stream = ����(��) ����
			OutputStream outs = new FileOutputStream(fpath);
			
			byte[] ��� = new byte[1024]; // ��� ũ�� = 1024
			int len = 0;
			
			
			while((len = ins.read(���, 0, 1024))>=0)
				outs.write(���, 0, len); //�о�� ��ŭ
			
			outs.flush();
			outs.close();
			ins.close();
		}
		n.setWriter(principal.getName()); //����� ID�� �޾ƿ�
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
