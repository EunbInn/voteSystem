<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.ac.kopo.kopo08.service.HuboServiceImpl, kr.ac.kopo.kopo08.domain.Hubo, java.util.List,
	kr.ac.kopo.kopo08.service.HuboService" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보등록</title>
<link rel="stylesheet" type="text/css" href="./navigation.css">
<link rel="stylesheet" type="text/css" href="./bodyAndTable.css">
<link rel="stylesheet" type="text/css" href="./candidateMain.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
				<table>
					<!-- service에서 후보 테이블에 있는 후보명과 기호 가져오기 -->
					<% 
					int newKiho = 0;
					try {
						HuboService huboService = HuboServiceImpl.getInstance();
						Hubo hubo;
						
						List<Hubo> huboList = huboService.selectAll();
						if (huboList == null) {
							
						} else {
							for (int i = 0; i < huboList.size(); i++) {
								hubo = huboList.get(i);
								out.println("<tr>" +
												"<th class='title-num'>기호</th>" +
												"<td>" + hubo.getKiho() + "</td>" +
												"<th class='title-name'>후보명</th>" +	
												"<td>" + hubo.getName() + "</td>" +
												"<td>" + 
													"<button class='delete'><a href='./candidate03.jsp?kiho=" + hubo.getKiho() + "&name=" + hubo.getName() + "'>삭제</a></button>" +
												"</td>" +
											"</tr>");
							}
						}
						
					} catch (Exception e) {
						out.println(e.getMessage());
					}
					%>
					
					<!-- 후보명 입력하는 곳 -->
					<tr>
						<form method="post">
							<th class="title-num">기호</th>
							<td>자동부여</td>
							<th class="title-name">후보명</th>
							<td><input type="text" id="input-name" name="name" maxlength="20"
								class="inputBox" placeholder="이름 입력"></td>
							<td><input type="submit" id="submit"
								value="등록" formaction="./candidate02.jsp?"></td>
						</form>
					</tr>
				</table>	
				
			</div>
		</section>
	</div>
	
	<script>
	/* 한글 띄어쓰기 혹은 영어 띄어쓰기만 가능한 정규 표현식  */
		function getFilter(name) {
			var filter = /^[가-힣\s]+$/;
			var filter2 = /^[a-zA-Z\s]+$/;
			if (filter.test(name) || filter2.test(name)) {
				return true;
			} else {
				return false;
			}
		}
	
	/* 클릭시 정규식으로 검사 후 boolean 반환 */
		$(function() {
			$('#submit').click(function() {
				var name = $('#input-name').val();
				
				if (!getFilter(name) || name.length > 20 || name == "") {
					alert('이름 형식이 잘못되었습니다.');
					return false;
				} 

				if (getFilter(name) && name != "" &&
					kNum != ""){
					return true;
				}
			});
		})

	</script>
</body>
</html>