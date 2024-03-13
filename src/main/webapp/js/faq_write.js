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