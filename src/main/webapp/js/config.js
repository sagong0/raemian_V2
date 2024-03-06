/**
 * 적용 클릭시 AJAX 요청
 */
function applyAdmin(idx){
	
	var status = document.getElementById("status"+idx);
	var statusVal = status.value;
	console.log("aidx = " + idx);
	console.log("selected Aidx value = " + statusVal);
	
	//var data = { "aidx": idx.toString(), "status": statusVal };
	
	fetch('../main/status', {
		  method:"POST",
		headers:{
			"Content-Type": "application/x-www-form-urlencoded"
		},
		  body: "aidx="+idx+"&status="+statusVal
		})
		.then((response) => response.text())
		.then(data => {
			if(data === "NO"){
				alert("적용 실패 하였습니다.");
			} else{
				alert("성공적으로 적용되었습니다.");
				window.location.href="../main/config"
			}
		})
		.catch(e => {
		  console.log(e);
		});
}

/**
 * 소속 change
 */
var selectbox_aarea = document.getElementById("aarea");
aarea.addEventListener("change", function(){
    var aareaVal = selectbox_aarea.value;
	location.href="../main/config?aarea="+ aareaVal
});

/* 소속 change 후 소속 selected 자동 업데이트되게 */
var url = new URLSearchParams(window.location.search);
var current_area = url.get("aarea");

if(selectbox_aarea){
	for(var i = 0; i<selectbox_aarea.options.length; i++){
		if(selectbox_aarea.options[i].value == current_area){
			selectbox_aarea.selectedIndex = i;
			break;
		}
	}	
}

function adminPagination(pNo, aarea){
	location.href="../main/config?currentPage="+pNo+"&aarea="+aarea;
}