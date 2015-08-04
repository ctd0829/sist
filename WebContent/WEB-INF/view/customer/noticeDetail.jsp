<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
/* 	NoticeDao noticeDao = new MyBatisNoticeDao();
	
	String code = request.getParameter("c");
	
	Notice n = noticeDao.getNotice(code);
	
	request.setAttribute("n", n); */
%>    
    
				<div id="content">
					<h2>공지사항</h2>
					<h3 class="hidden">방문페이지위치</h3>
					<ul id="breadscrumb" class="block_hlist">
						<li id="home">
							<a href="">HOME</a>
						</li>
						<li>
							<a href="">고객센터</a>
						</li>
						<li>
							<a href="">공지사항</a>
						</li>
					</ul>
					<div id="notice-article-detail" class="article-detail margin-large" >						
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								제목
							</dt>
							<dd class="article-detail-data">
								${requestScope.n["title"]}
							</dd>
						</dl>
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								작성일
							</dt>
							<dd class="article-detail-data">								
								<fmt:formatDate value="${requestScope.n.regDate}" pattern="yyyy-MM-dd"/>
							</dd>
						</dl>
						<dl class="article-detail-row half-row">
							<dt class="article-detail-title">
								작성자
							</dt>
							<dd class="article-detail-data half-data" >
								${n.writer}
							</dd>
						</dl>
						<dl class="article-detail-row half-row">
							<dt class="article-detail-title">
								조회수
							</dt>
							<dd class="article-detail-data half-data">
								${n.hit}
							</dd>
						</dl>
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								첨부파일
							</dt>
							<dd class="article-detail-data">
								<a href="download?f=${nf.name}">${nf.name}</a>
								<!-- <a href="uplode/aa.bmp">aa.bmp</a> -->
								<!-- <a href="">flag.png</a> -->
							</dd>
						</dl>

						<div class="article-content" >
							<img src="download?f=${nf.name}"/>
							<!-- <img src="http://sstatic.naver.net/keypage/outside/info/2011031017145546407.jpg" /><br />
								동해물과 백두산이 마르고 닳도록 -->
							${n.content}
						</div>
					</div>
					<p class="article-comment margin-small">
						<a class="btn-list button" href="notice">목록</a>						
						<a class="btn-edit button" href="noticeEdit.jsp">수정</a>
						<a class="btn-del button" href="noticeDel.jsp">삭제</a>
					</p>
					<div class="margin-small" style="border-top: 1px solid #dfdfdf;">
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								▲ 다음글
							</dt>
							<dd class="article-detail-data">
								다음 글이 없습니다.
							</dd>
						</dl>
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								▼ 이전글
							</dt>
							<dd class="article-detail-data">
								제 12회 창업스쿨
							</dd>
						</dl>
					</div>					
				</div>	