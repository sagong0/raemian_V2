/**
 * 검색 PART
 */

var searchBtn = document.getElementById("searchBtn");

searchBtn.addEventListener("click", function(){	
	var searchType = document.getElementById("searchType").value;
	var searchVal = document.getElementById("searchVal").value;
	
	location.href="./?searchType="+searchType + "&searchVal="+searchVal;
});

/* 회원 검색 후 selected 자동 업데이트되게 */
var url = new URLSearchParams(window.location.search);
var url_searchType = url.get("searchType");
var searchTypeSelectedBox = document.getElementById("searchType");

if(searchTypeSelectedBox){
	for(var i = 0; i < searchTypeSelectedBox.options.length; i++){
		if(searchTypeSelectedBox.options[i].value === url_searchType){
			searchTypeSelectedBox.selectedIndex = i;
			break;
		}
	}	
}

function memberPagination(pNo, searchType, searchVal){
	location.href="./?currentPage="+pNo+"&searchType="+searchType+"&searchVal="+searchVal;
}

/** 삭제 PART **/
function del_member(midx){
	console.log(midx);
	var form = document.createElement("form");
	var input = document.createElement("input");
	input.type = "hidden";
	input.name = "midx";
	input.value = midx;
	
	form.appendChild(input);
	document.body.appendChild(form);
	
	form.method="POST";
	form.action="./delete";
	if(confirm("해당 계정을 삭제하시겠습니까?")){
		form.submit();
	}
 }