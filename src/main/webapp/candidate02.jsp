<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.ac.kopo.kopo08.domain.Hubo, kr.ac.kopo.kopo08.service.HuboServiceImpl,
	kr.ac.kopo.kopo08.service.HuboService" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보등록 확인</title>
<link rel="stylesheet" type="text/css" href="./navigation.css">
<link rel="stylesheet" type="text/css" href="./bodyAndTable.css">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</head>
<body>
	<div id="box">
		<div id="nav-box">
			<nav class="gnb">
				<ul class="nav-container">
					<li class="nav-item"><a href="./index.html"><i class="fas fa-chart-pie"></i>&nbsp Vote</a></li>
					<li class="nav-item checked"><a href="./candidate01.jsp">후보등록</a></li>
					<li class="nav-item"><a href="./vote01.jsp">투표</a></li>
					<li class="nav-item"><a href="./showResult01.jsp">개표결과</a></li>
				</ul>
			</nav>
		</div>
		<section>
			<h1 id="header"><i class="far fa-address-card"></i>&nbsp후보 등록</h1>
			<hr>
			<div id="content-wrap">
			<%
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("name");
			
			HuboService huboService = HuboServiceImpl.getInstance();
			Hubo hubo = new Hubo();
			hubo.setName(name);
			
			try {
				huboService.create(hubo);
				out.print("<center><h3>" + name + "님의 후보 등록이 완료되었습니다</h3></center>");
			} catch (Exception e) {
				String err = e.getMessage();
				if (err.contains("Duplicate")) {
					out.print("<center><h3>중복된 입력입니다</h3></center>");
				}
			}
			%>
			</div>
		</section>
	</div>
</body>
</html>