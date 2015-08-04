package com.newlecture.web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.dao.mybatis.MyBatisNoticeDao;
import com.newlecture.web.dao.mybatis.MyBatisNoticeFileDao;
import com.newlecture.web.vo.Notice;
import com.newlecture.web.vo.NoticeFile;

/*@WebServlet("/customer/noticeReg")*/
@MultipartConfig(
		/*location = "/tmp",*/
		fileSizeThreshold = 1024*1024,
		maxFileSize = 1024*1024*5,
		maxRequestSize = 1024*1024*5*5
)
// maxFileSize�� 5�ް�, maxRequestSize�� 5�ް� 5������
public class NoticeRegController extends HttpServlet{
		
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		if(request.getMethod().equals("POST")){ //����Ʈ ��û�̶��... '=='�� �ּҺ� equals�� ����
			
			Part part = request.getPart("file");
			ServletContext application = request.getServletContext();
			
			String url = "/customer/upload";
			String path = application.getRealPath(url); // ����� ��θ� ������ ��η�...
			/* �̷� ����� ����
			StringBuilder sb = new StringBuilder();
			sb.append("D:\\jsp_filePath\\");
			sb.append(..);
			*/
			//String path = "D:\\jsp_filePath\\"; //fileoutputstream�� ����� ��δ� �ν����� ����
			String temp = part.getSubmittedFileName();
			String fname = temp.substring(temp.lastIndexOf("\\")+1);
			String fpath = path +"\\"+ fname;
			//response.getWriter().print(fpath);	
			
			if (!fname.isEmpty()){
				
				
				InputStream ins = part.getInputStream(); //stream = ����(��) ����
				OutputStream outs = new FileOutputStream(fpath);
				
				byte[] ��� = new byte[1024]; // ��� ũ�� = 1024
				int len = 0;
				
				// len = ins.read(���, 0, 1024); //�о�� ����
				while((len = ins.read(���, 0, 1024))>=0)
					outs.write(���, 0, len); //�о�� ��ŭ
				
				outs.flush();
				outs.close();
				ins.close();
				
			}
			
			String title = request.getParameter("title");
			String file = request.getParameter("file");
			String content = request.getParameter("content");
			
			Notice notice = new Notice();
			NoticeFile noticeFile = new NoticeFile();

			notice.setTitle(title);
			notice.setWriter("csy");
			notice.setContent(content);
			

			NoticeDao noticeDao = new MyBatisNoticeDao();
			noticeDao.addNotice(notice);
			
			if (!fname.isEmpty()){
				
			NoticeFileDao noticeFileDao = new MyBatisNoticeFileDao();
			noticeFile.setName(fname);
			noticeFile.setNoticeCode(noticeDao.getLastCode());
			noticeFileDao.addNoticeFile(noticeFile);
			}
			
			response.sendRedirect("notice");
		}else{			
			//������ = �̾ / ����Ʈ = �ݰ�
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/customer/noticeReg.jsp");
			dispatcher.forward(request,response);
			
		}
	}
	
}
