window.onload = function(){
	let rVal = document.getElementById("hiddenRadioVal");
	let r1 = document.getElementById("r1");
	let r2 = document.getElementById("r2");
	
	if(rVal.value == "1"){
		r2.checked = false;
		r1.checked = true;
	}
	else if(rVal.value=="2"){
		r1.checked = false;
		r2.checked = true;
	}
};

function res_modify(){
	let form = document.getElementById("modifyForm");
	if(confirm("예약수정은 1회만 변견 가능합니다. \n 수정 하시겠습니까?")){
		form.submit();
	}
}

