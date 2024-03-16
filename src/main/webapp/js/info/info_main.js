var createBtn = document.getElementById("createBtn");
createBtn.addEventListener("click", function(){
	location.href="./write"
});

/**
 * 삭제 PART
 */
function del_config(aidx){
	var form = document.createElement("form");
	form.method="POST";
	form.action="./delete";
	
	var input = document.createElement("input");
	input.type="hidden";
	input.name="aidx";
	input.value=aidx;
	
	form.appendChild(input);
	
	if(confirm("해당 정보를 삭제하시겠습니까?")){
		document.body.appendChild(form);
		form.submit();
	}
}

/**
 * 검색 PART
 */
var searchBtn = document.getElementById("searchBtn");
searchBtn.addEventListener("click", ()=>{
	var searchInput = document.getElementById("searchinput").value;
	location.href="./?searchWord="+searchInput;
});