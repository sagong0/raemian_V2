<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/page_default.css?v=">
<link rel="stylesheet" href="../css/admin_css.css?v=">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<!-- 신규추가된 css 파일 -->
<link rel="stylesheet" href="../css/notice.css?v=">
<!-- 신규추가된 css 파일 끝-->
<title>관리자 페이지</title>
<script>
</script>
</head>
<body>
<%@ include file="./fragments/header.jsp" %>
<!-- 공지사항 등록 시작 -->
<main class="page_main">
<section class="page_section">
<div class="listbody">
    <div class="protitle">공지사항 등록</div>
    <div class="procho">
       <section class="data_listsview">
       <ol>
       <li>공지제목</li>
       <li><input type="text" class="notice_in in1"></li>
       <li>글쓴이</li>
       <li><input type="text" class="notice_in in2" readonly></li> <li style="height:520px;">내용</li>
       <li style="height:520px; padding-top: 10px;">
       <textarea name="ncontent" class="notice_in in3"></textarea>
       </li>
       <li>첨부파일</li>
       <li><input type="file" name="nfile"></li>   
       </ol>
       <span class="notice_btns">
       <input type="button" value="글등록" class="meno_btn2">
       </span>
       </section>
    </div>
</div> 
</section>
</main>
<!-- 공지사항 등록 끝 -->
<%@ include file="./fragments/footer.jsp"%>
</body>
<script>
CKEDITOR.replace('editor1');
</script>
</html>