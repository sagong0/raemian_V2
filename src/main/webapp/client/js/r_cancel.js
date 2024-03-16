function cancel_res(ridx){
	let url = "./del_reserve.do";
	
	if(confirm("사전방문 예약 취소 하시겠습니까? 해당 데이터는 복구 되지 않습니다")){
		fetch(url,{
		method :"POST",
		cache : "no-cache",
		headers : {
			"Content-Type": "application/x-www-form-urlencoded"
		},
		body: "ridx="+ridx
		})
		.then((aa)=>{
			return aa.text();
		})
		.then((res)=>{
			console.log(res);
			// success vs fail
			if(res=="success"){
				alert('사전 방문 예약취소가 정상적으로 이루어졌습니다.');
				location.href="./mainPage.do";
			}
			else{
				alert("오류로 인하여 삭제에 실패하였습니다.");
				history.go(-1);
			}
		})
		.catch((e)=>{
			console.log("삭제 요청 ERR");
			console.log(e);
		});	
	}
}