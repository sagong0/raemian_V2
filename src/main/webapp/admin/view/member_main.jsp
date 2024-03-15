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
        <select id="searchType" name="searchType" class="search_select">
	        <option value="아이디">아이디</option>   
	        <option value="이름">이름</option>
	        <option value="연락처">연락처</option>
        </select>
        <input type="text" id="searchVal" class="search_input">
        <input type="button" id="searchBtn" value="검색" class="datebtn">
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
       
       <c:if test="${not empty members}">
       <c:forEach var="member" items="${members}" varStatus="loop">
       <ul>
        <li>${loop.index+1}</li>
        <li>${member.mid }</li>
        <li>${member.mname}</li>
        <li>${member.mtel }</li>
        <li>${member.memail}</li>
        <li style="justify-content: flex-start;">${member.mstreetaddr}</li>
        <li>${member.ckemail}</li>   
        <li>${member.cktel}</li>  
        <li>${member.ckaddr}</li>   
        <li>${member.cksms }</li>   
        <li>
            <input type="button" onclick="del_member(${member.midx})" value="삭제" class="delbtn">
        </li>
       </ul>
       </c:forEach>
       </c:if>
       
       <c:if test="${empty members}">
       <ul class="nodatas">
        <li>등록된 회원이 없습니다.</li>
       </ul>
       </c:if>
       
       
       <aside>
        <div class="page_number">
           <ul>
           <c:set var="aarea" value="${param.aarea}" />
           <!-- Page번호 시작 -->
			<c:forEach var="pNo" begin="${list.startPage}" end="${list.endPage}" step="1">
				<li style="color:white;"onclick="memberPagination(${pNo},'${not empty searchDto ? searchDto.searchType : ''}','${not empty searchDto ? searchDto.searchVal : ''}');" 
				<c:if test='${param.currentPage eq pNo }'>active</c:if>>
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
<!-- 회원관리 끝 -->
<%@include file="./fragments/footer.jsp"%>
<c:if test="${not empty msg}">
<script>alert("${msg}");</script>
</c:if>

<script src="../js/member_main.js?v=<%=System.currentTimeMillis()%>"></script>
</body>
</html>