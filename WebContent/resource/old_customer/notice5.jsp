<%@page import="com.newlecture.web.vo.Notice"%>
<%@page import="java.util.List"%>
<%@page import="com.newlecture.web.dao.mybatis.MyBatisNoticeDao"%>
<%@page import="com.newlecture.web.dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl(core lib: 대부분 제어와 관련) 접두사와 처리기 선언-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 날짜포맷 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 코드블럭 -->
<%
	NoticeDao noticeDao = new MyBatisNoticeDao();
	List<Notice> list = noticeDao.getNotices();
	request.setAttribute("list", list);
%>
<!-- 지역변수 list를 request 저장소에 저장 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<header id="header">
		<!-- 제목 -->
		<h1>
			<img src="../images/logo.png" alt="뉴렉처" />
		</h1>

		<section class="h1">
			<h1>머릿말</h1>

			<!-- 목록 = u(unordered)l/순서없는, o(ordered)l/순서있는, d(data/definition)l/정의하는 -->
			<nav id="main-menu">
				<h1 style="color: blue;font-weight:bold">메인 메뉴</h1>
				<ul>
					<li><a href="">학습가이드</a></li>
					<li><a href="">뉴렉과정</a></li>
					<li><a href="">강좌선택</a></li>
				</ul>
			</nav>

			<!-- 폼 -->
			<section id="lecture-search-form">
				<h1 class="h1">강좌검색 폼</h1>
				<form>
					<fieldset>
						<legend>검색정보</legend>
						<label>과정검색</label> <input type="text" value="test"/> <input type="submit"
							value="검색" />
					</fieldset>
				</form>
			</section>

			<nav id="top">
				<h1>회원메뉴</h1>
				<ul>
					<li><a href="">HOME</a></li>
					<li><a href="">로그인</a></li>
					<li><a href="">회원가입</a></li>
				</ul>
			</nav>

			<nav>
				<h1>고객메뉴</h1>
				<ul>
					<li><a href="">마이페이지</a></li>
					<li><a href="">고객센터</a></li>
				</ul>
			</nav>
		</section>
	</header>

	<aside>
		<h1>고객센터</h1>

		<nav>
			<h1>고객센터메뉴</h1>
			<ul>
				<li><a href="">공지사항</a></li>
				<li><a href="">1:1고객문의</a></li>
				<li><a href="">학습안내</a></li>
			</ul>
		</nav>

		<nav>
			<h1>추천사이트</h1>
			<ul>
				<li><a href=""><img src="../images/answeris.png"
						alt="answeris" /></a></li>
				<li><a href=""><img src="../images/tune-a.png" alt="tune-a" /></a></li>
			</ul>
		</nav>
	</aside>

	<main>
	<section>
		<h1>공지사항</h1>

		<section>
			<h1>경로</h1>
			<ul>
				<li>HOME</li>
				<li>고객센터</li>
				<li>공지사항</li>
			</ul>
		</section>

		<section>
			<h1>공지사항 검색폼</h1>
			<form>
				<fieldset>
					<legend>공지사항 검색정보</legend>
					<label>검색필드</label> <select>
						<option>제목</option>
						<option>작성자</option>
					</select> <label>검색어</label> <input type="text" /> <input type="submit"
						value="검색" />
				</fieldset>
			</form>
		</section>

		<!-- 저장소에 있는 값만 el로 뽑아 쓸 수 있음 -->
		<section>
			<c:forEach var="i" begin="1" end="3">
			<h1>${i}공지사항 목록</h1>
			</c:forEach>
			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
				<%-- <%	for(int i=0;i<10;i++){ %> --%>
				<!-- list는 저장소 -->	
				<c:forEach var="n" items="${list}">			
					<tr> 
						<td>${n.code}</td>
						<td><a href="noticeDetail.jsp?c=${n.code}">${n.title}</a></td>
						<td>${n.writer}</td>
						<td><fmt:formatDate value="${n.regDate}" pattern="yyyy-MM-dd"/></td>
						<td>${n.hit}</td>						
					</tr>
				</c:forEach>
					<%-- <td><%=list.get(i).getHit() %></td> --%>
				<%-- <% } %> --%>	
				</tbody>
			</table>
			<div><input type="submit" value="글쓰기"/></div>
		</section>

		<section>
			<h1>현재 페이지</h1>
			<p>1 of 3pages</p>
		</section>

		<nav>
			<h1>페이저</h1>
			<ul>
				<li><a href="">1</a></li>
				<li><a href="">2</a></li>
				<li><a href="">3</a></li>
				<li><a href="">4</a></li>
				<li><a href="">5</a></li>
			</ul>
		</nav>
	</section>
	</main>

	<aside></aside>

	<footer>
		<section>
			<h1>뉴렉처</h1>

			<section>
				<h1>관리자 정보</h1>
				<dl>
					<dt>주소:</dt>
					<dd>서울특별시 동대문구 장안1동 423-4번지 윤진빌딩 4층</dd>
					<dt>관리자메일:</dt>
					<dd>admin@newlecture.com</dd>
					<dt>전화:</dt>
					<dd>02-478-4084 [죄송합니다. 당분간 문의내용은 고개센터 메뉴에서 1:1 문의를 이용해주시기
						바랍니다]</dd>
					<dt>사업자 등록번호:</dt>
					<dd>132-18-46763</dd>
					<dt>통신 판매업 신고제:</dt>
					<dd>2013-서울강동-0969 호 상호뉴렉처</dd>
					<dt>대표:</dt>
					<dd>박용우</dd>
					<dt>관리자:</dt>
					<dd>전성일</dd>
				</dl>
			</section>

			<section>
				<h1>저작권 정보</h1>
				<p>Copyright ⓒ newlecture.com 2012-2014 All Right Reserved.
					Contact admin@newlecture.com for more information</p>
			</section>
		</section>
	</footer>
</body>
</html>