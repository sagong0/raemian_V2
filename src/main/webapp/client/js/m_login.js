function login(){
	if(loginform.mid.value==""){
		alert("아이디를 입력해주세요.");
		return false;
	}
	else if(loginform.mpw.value==""){
		alert("비밀번호를 입력해주세요.");
		return false;
	}
	else{
		return;
	}
}

/*회원가입 페이지 이동 */
function goSignUp(){
	location.href = "./join_agree.jsp";
}