<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, kr.ac.kopo.kopo08.domain.Hubo, kr.ac.kopo.kopo08.service.HuboServiceImpl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표하기</title>
<link rel="stylesheet" type="text/css" href="./navigation.css">
<link rel="stylesheet" type="text/css" href="./bodyAndTable.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
	.selectBox {
		width: 200px;
		height: 30px;
		margin: 10px;
		border: 1px solid gray;
	}

	.input {
		padding: 5px 20px;
		margin-left: 10px;
		border: 2px solid #064420;
		border-radius: 7px;
		background-color: #064420;
		color: #fdfaf6;
		font-weight: bold;
		cursor: pointer;
	}
	
	.input:hover {
		background-color: #e4efe7;
		color: #064420;
	}
</style>
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
			<h1 id="header">투표</h1>
			<hr>
			<div id="content-wrap">	
				<form method='post'>
					<!--셀렉트박스 인자 값 기호&이름 /디폴트타입 빈칸 :none-->
					<select name="kihoName" id="kihoName" class="selectBox">
						<option value='none' selected>후보 선택</option> 
			<%
			HuboServiceImpl huboService = new HuboServiceImpl();
			Hubo hubo;
			
			List<Hubo> huboArr = huboService.selectAll();
			for (int i = 0; i < huboArr.size(); i++) {
				hubo = huboArr.get(i);
				out.println("<option value='" + hubo.getKiho() + "//" + hubo.getName() + "'>기호 " + hubo.getKiho() + "번 " + hubo.getName() + "</option>");
			}
			%>		
					</select>
					<!--셀렉트박스 인자 값 연령대 /디폴트타입 빈칸 :none-->
					<select name="age" id="age" class="selectBox">
						<option value="none" selected>연령대 선택</option>
						<option value="10">10대</option>
						<option value="20">20대</option>
						<option value="30">30대</option>
						<option value="40">40대</option>
						<option value="50">50대</option>
						<option value="60">60대</option>
						<option value="70">70대</option>
						<option value="80">80대</option>
						<option value="90">90대</option>
					</select>
					<input type="submit" id="submit" class="input" value="투표" formaction='vote02.jsp'>
				</form>
			</div>
		</section>
	</div>
	<script>
		/*submit을 보냈을 때, 빈칸일 시 alert 보내기*/
		$(function() {
			$('#submit').click(function() {
				var age = $('#age').val();
				var kNumName = $('#kNumName').val();

				if (kNumName == "none") {
					alert('후보를 선택해주세요');
					return false;
				}
				
				if (age == "none") {
					alert('본인의 연령대를 선택해주세요');
					return false;
				} 

				if (kNumName != "none" && age != "none"){
					return true;
				}
			});
		})
	</script>
</body>
</html>