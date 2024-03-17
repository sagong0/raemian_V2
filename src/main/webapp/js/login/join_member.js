/**
 * 인증번호 발송
 
var randomBtn = document.getElementById("randomBtn");
randomBtn.addEventListener("click",()=>{
	let randomNum = Math.floor(Math.random()*900000);
	console.log(randomNum);
});
*/

/**
 * 이메일 미 입력시
 * 이메일 수신 체크박스 비활성화
 */
var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
function emailcheck(val){
	var emailBox = document.getElementById("ckemail");
	
	if(val == "" || val.length <= 6){
		emailBox.checked = false;
		emailBox.disabled = "disabled";
	} else{
		emailBox.disabled = false;
	}
}


/**
 * 회원가입 버튼
 */
var joinBtn = document.getElementById("joinBtn");
joinBtn.addEventListener("click", function(){
	if(joinForm.mname.value == ""){
		alert("사용자 이름을 입력해주세요.");
		joinForm.mname.focus();
	} else if(joinForm.mid.value == ""){
		alert("사용하실 아이디를 입력해주세요.");
		joinForm.mid.focus();
	} else if(joinForm.mpw.value == ""){
		alert("사용하실 비밀번호를 입력해주세요.");
		joinForm.mpw.focus();
	} else if(joinForm.mpw2.value == ""){
		alert("비밀번호 확인을 입력해주세요.");
		joinForm.mpw2.focus();
	} else if(joinForm.mtel.value==""){
		alert("휴대번호를 입력해주세요.");
		joinForm.mtel.focus();
	} else if(joinForm.certification_num.value==""){
		alert("인증번호를 입력해주세요.");
		joinForm.certification_num.focus();
	} else if(joinForm.memail.value == ""){
		alert("사용하실 이메일을 입력해주세요.");
		joinForm.memail.focus();
	} else if(joinForm.mstreetaddr.value==""){
		alert("도로명 주소를 확인해주세요.");
	} else if(joinForm.mdetailaddr.value==""){
		alert("상세주소를 확인해주세요.");
	} else{
		join_submit();
	}
});

function join_submit(){
	joinForm.method="POST";
	joinForm.action="";
	
	joinForm.submit();
}


