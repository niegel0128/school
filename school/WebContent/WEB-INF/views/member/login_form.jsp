<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<style type="text/css">
#login {
	margin-top: 5em;
}
</style>

<div id="login">
	<div class="loginTop text-center">
		<img src="${context}/resources/img/member/paper_plane.png"
			id="paper_plane" border="0" />
	</div>
	<form>
		<div class="loginCenter row" style="margin-left: 43.5%;">
			<fieldset class="loginField">
				<div class="form-group">
					<label for="input_id" class="control-label sr-only">아이디</label>
					<div class="col-sm-3">
						<input id="id" placeholder="아이디를 입력하세요" />
					</div>
				</div>
				<div class="form-group">
					<label for="input_pw" class="control-label sr-only">비밀번호</label>
					<div class="col-sm-3">
						<input id="password" placeholder="비밀번호를 입력하세요" />
					</div>
				</div>
			</fieldset>

		</div>
		<div class="input_button text-center">
			<img src="${context}/resources/img/main/index.gif" id="loginButton">
		</div>
	</form>
</div>
</body>
<script>
	$('form').addClass('form-horizontal');

	$('paper_plane').css('border', '0').css('heigh', '160px').css('width',
			'160px');

	$('#loginButton').click(
			function() {
				$('form').attr('action', '${context}/member/login.do').attr(
						'method', 'post').submit();
			}).attr('src', '${context}/resources/img/main/login.gif').attr(
			'name', 'loginForm');
	$('#paper_plane').attr('src',
			'${context}/resources/img/member/paper_plane.png').attr('border',
			'0');
	$('#id').addClass('form-control').attr('type', 'text').attr('name',
			'input_id')

	$('#password').addClass('form-control').attr('type', 'password').attr(
			'name', 'input_pw')
</script>
</html>