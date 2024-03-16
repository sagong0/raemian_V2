function addInfo(){
	if(infoForm.atype.value==""){
		alert("주거타입을 입력해주세요.");
		infoForm.atype.focus();
	} else if(infoForm.awriter.value==""){
		alert("글쓴이를 입력해주세요.");
	} else if(infoForm.aprivate.value=="" || isNaN(infoForm.aprivate.value)){
		alert("주거전용을 입력해주세요.");
		infoForm.aprivate.focus();
	} else if(infoForm.apublic.value=="" || isNaN(infoForm.apublic.value)){
		alert("주거공용을 입력해주세요.");
		infoForm.apublic.focus();
	} else if(infoForm.aetcpublic.value=="" || isNaN(infoForm.aetcpublic.value)){
		alert("기타공용을 입력해주세요.");
		infoForm.aetcpublic.focus();
	} else if(infoForm.acontractSize.value=="" || isNaN(infoForm.acontractSize.value)){
		alert("계약면적을 입력해주세요.");
		infoForm.acontractSize.focus();
	} else if(infoForm.aimgUrl.value==""){
		alert("이미지 URL을 입력해주세요.");
		infoForm.aimgUrl.focus();
	} else if(infoForm.ause.value==""){
		alert("사용유무를 입력해주세요.");
		infoForm.ause.focus();
	} else if(infoForm.aorder.value==""){
		alert("출력순서를 입력해주세요.");
		infoForm.aorder.focus();
	} else {
		info_submit();
	}
}

function info_submit(){
	infoForm.method="POST";
	infoForm.action="";
	infoForm.submit();
}