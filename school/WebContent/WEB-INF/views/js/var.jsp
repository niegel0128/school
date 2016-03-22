<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<div class="container" style="width: 1000px; margin: 0 auto;">
	<div>
		변수 선언 :
		<mark> var i; </mark>
		<br /> 자스변수는 데이터 타입을 정확하게 명시하지 않는다 <br /> 다만 값 할당시 자동으로 데이터 타입이
		결정된다.
	</div>
	<div style="margin-top: 30px">
		<ui>
		<li>number(숫자형) : var x = 17;</li>
		<li>String(문자형) : var str = 'test' 혹은 "test"모두 가능;</li>
		<li>boolean(논리형) : var bool = true;</li>
		<li>null : 널값;</li>
		<li>underfined : 변수가 선언도었으나 초기화 되지 않음;</li>
		<li>Array(배열) : var arr = ['사과','배,'귤'];</li>
		</ui>
	</div>
	<div style="margin-top: 30px">
		전역 변수 : 함수 밖에서 선언하거나 var없이 선언. 모든 함수에서 참조 가능 
		지역 변수 : 함수 안에서 선언, 해당 함수에서만 참조 가능</div>
	<div style="margin-top: 30px">
		<h3>출력함수</h3>
		document.write('안녕하세요 !!'); --> 자바에서 System.out.println() 과 동일
	</div>




</div>