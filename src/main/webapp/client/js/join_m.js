/* 주소찾기 Btn */
document.querySelector("#findAddrBtn").addEventListener("click",function(){
	let form = document.querySelector("#jForm");
	
	new daum.Postcode({
        oncomplete: function(resp) {
			form.mzipcode.value = resp.zonecode;
			form.mstreetaddr.value = resp.address;
        }
    }).open();
});

/* ID 중복 체크 */
function idck(e){
	e.preventDefault();
	
	var idregex = /[ㄱ-ㅎㅏ-ㅣ가-힣]/;
	var id = document.getElementById("mid");
	if(id.value==""){
		alert("아이디를 확인하세요.");
	}
	if(id.value.length < 6 || id.value.length >12){
		alert("6~12 글자 의 아이디를 사용해주세요.");
	}
	else if(idregex.test(id.value)){
		alert("아이디는 영문, 숫자, 특수문자만 사용합니다.");
	}
	else{
		var http = new XMLHttpRequest();
		http.onreadystatechange = function(){
			if(http.readyState == XMLHttpRequest.DONE && http.status==200){
				var result = this.response;
				console.log(result);
				if(result =="canuse"){
					alert("사용가능한 아이디입니다.");
					id.readOnly = "readOnly";
				}
				else if(result =="nouse"){
					alert("이미 사용중인 아이디입니다.");
				}
			}
		}
		
		http.open("post","./idck.do",true);
		http.setRequestHeader("content-type","application/x-www-form-urlencoded");
		http.send("id="+id.value);
	}
}




// 인증번호 데이터 생성
let securityNum = "";
var w = 0;
while(w <6){
    var a = Math.random() * 10;
    var b = Math.floor(a);
    securityNum += b;
    w++;
}


/*인증번호 발송*/
function send_sms(){
	/*
	 올바른 인증번호시
	 인증번호 입력태그 보이게 
	 */
	let mtel = document.getElementById("mtel").value;
	if(mtel.trim() == "" || mtel == null){
		alert("전화번호를 입력해주세요.");
	}
	else if(isNaN(mtel)){
		alert("올바른 전화번호를 입력해주세요.");
	}
	else if(mtel.length < 9 || mtel.length > 13){
		alert("올바른 형식의 전화번호를 사용해주세요.");
	}
	else{
		// 인증번호 입력 버튼 show
		let v1 = document.getElementById("verify1");
		let v2 = document.getElementById("verify2");
		v1.style.display = "flex";
		v2.style.display = "block";
		
		// 인증번호 받을 번호 value 가져옴.
		let usertel = document.getElementById("mtel").value;
		// AJAX POST 통신시작
		var url ="./sms_verifycation.do";
		fetch(url, {
			method: "POST",
			headers: {
	        	"Content-Type": "application/x-www-form-urlencoded"
			},
			body: "smsNo="+securityNum+"&usertel="+usertel
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
			console.log(data);
			/* 
			if(data == "ok"){
				alert("인증번호가 발송되었습니다.");
			}
			else{
				alert("인증번호 발송 실패. 다시 시도해주세요.");
			}
			*/
			if(data.length < 10){
				alert("인증번호가 발송되었습니다.");
			}
			else if(data.length > 15){
				alert("인증번호 발송 실패.\n 현재 네이버 클라우드 어뷰징 이슈로 개인계정의 경우 인증번호 이용이 제한되고 있어 F12를 통하여 console창으로 인증번호를 확인해주세요.");
			}
		})
		.catch((e)=>{
			console.log("ajax 오류 구문으로 빠짐.");
			console.log(e);
		});
	}
}

/* 인증번호 일치여부 */
function ck_sms(){
	var userInput = document.getElementById("mtelck");
	if(userInput.value.trim() == "" || userInput.value == null){
		alert("인증번호를 입력해주세요.");
	}
	else if(isNaN(userInput.value)){
		alert("인증번호가 일치하지 않습니다.");
	}
	else{
		if(userInput.value == securityNum){
			alert("본인 인증이 확인되었습니다.");
			
			//인증번호 일치시 비활성화 + 버튼 사라지게
			let ckBtn = document.getElementById("mtelckBtn");
			userInput.disabled = "true";
			ckBtn.style.display ="none";
		}
		else{
			alert("인증 번호를 확인해주세요.");
		}	
	}
}






/* form 태그 전송 */
document.querySelector("#joinBtn").addEventListener("click",function(){
	
	var email_regex = /[a-zA-z0-9._-]+@[a-zA-Z0-9]+[.]+[a-zA-Z]/;
    var id_regax = /^[a-zA-Z0-9_]+$/ // 허용된 문자 패턴 (영문, 숫자, 언더스코어)
	
	let form = document.querySelector("#jForm");
	
	console.log(form.ckemail.value);
	
	if(form.mname.value == ""){
		alert("성함을 입력해 주세요.");
	}
	else if(form.mid.value==""){
		alert("사용하실 아이디를 입력해주세요.");
	}
	else if(!id_regax.test(form.mid.value)){
		alert("아이디는 영문과 숫자만 사용가능합니다.");
	}
	else if(form.mid.value.length < 6 || form.mid.value.length > 12){
		alert("아이디는 6 ~ 12 글자만 사용가능합니다.");
	}
	else if(form.mpw.value==""){
		alert("사용하실 패스워드를 입력해주세요.");
	}
	else if(form.mpw.value.length < 8 || form.mpw.value.length >14){
		alert("8~14 글자의 패스워드를 사용해주세요.");
	}
	else if(form.mpw.value != form.mpw2.value){
		alert("패스워드를 확인해주세요.");
	}
	else if(form.mtel.value==""){
		alert("사용하실 전화번호를 입력해주세요.");
	}
	else if(isNaN(form.mtel.value)){
		alert("올바른 형식의 전화번호를 입력해주세요.");
	}
	/*
	else if(form.mtelck.value==""){
		alert("인증번호를 입력해주세요.");
	}
	else if(form.mtelck.value != 지금온 인증번호){
		alert("인증번호가 일치하지 않습니다..");
	}
	*/
	else if(form.mtel.value.length < 9 || form.mtel.value.length > 13){
		alert("전화번호를 확인해주세요.");
	}
	else if(isNaN(form.mtel.value)){
		alert("올바른 전화번호 형식을 입력해주세요.");
	}
	else if(form.mzipcode.value==""){
		alert("우편번호를 입력해주세요.");
	}
	else if(form.mstreetaddr.value==""){
		alert("도로명주소를 입력해주세요.");
	}
	else if(form.mdetailaddr.value==""){
		alert("상세주소를 입력해주세요.");
	}
	else if(form.memail.value.length > 0){
		if(!email_regex.test(form.memail.value)){
			alert("올바른 이메일 형식을 사용해주세요.");
		}
		// 올바른 이메일 정규식 
		else{
			form.submit();
		}
	}
	else{
		form.submit();
	}
});

/* 이메일 입력시 */
function emailck(val){
	var emailbox = document.getElementById("ckemail");
	if(val == ""){
		// 이메일 미입력시 체크 안되게
		emailbox.disabled = true;
	}
	else{
		// 이메일 입력 : 체크가능하게
		var ckbox = document.getElementById("ckemail");
		ckbox.checked = false;
		emailbox.disabled = false;
	}
}


/* 가입취소버튼 클릭시 */
document.querySelector("#cancelBtn").addEventListener("click",function(){
	if(confirm("회원가입을 취소하시겠습니까?")){
		location.href="./login.do";		
	}
});






