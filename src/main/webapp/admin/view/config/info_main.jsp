<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<%@ include file="../fragments/header.jsp"%>
<!-- 환경설정 관리 시작 -->
<main class="page_main">
<section class="page_section">
<div class="listbody">
    <div class="protitle">환경설정 관리</div>
    <div class="procho">
       <section class="search_part">
        <ol>
        <li>세대정보 검색</li>
        <li>
        <input type="text" id="searchinput" class="search_input">
        <input type="button" id="searchBtn" value="검색" class="datebtn">
        </li>        
        <li></li>
        <li></li> 
        </ol>
       </section> 
       <section class="data_listsview">
       <ul>
        <li>번호</li>
        <li>세대타입 및 면적</li>
        <li>사용 유/무</li>
        <li>출력순서</li>
        <li>글쓴이</li>
        <li>등록일</li>
        <li>삭제</li>
       </ul>
       
       <c:if test="${not empty configs}">
       <c:forEach var="config" items="${configs}" varStatus="loop">
       <ul style="height:140px;">
	   		<li>${loop.index + 1}</li>
		  	<li style="text-align: left; justify-content: flex-start;">
	        <div class="info_img">
	        <img src="${config.aimgUrl}">
	        </div>
	        <div class="info_text">
		        <span>주거타입 : ${config.atype}</span>
		        <span>주거전용 : ${config.aprivate}</span>
		        <span>주거공용 : ${config.apublic}</span>
		        <span>기타공용 : ${config.aetcpublic}</span>
		        <span>계약면적 : ${config.acontractSize}</span>
	        </div>
	        </li>
	        <li>${config.ause}</li>
	        <li>${config.aorder}</li>
	        <li>${config.awriter}</li>
	        <li>${config.aindate}</li>
	        <li>
	            <input type="button" onclick="del_config(${config.aidx});" value="삭제" class="delbtn">
	        </li>
	       </ul>
       </c:forEach>
       </c:if>
       
       <c:if test="${empty configs}">
       <ul class="nodatas">
        <li>등록된 세대타입 내용이 없습니다.</li>
       </ul>
       </c:if>
       
       <span class="notice_btns">
       <input type="button" id="createBtn" value="세대타입 생성" class="meno_btn2"></span>
       <aside>
       <c:if test="${not empty configs }">
        <div class="page_number">
           <ul>
           <li>1</li>
           </ul>
        </div>
        </c:if>
       </aside>
       </section>
    </div>
</div> 
</section>
</main>
<!-- 공지사항 관리 끝 -->
<%@ include file="../fragments/footer.jsp"%>
<c:if test="${not empty msg}">
<script> alert("${msg}"); </script>
</c:if>
<script src="../js/info/info_main.js?v=<%=System.currentTimeMillis()%>"></script>
</body>
</html>