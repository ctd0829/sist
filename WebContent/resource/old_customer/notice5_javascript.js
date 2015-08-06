
	//결과물을 남기지 않는 번역기 사용 = 인터프리터 언어
	/* 
	//alert() = 알림창
	var x;
	alert(x == undefined);
	
	var record = {kor:30, eng:70, math:80};
	record.Kor = 20; // 자바스크립트는 대소문자를 구분함
	alert(record.kor + record.eng);
	
	var lottos = ["hello",[100,0],3];
	alert(lottos[1][0]);
	
	alert("31" > "4"); //false
	alert(31 > "4"); //true
	 */
	/*function printResult(){
	 
	var x , y;
	x =	prompt("x값을 입력하세요.", 0);
	y =	prompt("y값을 입력하세요.", 0); //prompt는 window제공
	alert(typeof x); 
	x = parseInt(x); //parseInt는 언어가 제공. String
	alert(x+parseInt(y)); 
	alert(typeof x); //Number
	
		
	}*/
	
	//var ar = ["철수","영희","맹구","동천"];
	/* 
	for(var i=0;i<4;i++)
		alert(ar[i]); //i는 값을 꺼내옴
	*/
	//for (i in ar)
	//	alert(ar[i]); //i는 ar의 index(key값)를 꺼내옴 
		
	/* var m = {name:"abc", age:18};
		
	for(var k in m)
		alert(m[k]); */
	
	/* var x = (function(a,b){
		return a+b;
	})(3,4); //익명의 함수 = 일회용
		
	alert(x); */
	
	/* function add(a,b){
		return arguments[0]+arguments[1];
	}
	
	var sum = add(2,3,4); //결과값은 5
	//인자의 갯수가 불일치 해도 에러가 나지 않음. 
	//값을 파라미터로 저장하지 않고 arguments라는 컬렉션에 저장됨.
	//a,b는 별칭
	
	alert(sum);  */
	
	/* 
	function f1(){
		a = 1;
		f2();
		function f2(){
			a = 2;
			f3();
			function f3(){
				a = 3; // 지역변수로 들어감. 
				//global은 최후의 보루
			}
		}
	} //function안에 function 정의 가능
	
	f1();
	alert(a); // 3 */
	
	function init(){
		
		var btn = document.getElementById("a");
		btn.onclick = function printResult(){
			var x , y;
			x =	prompt("x값을 입력하세요.", 0);
			y =	prompt("y값을 입력하세요.", 0); //prompt는 window제공
			alert(typeof x); 
			x = parseInt(x); //parseInt는 언어가 제공. String
			alert(x+parseInt(y)); 
			alert(typeof x); //Number
			}
			
	}
	
	window.onload = init; //window가 전부 로드되면 init()을 실행