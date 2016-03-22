<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
<div id="join">
		<div class="joinTop">
			<h2 class="text-center">회원가입</h2>
		</div>
		<div class="joinCenter row">
			<%-- <form action="${context}/member/join.do" method="post" name="joinForm" class="form-horizontal"> --%>
			<form>
				<fieldset class="joinField">
					<div class="form-group">
					 	<label for="id" class="col-sm-4 control-label">아이디</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력하세요"/>
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-4 control-label">비밀번호</label>
					 	<div class="col-sm-4">
							<input type="password" class="form-control" id="password" name="password" placeholder="비밀번호를 입력하세요"/>
						</div>
					</div>
					<div class="form-group">
						<label for="passwordCheck" class="col-sm-4 control-label">비밀번호 확인</label>
						<div class="col-sm-4">
							<input type="password" class="form-control" name="passwordCheck" id="passwordCheck" placeholder="비밀번호를 확인하세요"/>
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-4 control-label">이름</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력하세요"/>
						</div>
					</div>
					<div class="form-group">
						<label for="addr" class="col-sm-4 control-label">주소</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="addr" name="addr" placeholder="주소를 입력하세요"/>
						</div>
					</div>
					<div class="form-group">
						<label for="birth" class="col-sm-4 control-label">생년월일</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="birth" name="birth" placeholder="생년월일을 입력하세요"/>
						</div>
					</div>
					<div class="form-group">
						<label for="subject" class="col-sm-4 control-label">수강과목</label>
					 	<div class="col-sm-4">
							<input type="checkbox" class="form-control" id="subject" name="subject""/> Java
							<input type="checkbox" class="form-control" id="subject" name="subject""/> JSP
							<input type="checkbox" class="form-control" id="subject" name="subject""/> SQL
							<input type="checkbox" class="form-control" id="subject" name="subject""/> Spring
							<input type="checkbox" class="form-control" id="subject" name="subject""/> Python
							<input type="checkbox" class="form-control" id="subject" name="subject""/> NodeJs
							<input type="checkbox" class="form-control" id="subject" name="subject""/> Android
						</div>
					</div>
					<div class="form-group">
						<label for="major" class="col-sm-4 control-label">전공</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="major" name="major" "/>
								<option value="Computer">컴퓨터공학</option>
								<option value="Info">정보통신</option>
								<option value="security">정보보안</option>
						</div>
					</div>
					
					<div class="input_button text-center">
						<input type="submit" class = 'btn btn-primary' id="joinButton"  value ="회원가입"/>
						<input type="reset" class = 'btn btn-primary' id="cancleButton" value ="취소"/>
<!-- 						<input type="submit" id="joinButton" class="btn btn-primary" value ="회원가입"/>
						<input type="reset" id="cancleButton" class="btn btn-primary" value ="취소"/> -->
					</div>
						
				</fieldset>
			</form>
		</div>
	</div>
	<%-- <form action="${context}/member/join.do" method="post" name="joinForm" class="form-horizontal"> --%>
	<script>
	$(function() {
		$('form')
		.addClass('form-horizontal')
		.attr('action','${context}/member/join.do')
		.attr('method','post')
		$('#loginButton').click(
				function() {
					$('form')
					.attr('action','${context}/member/login.do')
					.attr('name','loginForm')
					.attr('method', 'post').submit();
				})
	})
	</script>
	
	
	
	