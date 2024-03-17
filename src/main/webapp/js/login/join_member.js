/**
 * 인증번호 발송
 
var randomBtn = document.getElementById("randomBtn");
randomBtn.addEventListener("click",()=>{
	let randomNum = Math.floor(Math.random()*900000);
	console.log(randomNum);
});
*/

/**
 * 아이디 중복확인 PART
 */
var checkIdBtn = document.getElementById("checkIdBtn");
var id_regex = /^[a-zA-Z0-9]+$/;
checkIdBtn.addEventListener("click", function(){
	var mid = document.getElementById("mid").value;
	
	if(mid == ""){
		alert("사용하실 아이디를 입력해주세요.");
		mid.focus();
	} else if(!id_regex.test(mid)){
		alert("아이디는 영문과 숫자만 사용 가능합니다.");
		mid.focus();
	} else{
		fetch('./checkId', {
		  method: 'POST',
		  body: mid,
		})
		.then(response => {
		  if (!response.ok) {
		    throw new Error('Network response was not ok');
		  }
		  return response.text();
		})
		.then(resp => {
		  if(resp === "canuse"){
			  alert("사용 가능한 아이디 입니다.");
			  joinForm.mid.readOnly = "readOnly";
		  } else{
			  alert("이미 사용 중인 아이디 입니다.");
			  joinForm.mid.value = "";
			  joinForm.mid.focus();
		  }
		})
		.catch(error => {
		  console.error('Error:', error);
		});		
	}
});
	


/* 주소찾기 Btn */
document.querySelector("#findAddrBtn").addEventListener("click",function(){
	let form = document.querySelector("#jForm");
	
	new daum.Postcode({
        oncomplete: function(resp) {
			form.mzipcode.value = resp.zonecode;
			form.mstreetaddr.value = resp.address;
        }
    }).open();
})

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
