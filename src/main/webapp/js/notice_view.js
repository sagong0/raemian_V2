function to_noticeList(){
	location.href="/raemian/notice/";
}

/**
 * 첨부파일 다운로드 PART
 */
function download_attach(nidx){
	location.href=`../attach/${nidx}`;
}