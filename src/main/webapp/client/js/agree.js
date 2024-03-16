/*약관 동의 AJAX*/
var agree = function (f){
	var http = new XMLHttpRequest();
	http.open("GET",f,false);
	http.send();
	
	return http.response;
}
document.getElementById("agree1").innerText = agree("./agree/agree1.txt");
document.getElementById("agree2").innerText = agree("./agree/agree2.txt");

/* 전체동의 체크박스 */
function allagree(ck){
	var w = 1;
	while(w<=2){
		document.getElementById("a"+w).checked = ck;
		w++;		
	}
}

function chbox(ck){
	var ischeck = true;
	
	var all = document.getElementById("all_agree");
	var ww = 1;
	while(ww <=2){
		if(!document.getElementById("a"+ww).checked){
			ischeck = false;
		}	
		ww++;
	}
	if(ischeck){
		all.checked = true;
	}
	else{
		all.checked = false;	
	}	
}

/* 다음단계 버튼 */
document.querySelector("#nextBtn").addEventListener("click",function(){
	let form = document.getElementById("agreeForm");
	let c1box = document.getElementById("a1");
	let c2box = document.getElementById("a2");
	if(!c1box.checked){
		alert("이용약관에 모두 동의하셔야 회원가입이 진행 가능합니다.");
		return false;
	}
	else if(!c2box.checked){
		alert("이용약관에 모두 동의하셔야 회원가입이 진행 가능합니다.");
		return false;
	}
	else{
		form.submit();
	}
});




