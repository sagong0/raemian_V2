/** 회원가입 버튼 
 */
var joinBtn = document.getElementById("joinBtn");
joinBtn.addEventListener("click",()=>{
	location.href="/raemian/client/agree"
});

/**
 * 로그인 로직 
 */
var loginBtn = document.getElementById("loginBtn");
loginBtn.addEventListener("click",(e)=>{
	if(loginForm.aid.value==""){
		alert("아이디를 입력해주세요.");
		e.preventDefault();
		loginForm.aid.focus();
	} else if(loginForm.apw.value==""){
		alert("비밀번호를 입력해주세요.");
		e.preventDefault();
		loginForm.apw.focus();
	} else{
		login_submit();
	}
});

function login_submit(){
	loginForm.method="POST";
	loginForm.action="";
	loginForm.submit();
}