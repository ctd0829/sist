package com.newlecture.web.AOP;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.Proxy;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.mybatis.MyBatisNoticeDao;
import com.newlecture.web.dao.mybatis.SqlNewlecSessionFactory;
import com.newlecture.web.vo.Notice;

public class Program {
	// 150720
	static{ //main 전에 실행되는 영역
		SqlNewlecSessionFactory factory = new SqlNewlecSessionFactory();
		try {
			factory.init();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
	
		//NoticeDao noticeDao = new MyBatisNoticeDao();
		/*NoticeDao proxy = (NoticeDao)Proxy.newProxyInstance
				(noticeDao.getClass().getClassLoader(), 
						noticeDao.getClass().getInterfaces(),
						new InvocationHandler() {
							
							@Override
							public Object invoke(Object proxy, Method method, Object[] args)
									throws Throwable {
								
								System.out.println("사전");
								List<Notice> list = (List<Notice>)method.invoke(noticeDao, args);
								System.out.println("사후");
								
								return list;
							}
						});*/
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/newlecture/web/AOP/spring-context.xml");
		
		//List<Notice> list = proxy.getNotices();
		NoticeDao noticeDao = (NoticeDao) context.getBean("noticeDao");
		List<Notice> list = noticeDao.getNotices();
		// 두번 호출
		Notice notice = noticeDao.getNotice("5");

		for(Notice n : list)
			System.out.printf("제목 : %s\n", n.getTitle());
			
	}

}
