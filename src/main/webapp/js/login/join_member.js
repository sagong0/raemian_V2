/**
 * 아이디 중복확인 PART
 */
var idDoubleCheck = false;
var checkIdBtn = document.getElementById("checkIdBtn");
var id_regex = /^[a-zA-Z0-9]+$/;

checkIdBtn.addEventListener("click", function(){
	var mid = document.getElementById("mid").value;
	
	if(mid == ""){
		alert("사용하실 아이디를 입력해주세요.");
		joinForm.mid.focus();
	} else if(!id_regex.test(mid)){
		alert("아이디는 영문과 숫자만 사용 가능합니다.");
		joinForm.mid.focus();
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
			  idDoubleCheck = true;
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



/**
 * SMS API 인증번호 발송 버튼 
 */
var smsBtn = document.getElementById("sendSmsBtn");
var smsNo = Math.floor(100000 + Math.random() * 900000);
smsBtn.addEventListener("click", function(){
	if(joinForm.mtel.value == "" || isNaN(joinForm.mtel.value) || joinForm.mtel.value.length < 10){
		alert("전화번호를 확인해주세요.");
		joinForm.mtel.focus();
	} else if(joinForm.mtel.value.lenth < 10){
		alert("올바른 전화번호 형식을 입력해주세요.");
		joinForm.mtel.focus();
	} else{
		var url ="./smsVerification.do";
		fetch(url, {
			method: "POST",
			headers: {
	        	"Content-Type": "application/x-www-form-urlencoded"
			},
			body: "smsNo="+smsNo+"&mtel="+joinForm.mtel.value
		})
		.then((res)=>{
			if(!res.ok){
				throw new Error("네트워크 오류");
			}
			else{
				return res.text();
			}
		})
		.then((data)=>{
			if(data.includes("ok")){
				alert("인증번호가 발송되었습니다.");
			} else{
				alert("현재 어뷰징 이슈로 Naver SMS API 개인 계정의 경우 서비스 신규 이용을 제한되어 \n f12 를 눌러 콘솔창을 통해 인증번호를 확인해주세요.");
				console.log(data.split("cancel")[1]);
			}
		})
		.catch((e)=>{
			console.log("ajax 오류 구문으로 빠짐.");
			console.log(e);
		});
	}
});

/** 인증번호 일치 여부 */
var isCheckSms = false;
var checkSmsBtn = document.getElementById("checkSms");
checkSmsBtn.addEventListener("click", function(){
	if(joinForm.certification_num.value==""|| joinForm.certification_num.value.trim() == ""){
		alert("인증번호를 입력해주세요.");
		joinForm.certification_num.focus();
	} else{
		if(joinForm.certification_num.value == smsNo){
			alert("성공적으로 인증되었습니다.");
			isCheckSms = true;
			document.getElementById("certification_num").readOnly = "readOnly";
			checkSmsBtn.style.display = "none";
		} else{
			alert("인증번호를 확인해주세요.");
			joinForm.certification_num.focus();
		}
	}
});


	


/* 주소찾기 Btn */
document.querySelector("#findAddrBtn").addEventListener("click",function(){
	let form = document.getElementById("joinForm");
	
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
	} else if(!emailRegex.test(val)){
		emailBox.checked = false;
		emailBox.disabled = "disabled";
	} else{
		emailBox.disabled = false;
	}
}



/** 이메일 체크박스 컨트롤  **/
document.getElementById('ckemail').addEventListener('change', function() {
    var hiddenInput = document.getElementById('ckemailHidden');
    if (this.checked) {
        hiddenInput.value = 'Y';
    } else {
        hiddenInput.value = 'N';
    }
});

/** 전화번호 체크박스 컨트롤  **/
document.getElementById('cktel').addEventListener('change', function() {
    var hiddenInput = document.getElementById('cktelHidden');
    if (this.checked) {
        hiddenInput.value = 'Y';
    } else {
        hiddenInput.value = 'N';
    }
});

/** ckaddr 체크박스 컨트롤  **/
document.getElementById('ckaddr').addEventListener('change', function() {
    var hiddenInput = document.getElementById('ckaddrHidden');
    if (this.checked) {
        hiddenInput.value = 'Y';
    } else {
        hiddenInput.value = 'N';
    }
});

/** cksms 체크박스 컨트롤  **/
document.getElementById('cksms').addEventListener('change', function() {
    var hiddenInput = document.getElementById('cksmsHidden');
    if (this.checked) {
        hiddenInput.value = 'Y';
    } else {
        hiddenInput.value = 'N';
    }
});





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
	} else if(!idDoubleCheck){
		alert("아이디 중복확인을 진행해주세요.");
	} else if(joinForm.mpw.value == "" || joinForm.mpw.value.length < 6){
		alert("6자 이상의 비밀번호를 사용해주세요.");
		joinForm.mpw.focus();
	} else if(joinForm.mpw2.value == ""){
		alert("비밀번호 확인을 입력해주세요.");
		joinForm.mpw2.focus();
	} else if(joinForm.mpw.value != joinForm.mpw2.value){
		alert("비밀번호를 확인해주세요.");
		joinForm.mpw.value = "";
		joinForm.mpw2.value = "";
		joinForm.mpw.focus();
	} else if(joinForm.mtel.value=="" || isNaN(joinForm.mtel.value) || joinForm.mtel.value.length < 10){
		alert("휴대번호를 확인해주세요.");
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
	} else if(!isCheckSms){
		alert("휴대폰 인증을 진행해주세요.");
		joinForm.certification_num.focus();
	} else{
		
		join_submit();
	}
});

function join_submit(){
	joinForm.method="POST";
	joinForm.action="./join";
	joinForm.submit();
}

