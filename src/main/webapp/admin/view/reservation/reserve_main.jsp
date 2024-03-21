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
<%@include file="../fragments/header.jsp" %>
<!-- 회원관리 시작 -->
<main class="page_main">
<section class="page_section">
<div class="listbody">
    <div class="protitle">사전예약 회원 관리</div>
    <div class="procho">
       <section class="search_part">
        <ol>
        <li>회원 검색</li>
        <li>
        <select id="searchType" class="search_select">
        <option value="아이디">아이디</option>    
        <option value="이름">이름</option>    
        <option value="연락처">연락처</option>    
        </select>
        <input type="text" name="searchVal" id="searchVal" class="search_input">
        <input type="button" id="searchBtn" value="검색" class="datebtn">
        </li>        
        <li></li>
        <li></li> 
        </ol>
       </section> 
       <section class="reserve_listsview">
       <ul>
        <li>번호</li>
        <li>아이디</li>
        <li>고객명</li>
        <li>연락처</li>
        <li>예약일자</li>
        <li>예약시간</li>
        <li>인원수</li>
        <li>예약취소</li>
       </ul>
       
       <c:if test="${not empty reserves}">
       <c:forEach var="reserve" items="${reserves}" varStatus="loop">
       <ul>
        <li>${loop.index+1}</li>
        <li>${reserve.rid}</li>
        <li>${reserve.rname}</li>
        <li>${reserve.rtel}</li>
        <li>${reserve.rdate }</li>
        <li>${reserve.rtime}</li>
        <li>${reserve.rcount}</li>    
        <li>
            <input type="button" onclick="cancel_reserve(${reserve.ridx});" value="취소" class="delbtn">
        </li>
       </ul>
       </c:forEach>
       </c:if>
       
       <c:if test="${empty reserves}">
       <ul class="nodatas">
        <li>사전예약 신청 회원이 없습니다.</li>
       </ul>
       </c:if>
       
       
       <aside>
       <c:if test="${not empty reserves}">
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
<!-- 회원관리 끝 -->
<%@include file="../fragments/footer.jsp" %>
<c:if test="${not empty msg}">
<script>
alert("${msg}");
</script>
</c:if>
<script src="../js/reserve/reserve_main.js?v=<%=System.currentTimeMillis()%>"></script>
</body>
</html>