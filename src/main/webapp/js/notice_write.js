/**
 * 공지사항 글쓰기 PART
 */
function noticeRegister(){
	var nfileInput = document.getElementById("nfile");
	const maxSize = 1024 * 1024 * 2;
	
	if(noticeForm.ntitle.value==""){
		alert("공지사항 제목을 입력해주세요.");
		noticeForm.ntitle.focus();
	} 
	else if(noticeForm.nwriter.value==""){
		alert("글쓴이를 확인해주세요.");
	}
	else if(noticeForm.ncontent.value == ""){
		alert("공지 내용을 입려해주세요.");
		noticeForm.ncontent.focus();
	}
	else if(nfileInput.files.length > 0){
		if(nfileInput.files[0].size >= maxSize){
			alert("파일 용량은 2MB 이하만 등록 가능합니다.");
			return;
		} else{
			// 전송
			noticeSubmit();
		}
	} 
	else{
		// 전송
		noticeSubmit();
	}
}

function noticeSubmit(){
	noticeForm.method="POST";
	noticeForm.action="";;
	noticeForm.submit();
}