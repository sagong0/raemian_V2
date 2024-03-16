function trimWhitespace(str) {
    // 앞뒤 공백 제거 정규표현식
    return str.replace(/^\s+|\s+$/g, "");
}

document.querySelector("#n_searchBtn").addEventListener("click",function(){
	let form = document.getElementById("searchFF");
	
	form.submit();
});

function next_page(no){
	location.href="./notice.do?no="+no;
}