<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, kr.ac.kopo.kopo08.domain.Hubo, kr.ac.kopo.kopo08.domain.Tupyo,
	kr.ac.kopo.kopo08.service.HuboServiceImpl, kr.ac.kopo.kopo08.service.TupyoServiceImpl,
	kr.ac.kopo.kopo08.service.TupyoService" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표 - 개표 확인</title>
<link rel="stylesheet" type="text/css" href="navigation.css">
<link rel="stylesheet" type="text/css" href="./bodyAndTable.css">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<style>
	#name {
		width: 140px;
		background-color: #EEEEEE;
		padding: 5px 2px 5px 15px;
		color: #393E46;
		text-align: left;
	}
	
	img {
		margin-top: 4px;
	}
	
	#back {
		margin-top: 10px;
		width: 95px;
		height: 35px;
		padding: 5px 15px;
		border: 2px solid #393E46;
		border-radius: 7px;
		background-color: #393E46;
		color: #EEEEEE;
		font-weight: bold;
		cursor: pointer;
	}
	
	#back:hover {
		background-color: #EEEEEE;
		color: #393E46;
	}
</style>
</head>
<%
String kiho = request.getParameter("kiho");
String name = request.getParameter("name");
%>
<body>
	<div id="box">
		<div id="nav-box">
			<nav class="gnb">
				<ul class="nav-container">
					<li class="nav-item"><a href="./index.html"><i class="fas fa-chart-pie"></i>&nbsp Vote</a></li>
					<li class="nav-item"><a href="./candidate01.jsp">후보등록</a></li>
					<li class="nav-item"><a href="./vote01.jsp">투표</a></li>
					<li class="nav-item checked"><a href="./showResult01.jsp">개표결과</a></li>
				</ul>
			</nav>
		</div>
			<section>
			<h1 id="header">
				<i class="fas fa-chart-bar"></i>&nbsp<%=name%>후보 득표 현황
			</h1>
			<hr>
			<div id="content-wrap">
				<div id="wrap">
					<table>
			<%
			TupyoService tupyoService = TupyoServiceImpl.getInstance();
			Tupyo tupyo;
			
			int kihoInt = Integer.parseInt(kiho);
			List<double[]> countPerAgeList = tupyoService.selectOneGroupbyAge(kihoInt);
			for (int i = 0; i < countPerAgeList.size(); i++) {
				double[] countPerAge = countPerAgeList.get(i);
				int age = (int) countPerAge[0];
				int count = (int) countPerAge[1];
				double percent = countPerAge[2];
				out.println("<tr>" +
								"<th id='name'>" + age +" 대</th>" +
								"<td>" + 
									"<img src='./line.PNG' style='width:" + (percent * 5) + "px; height:17px' alt=''>&nbsp" + 
									count + " (" + String.format("%.1f",percent) + "%)" + 
								"</td>" +
							"</tr>");
			}		
			%>
					</table>
				</div>

				<button id="back" onclick="history.back()">뒤로 가기</button>

			</div>

		</section>
	</div>
</body>
</html>