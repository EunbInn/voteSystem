<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, kr.ac.kopo.kopo08.domain.Hubo, kr.ac.kopo.kopo08.domain.Tupyo,
	kr.ac.kopo.kopo08.service.HuboServiceImpl, kr.ac.kopo.kopo08.service.TupyoServiceImpl,
	kr.ac.kopo.kopo08.service.TupyoService, kr.ac.kopo.kopo08.service.HuboService" %>
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
		width: 170px;
		background-color: #EEEEEE;
		padding: 5px 7px;
		text-align: left;
	}

	#name a {
		color: #393E46;
		text-decoration: none;
	}

	#name a:hover {
		color: blue;
		text-decoration: underline;
	}

	img {
		margin-top: 3px;
	}
</style>
</head>
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
			<h1 id="header"><i class="fas fa-chart-bar"></i>&nbsp개표 결과</h1>
			<hr>
			<div id="content-wrap">
				<div id="wrap">
					<table>
			<%	
			HuboService huboService = HuboServiceImpl.getInstance();
			TupyoService tupyoService = TupyoServiceImpl.getInstance();
			Hubo hubo;
			Tupyo tupyo;
			
			List<Hubo> huboList = huboService.selectAll();
			if (huboList == null) {
				out.print("등록된 후보가 없습니다");
			} else {
				for (int i = 0; i < huboList.size(); i++) {
					hubo = huboList.get(i);
					int kiho = hubo.getKiho();
					String name = hubo.getName();
					
					double[] cntAndPer = tupyoService.selectCountGroupbyKiho(kiho);
					int count = (int)cntAndPer[0];
					double percent = cntAndPer[1];
					out.println("<tr>" +
									"<th  id='name'>" + 
									"<a href='./showOneHubo.jsp?kiho=" + kiho + "&name=" + name + "'>" +
										kiho + "번 " + name + "</a></th>" +
									"<td>" + "<img src='./line.PNG' style='width:" + (percent * 5) + "px; height:17px' alt=''>&nbsp" +
										count + " (" + String.format("%.1f",percent) + "%)" + 
									"</td>" +
								"</tr>");
					
				}
			}
			%>
					</table>
				</div>
			</div>
		</section>
	</div>



</body>
</html>