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
<%@include file="./fragments/header.jsp"%>
<!-- 회원관리 시작 -->
<main class="page_main">
<section class="page_section">
<div class="listbody">
    <div class="protitle">회원 관리</div>
    <div class="procho">
       <section class="search_part">
        <ol >
        <li>회원 검색</li>
        <li>
        <select class="search_select">
        <option>아이디</option>    
        <option>이름</option>    
        <option>연락처</option>    
        </select>
        <input type="text" id="sdate2" class="search_input">
        <input type="button" value="검색" class="datebtn">
        </li>        
        <li></li>
        <li></li> 
        </ol>
       </section> 
       <section class="member_listsview">
       <ul>
        <li>번호</li>
        <li>아이디</li>
        <li>고객명</li>
        <li>연락처</li>
        <li>이메일</li>
        <li>주소</li>
        <li>이메일</li>
        <li>전화</li>
        <li>우편물</li>
        <li>SMS</li>
        <li>삭제</li>
       </ul>
       
       <c:forEach var="admin" items="${admins}" varStatus="">
       <ul>
        <li>1</li>
        <li>hong</li>
        <li>홍길동</li>
        <li>01012345678</li>
        <li>hong@nxate.com</li>
        <li style="justify-content: flex-start;">(05611) 서울시 종로구 종로3가 국일빌딩 5층</li>
        <li>Y</li>   
        <li>N</li>  
        <li>Y</li>   
        <li>N</li>   
        <li>
            <input type="button" value="삭제" class="delbtn">
        </li>
       </ul>
       </c:forEach>
       <ul class="nodatas">
        <li>등록된 회원이 없습니다.</li>
       </ul>
       <aside>
        <div class="page_number">
           <ul>
           <li>1</li>      
           </ul>
        </div>
       </aside>
       </section>
    </div>
</div> 
</section>
</main>
<!-- 회원관리 끝 -->
<%@include file="./fragments/footer.jsp"%>
</body>
</html>