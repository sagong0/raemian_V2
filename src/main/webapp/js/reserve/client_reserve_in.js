var reserveBtn = document.getElementById("reserveBtn");
reserveBtn.addEventListener("click",()=>{
	if(reserveForm.rid.value==""){
		alert("예약자분 아이디를 확인해주세요.");
		reserveForm.rid.focus();
	} else if(reserveForm.rname.value==""){
		alert("예약자분 성함을 확인해주세요.");
		reserveForm.rname.focus();
	} else if(reserveForm.rdate.value==""){
		alert("예약일자를 선택해주세요.");
		reserveForm.rdate.focus();
	} else if(reserveForm.rtime.value==""){
		alert("예약시간을 선택해주세요.");
		reserveForm.rtime.focus();
	} else if(reserveForm.rtel.value==""){
		alert("예약자분 연락처를 입력해주세요.");
		reserveForm.rtel.focus();
	} else if(reserveForm.rcount.value==""){
		alert("예약 인원을 선택해주세요");
		reserveForm.rcount.focus();
	} else{
		submit_reserveForm();
	}
});


function submit_reserveForm(){
	reserveForm.method="POST";
	reserveForm.action="";
	reserveForm.submit();
}