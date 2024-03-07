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