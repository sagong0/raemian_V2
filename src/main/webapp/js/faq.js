/**
 * 글쓰기 페이지 이동
 */
function add_faq(){
	location.href="./write"
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


function faqPagination(pNo,searchVal){
	location.href="./?currentPage="+pNo+"&searchVal="+searchVal;
}


/**
 * faq 검색 PART
 */
var searchBtn = document.getElementById("searchBtn");
searchBtn.addEventListener("click", function(){
	var searchVal =document.getElementById("fsearch").value;
	location.href="./?searchVal="+searchVal;
});





