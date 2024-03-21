<%@page import="raemian.admin.domain.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
List<Notice> notices = (List<Notice>) request.getAttribute("notices");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/page_default.css?v=<%=System.currentTimeMillis()%>">
<link rel="stylesheet" href="../css/admin_css.css?v=<%=System.currentTimeMillis()%>">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<!-- 신규추가된 css 파일 -->
<link rel="stylesheet" href="../css/notice.css?v=">
<!-- 신규추가된 css 파일 끝-->
<title>관리자 페이지</title>
<script src="https://cdn.ckeditor.com/4.22.1/standard/ckeditor.js?<%=System.currentTimeMillis()%>"></script>
</head>
<body>
<%@ include file="./fragments/header.jsp" %>
<!-- 공지사항 관리 시작 -->
<main class="page_main">
<section class="page_section">
<div class="listbody">
    <div class="protitle">공지사항 관리</div>
    <div class="procho">
       <section class="search_part">
        <ol>
        <li>공지사항 검색</li>
        <li>
        <input type="text" id="searchWord" class="search_input">
        <input type="button" value="검색" onclick="searchByTitle();" class="datebtn">
        </li>        
        <li></li>
        <li></li> 
        </ol>
       </section> 
       <section class="data_listsview">
       <ul>
        <li>번호</li>
        <li>제목</li>
        <li>첨부파일 유/무</li>
        <li>조회수</li>
        <li>글쓴이</li>
        <li>등록일</li>
        <li>삭제</li>
       </ul>
       
       <c:if test="${not empty notices}">
       <c:forEach var="notice" items="${notices}" varStatus="loop">
       <ul>
        <li>${loop.index+1}</li>
        <li style="text-align: left; justify-content: flex-start;"
        onclick="notice_detail(${notice.nidx});">${notice.ntitle}</li>
        <li>${not empty notice.nfile ? 'O' : 'X'}</li>
        <li>${notice.ncount}</li>
        <li>${notice.nwriter}</li>
        <li>${notice.nindate}</li>
        <li>
            <input type="button" onclick="notice_delete(${notice.nidx});" value="삭제" class="delbtn">
        </li>
       </ul>
       </c:forEach>
       </c:if>
       
       <c:if test="${empty notices}">
	       <ul class="nodatas">
	        <li>등록된 공지사항이 없습니다.</li>
	       </ul>
       </c:if>
       <span class="notice_btns">
       <input type="button" value="글쓰기" onclick="noticeWriteForm();" class="meno_btn2"></span>
       <aside>
       <c:if test="${not empty notices}">
        <div class="page_number">
           <ul>
           <c:set var="searchWord" value="${param.searchWord}" />
           <!-- Page번호 시작 -->
			<c:forEach var="pNo" begin="${list.startPage}" end="${list.endPage}" step="1">
				<li style="color:white;"
				onclick="noticePagination(${pNo},'${not empty searchWord ? searchWord : ''}');"
				class="<c:if test='${param.currentPage eq pNo}'>active</c:if>">
				${pNo}
				</li>
			</c:forEach>
			<!-- Page번호 끝 -->      
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
<%@ include file="./fragments/footer.jsp" %>
<c:if test="${not empty successMsg}">
<script>
alert("${successMsg}");
</script>
</c:if>
<script src="../js/notice_main.js?v=<%=System.currentTimeMillis()%>"></script>
</body>
</html>