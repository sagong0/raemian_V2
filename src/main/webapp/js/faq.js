/**
 * 글쓰기 페이지 이동
 */
function add_faq(){
	location.href="./write"
}

/**
 * FAQ 등록
 */
function register_faq(){
	if(faqForm.fquestion.value == ""){
		alert("질문 내용을 입력해주세요.");
		faqForm.fquestion.focus();
	} else if(faqForm.fwriter.value == ""){
		alert("작성자 형식을 확인해주세요.");
	} else if(faqForm.fanswer.value == ""){
		alert("답변 내용을 입력해주세요.");
		faqForm.fanswer.focus();
	} else{
		faq_submit();
	}
}
function faq_submit(){
	faqForm.method="POST"
	faqForm.action="";
	faqForm.submit();
}


/**
 * faq 삭제
 */
function del_faq(fidx){
	var form = document.createElement("form");
	form.method="POST";
	form.action="./delete";
	
	var input = document.createElement("input");
    input.type = "hidden";
    input.name = "fidx";
    input.value = fidx;
    
    form.appendChild(input);
    document.body.appendChild(form);
    
    if(confirm("해당 공지사항을 삭제하시겠습니까?")){
		form.submit();
	}
}


function faqPagination(pNo){
	location.href="./?currentPage="+pNo;
}


