/**
 * 검색 PART
 */
var searchBtn = document.getElementById("searchBtn");
searchBtn.addEventListener("click", ()=>{
	var searchType = document.getElementById("searchType").value;
	var searchVal = document.getElementById("searchVal").value;
	
	location.href="./?searchType="+searchType + "&searchVal="+searchVal;
});

/**
 * 취소 PART
 */

 function cancel_reserve(ridx){
	 var form = document.createElement("form");
	 form.method="POST";
	 form.action="./cancel";
	 
	 var input = document.createElement("input");
	 input.type="hidden";
	 input.name="ridx";
	 input.value=ridx;
	 
	 if(confirm("사전예약 회원을 취소 하시겠습니까? 데이터는 복구 되지 않습니다.")){
		 form.appendChild(input);
		 document.body.appendChild(form);
		 form.submit();
	 }
 }