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
<%@ include file="../fragments/header.jsp" %>
<!-- FAQ 리스트 시작 -->
<main class="page_main">
<section class="page_section">
<div class="listbody">
    <div class="protitle">FAQ 관리</div>
    <div class="procho">
       <section class="search_part">
        <ol>
        <li>FAQ내용 검색</li>
        <li>
        <input type="text" class="search_input">
        <input type="button" value="검색" class="datebtn">
        </li>        
        <li></li>
        <li></li> 
        </ol>
       </section> 
       <section class="data_listsview2">
       <ul>
        <li>QA</li>
        <li>질문/답변</li>
        <li>글쓴이</li>
        <li>등록일</li>
        <li>삭제</li>
       </ul>
          
	<!-- FAQ 샘플 HTML 코드 시작 -->
	<c:if test="${not empty faqs}">
     <span>
     <c:forEach var="faq" items="${faqs}">
       <ul>
        <li>Q</li>
        <li style="text-align: left; justify-content: flex-start;">${faq.fquestion}</li>
        <li>관리자</li>
        <li>2023-10-06</li>
        <li>
        <input type="button" value="삭제" onclick="del_faq(${faq.fidx});" class="delbtn">
        </li>
       </ul>
      <!-- display:none 또는 display:flex 로 해야합니다. -->
       <ol style="display:none;" >
        <li>A</li>
        <li style="text-align: left; justify-content: flex-start;">${faq.fanswer}</li>
       </ol>
       </c:forEach>
     </span>
	<!-- FAQ 샘플 HTML 코드 끝 -->          
    </c:if>
    
       <c:if test="${empty faqs}">
       <ul class="nodatas">
        <li>등록된 FAQ 내용 없습니다.</li>
       </ul>
       </c:if>
       <span class="notice_btns">
       <input type="button" onclick="add_faq();" value="FAQ 등록" class="meno_btn2">
       </span>
       
       <aside>
        <div class="page_number">
           <ul>
           <!-- Page번호 시작 -->
			<c:forEach var="pNo" begin="${list.startPage}" end="${list.endPage}" step="1">
				<li style="color:white;"
				onclick="faqPagination(${pNo});"
				class="<c:if test='${param.currentPage eq pNo}'>active</c:if>">
				${pNo}
				</li>
			</c:forEach>
			<!-- Page번호 끝 -->
           </ul>
        </div>
       </aside>
       </section>
    </div>
</div> 
</section>
</main>
<!-- FAQ 리스트 끝 -->
<%@include file="../fragments/footer.jsp" %>

<c:if test="${not empty successMsg}">
<script>alert("${successMsg}");</script>
</c:if>

<c:if test="${not empty failMsg}">
<script>alert("${failMsg}");</script>
</c:if>

<script src="../js/faq.js?v=<%=System.currentTimeMillis()%>"></script>
</body>
</html>