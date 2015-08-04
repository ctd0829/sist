<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	/* if(request.getMethod().equals("POST")){ //포스트 요청이라면... '=='는 주소비교 equals는 값비교
		String title = request.getParameter("title");
		String file = request.getParameter("file");
		String content = request.getParameter("content");
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setWriter("csy");
		notice.setContent(content);

		NoticeDao noticeDao = new MyBatisNoticeDao();
		noticeDao.addNotice(notice);
		
		response.sendRedirect("notice.jsp");
	} */

%>
				<div id="content">
					<h2>공지사항</h2>
					<h3 class="hidden">방문페이지위치</h3>
					<ul id="breadscrumb" class="block_hlist">
						<li>HOME</li>
						<li>
							고객센터
						</li>
						<li>
							공지사항등록
						</li>
					</ul>
					<div id="notice-article-detail" class="article-detail margin-large" >
						<form action="" method="post" enctype="multipart/form-data">
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								제목
							</dt>
							<dd class="article-detail-data">
								&nbsp;<input name="title"/>
							</dd>
						</dl>				
												
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								첨부파일
							</dt>
							<dd class="article-detail-data">
								&nbsp;<input type="file" id="txtFile" name="file" />
							</dd>
						</dl>

						<div class="article-content" >
							<textarea id="txtContent" class="txtContent" name="content"></textarea>
						</div>
						
						<p class="article-comment margin-small">						
							<input class="btn-save button" type="submit" value="저장" />
							<a class="btn-cancel button" href="notice">취소</a>						
						</p>
													
						</form>
					</div>
				</div>	
