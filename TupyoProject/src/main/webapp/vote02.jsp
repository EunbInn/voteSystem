<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.ac.kopo.kopo08.domain.Tupyo, kr.ac.kopo.kopo08.service.TupyoServiceImpl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표하기</title>
<link rel="stylesheet" type="text/css" href="./navigation.css">
<link rel="stylesheet" type="text/css" href="./bodyAndTable.css">
</head>
<body>
	<div id="box">
		<div id="nav-box">
			<nav class="gnb">
				<ul class="nav-container">
					<li class="nav-item"><a href="./index.html">투표 페이지</a></li>
					<li class="nav-item"><a href="./candidate01.jsp">후보등록</a></li>
					<li class="nav-item checked"><a href="./vote01.jsp">투표</a></li>
					<li class="nav-item"><a href="./showResult01.jsp">개표결과</a></li>
				</ul>
			</nav>
		</div>
		<section>
			<h1 id="header">투표 확인</h1>
			<hr>
			<div id="content-wrap">	
				<%
				//post로 보낸 값 가져오기
				request.setCharacterEncoding("UTF-8");
				String kihoName = request.getParameter("kihoName");
				int kiho = Integer.parseInt(kihoName.split("//")[0]);
				String name = kihoName.split("//")[1];
				int age = Integer.parseInt(request.getParameter("age"));
				
				//도메인과 서비스 클래스 객체 생성
				Tupyo tupyo = new Tupyo();
				TupyoServiceImpl tupyoService = new TupyoServiceImpl();
				
				//값 셋팅
				tupyo.setKiho(kiho);
				tupyo.setAge(age);
				
				//서비스의 insert담당 method호출하여 insert하도록 연결
				tupyoService.create(tupyo);
				
				response.sendRedirect("./vote03.jsp");
				%>
			</div>
		</section>
	</div>
</body>
</html>