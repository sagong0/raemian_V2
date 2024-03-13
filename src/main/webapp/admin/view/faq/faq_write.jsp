<%@page import="raemian.admin.domain.AdminMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%
AdminMember loginedMember = (AdminMember) session.getAttribute("loginMember");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/page_default.css?v=<%=System.currentTimeMillis()%>">
<link rel="stylesheet" href="../css/admin_css.css?v=<%=System.currentTimeMillis()%>">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<!-- 신규추가된 css 파일 -->
<link rel="stylesheet" href="../css/notice.css?v=<%=System.currentTimeMillis()%>">
<!-- 신규추가된 css 파일 끝-->
<title>관리자 페이지</title>
<script>
</script>
</head>
<body>
<%@ include file="../fragments/header.jsp" %>
<!-- 공지사항 등록 시작 -->
<main class="page_main">
<section class="page_section">
<div class="listbody">
    <div class="protitle">FAQ 등록</div>
    
    <div class="procho">
    <form id="faqForm">
       <section class="data_listsview">
	       <ol>
		       <li>질문제목</li>
		       <li><input type="text" name="fquestion" class="notice_in in1"></li>
		       <li>글쓴이</li>
		       <li><input type="text" name="fwriter" class="notice_in in2" value="<%=loginedMember.getAname() %>" readonly></li> 
		       <li style="height:520px;">내용</li>
		       <li style="height:520px; padding-top: 10px;">
		       <textarea class="notice_in in3" name="fanswer"></textarea>
		       </li>
	       </ol>
	       <span class="notice_btns">
	       <input type="button" value="글등록" onclick="register_faq();" class="meno_btn2"></span>
       </section>
       </form>
    </div>
</div> 
</section>
</main>
<!-- 공지사항 등록 끝 -->
<%@ include file="../fragments/footer.jsp" %>

<c:if test="${not empty failMsg}">
<script>alert("${failMsg}");</script>
</c:if>

<script src="../js/faq.js?v=<%=System.currentTimeMillis()%>"></script>
</body>
</html>