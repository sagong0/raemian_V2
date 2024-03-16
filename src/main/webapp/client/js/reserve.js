

document.querySelector("#reserveBtn").addEventListener("click",function(){
	
	
	let rform = document.getElementById("reserveF");
	let today = new Date();
	console.log(rform.rtime.value);
	let reserveDate = new Date(rform.rdate.value);
	
	if(rform.rid.value==""){
		alert("아이디를 입력해주세요.");
	}
	else if(rform.rname.value==""){
		alert("고객명을 입력해주세요.");
	}
	else if(!isNaN(rform.rname.value)){
		alert("올바른 고객명을 입력해주세요.");
	}
	else if(rform.rdate.value==""){
		alert("예약 일자를 선택해주세요.");
	}
	else if(today > reserveDate){
		alert("예약 일자는 오늘 이후로 가능합니다.");
	}
	else if(rform.rtime.value=="시간선택"){
		alert("예약 시간을 선택해주세요.");
	}
	else if(rform.rtel.value==""){
		alert("예약자 전화번호를 입력해주세요.");
	}
	else if(isNaN(rform.rtel.value)){
		alert("올바른 전화번호 형식을 사용해주세요.");
	}
	else if(rform.rcount.value==""){
		alert("예약 인원을 선택해주세요.");
	}
	else{
		rform.submit();
	}
});