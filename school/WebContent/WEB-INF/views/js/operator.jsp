<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<div class="container" style="width: 1000px; margin: :0 auto;">
	<div>
		<h3>배열 출력하기</h3>
		<button onclick="opr.sysout()">sysout</button>
		<button onclick="opr.score()">score</button>
		<button onclick="opr.grade()">grade</button>
		<button onclick="opr.gender()">gender</button>
		<button onclick="opr.bigNum()">bigNum</button>
		<button onclick="opr.gugudan()">gugudan</button>
		<button onclick="opr.sum1to100()">sum1to100</button>
		<button onclick="opr.oddSum()">oddSum</button>
		<button onclick="liveScript()">liveScript</button>
	</div>
</div>
<script type="text/javascript">
function liveScript(){
	alert('라이브스크립트 시절(객체기반언어가 아닌 시절)은 이렇게 했답니다.');
}

	var opr = {
		sysout : function() {

			var arr = [ '사과', '배', '감', '귤' ];
			for ( var i in arr) {
				console.log(arr[i] + '\t');
			}
		},
		score : function() {
			var result = '';
			var avengers = [];
			avengers.push({
				name : "아이언",
				kor : 90,
				eng : 90,
				math : 90
			}); //그냥 ({}) 는 널
			avengers.push({
				name : "헐크",
				kor : 80,
				eng : 90,
				math : 80
			}); //그냥 ({}) 는 널
			avengers.push({
				name : "캡아",
				kor : 70,
				eng : 90,
				math : 70
			}); //그냥 ({}) 는 널
			for ( var i in avengers) {
				avengers[i].getSum = function() {
					result = this.kor + this.eng + this.math;
					return result;
				}

				avengers[i].getAvg = function() {
					result = this.getSum() / 3;
					return result;
				}
				console.log('이름 : ' + avengers[i].name + ' 합계 : '
						+ avengers[i].getSum() + ' 평균 : '
						+ avengers[i].getAvg());
			}
			result = '==========어벤저스 성적표=========== <br />';
			result += '이름\t국어\t영어\t+수학\t+총점\t+평균<br/>';
			result += '-------------------------------------<br/>';
			for ( var i in avengers) {
				{
					with (avengers[i]) {
						result += name + ':\t' + kor + ':\t' + eng + ':\t'
								+ math + ':\t' + getSum() + ':\t' + getAvg()
								+ '\n'
					}
				}
			}
			/*
			with 키워드는 배열에 담긴 하나의 객체를 의미한다
			즉 예를 들어 
			vat iron = {name : '아이언', kor : 90 ,eng: 50 , math : 90}
			이렇게 선언된 하나의 객체를 avengers.push(iron)이라고 줄경우
			출력문에서 with를 사용하지 않는다면 iron.name 이런식으로 일일히
			서용해야하기 때문에 with를 사용한다.
			 */
			console.log(result);
		},
		grade : function() {
			/*
			평균 90 이상 A
			80 B
			70 C
			60 D
			미만 F
			 */
			var kor = 80, eng = 70, math = 60;
			var sum = kor + eng + math;

			if (sum >= 90) {
				console.log("A");
			} else if (sum >= 80) {
				console.log("B");
			} else if (sum >= 70) {
				console.log("C");
			} else if (sum >= 60) {
				console.log("D");
			} else {
				console.log("F");
			}
		},
		gender : function() {
			/* 
			800101-1234567 일 경우 flag 값은 1 이다라고 정의함
			 */
			var flag = 4; // 라면 성별을 판별하는 로직을 switch - case 로 완성하시오
			// 자바의 switch case 와 동일

			switch (flag) {
			case 1:
				console.log("남자");
				break;
			case 2:
				console.log("여자");
				break;
			case 3:
				console.log("남자");
				break;
			case 4:
				console.log("여자");
				break;
			default:
				console.log("성별이 잘못되었습니다.");
				break;
			}
		},
		bigNum : function() {
			/* 80, 70, 60 일 경우 if 문으로 최대값 을 구하는 로직을 완성하시오 */
			var a = 80, b = 70, c = 60;
			var max = 0, min = 0;
			if (a > b) {
				max = a;
				min = b;
			} else if (b > c) {
				max = b;
				min = c;
			} else if (a < b) {
				max = b;
				min = a;
			} else if (b < c) {
				max = c;
				min = b;
			}
			console.log(max);
		},
		gugudan : function() {
			var i = 0, j = 0;
			for (var i = 7; i <= 7; i++) {
				// 7단 구구단을 출력하시오
				for (var j = 1; j <= 9; j++) {
					console.log(i * j);
				}
			}
		},
		sum1to100 : function() {
			var sum = 0, i = 0;
			//while (condition) {
			/* 1부터 100까지의 합을 출력하시오*/
			for (var i = 1; i <= 100; i++) {
				sum = i + sum;
			}
			console.log(sum);
			//}
		},
		oddSum : function() {
			var oddSum = 0, evenSum = 0;
			// 1부터 100 까지 수 중에서 홀수의 합 oddSum 과 
			// 짝수들의 합 evenSum 을 구하시오
			for (var i = 1; i <= 100; i += 2) {
				oddSum = i + oddSum;
			}
			for (var j = 2; j <= 100; j += 2) {
				evenSum = i + evenSum;
			}
			console.log("홀수 : " + oddSum + " 짝수 : " + evenSum);
		}
	}
</script>