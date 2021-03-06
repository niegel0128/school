<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
<div id="detail">
		<div class="joinTop">
			<h2 class="text-center">${sessionScope.user.name} 상세정보</h2>
		</div>
		<div class="joinCenter row">
			<form>
				<fieldset class="joinField">
					<div class="form-group">
					 	<label for="input_id" class="col-sm-4 control-label">아이디</label>
					 	<div class="col-sm-4">
					 		<input type="text" class="form-control" id="id" name="id" value="${sessionScope.user.id}"	readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_pw" class="col-sm-4 control-label">비밀번호</label>
					 	<div class="col-sm-4">
					 		<input type="password" class="form-control" id="password" name="password" value="${sessionScope.user.password}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">이름</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="name" name="name" value="${sessionScope.user.name}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">주소</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="addr" name="addr" value="${sessionScope.user.addr}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">생년월일</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="birth" name="birth" value="${sessionScope.user.birth}" readonly="readonly"/>
						</div>
					</div>
					<div class="input_button text-center">
						<input type="submit"/>
						<button id="updateButton">수정폼으로 이동</button>
						<input type="submit" formaction="${context}/member/delete.do" id="deleteButton"  value ="삭제"/>
						<input type="hidden" id="id" name = "id" value ="${sessionScope.user.id}"/>
<%-- 					<input type="submit" id="updateButton" class="btn btn-primary" value ="수정폼으로 이동"/>
						<input type="submit" formaction="${context}/member/delete.do" id="deleteButton" class="btn btn-primary" value ="삭제"/>
						<input type="hidden" id="id" name = "id" class="btn btn-primary" value ="${member.id}"/> --%>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
	<script>
	
	
	$(function(){
		$('input')
		.addClass('btn btn-primary')
		$('form')
		.addClass('form-horizontal')
		.attr('action','${context}/member/update_form.do')
		
		$('#updateButton').click(
				function() {
				location.href = "${context}/member/update_form.do";
				})
	})
	
	</script>