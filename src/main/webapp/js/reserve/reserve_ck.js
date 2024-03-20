var modifyBtn = document.getElementById("modifyBtn");
modifyBtn.addEventListener("click", ()=>{
	if(confirm("예약 수정은 1회만 변경 가능합니다. \n 변경 하시겠습니까?")){
		modifyForm.method="POST";
		modifyForm.action="";
		modifyForm.submit();	
	}
});