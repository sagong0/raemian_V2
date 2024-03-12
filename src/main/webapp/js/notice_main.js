function noticeWriteForm(){
	location.href="./write"
}

/**
 *  제목 검색 PART
 */
function searchByTitle(){
	var searchVal = document.getElementById("searchWord").value;
	
	location.href="./?searchWord="+searchVal;
}

/**
 * 페이징 기능
 */
function noticePagination(pNo, searchWord){
	location.href="./?currentPage="+pNo+"&searchWord="+searchWord;
}

/**
 * 삭제 기능 
 */
function notice_delete(nidx){
	var form = document.createElement("form");
	form.method="POST";
	form.action="./delete";
	
	var input = document.createElement("input");
    input.type = "hidden";
    input.name = "nidx";
    input.value = nidx;
    
    form.appendChild(input);
    document.body.appendChild(form);
    
    if(confirm("해당 공지사항을 삭제하시겠습니까?")){
		form.submit();
	}
}