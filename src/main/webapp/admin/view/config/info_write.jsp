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
</head>
<body>
<%@include file="../fragments/header.jsp"%>
<!-- 세대정보 입력 시작 -->
<main class="page_main">
<section class="page_section">
<div class="listbody">
    <div class="protitle">환경설정 등록</div>
    <c:if test="${not empty errors}">
	    <div class="errors">
            <c:forEach items="${errors.allErrors}" var="error">
                <span style="color: red;">${error.defaultMessage}</span>
            </c:forEach>
	    </div>
	</c:if>
    
    <div class="procho">
    <form id="infoForm">
       <section class="data_listsview">
       <ol>
       <li>주거타입</li>
       <li><input type="text" name="atype" class="notice_in in2"> ※ 예) 74A 타입</li>
       <c:set var="loginedMember" value="${sessionScope.loginMember.aname}"/>
       <li>글쓴이</li>
       <li><input type="text" name="awriter" class="notice_in in2" value="${loginedMember}" readonly></li> 
       <li>주거전용</li>
       <li><input type="text" name="aprivate" class="notice_in in2">㎡&nbsp;&nbsp;&nbsp;※ 숫자만 입력하세요</li>
       <li>주거공용</li>
       <li><input type="text" name="apublic" class="notice_in in2">㎡&nbsp;&nbsp;&nbsp;※ 숫자만 입력하세요</li>
       <li>기타공용</li>
       <li><input type="text" name="aetcpublic" class="notice_in in2">㎡&nbsp;&nbsp;&nbsp;※ 숫자만 입력하세요</li>
       <li>계약면적</li>
       <li><input type="text" name="acontractSize" class="notice_in in2">㎡&nbsp;&nbsp;&nbsp;※ 숫자만 입력하세요</li>
       <li>이미지 URL</li>
       <li><input type="text" name="aimgUrl" class="notice_in in1">&nbsp;&nbsp;&nbsp;예시) http://abc.co.kr/123.jpg</li> 
       <li>사용 유/무</li>
       <li><input type="radio" name="ause" class="radio_txt" checked>사용함 <input type="radio" class="radio_txt">사용안함</li>
       <li>출력순서</li>
       <li><input type="text" name="aorder" class="notice_in in2">&nbsp;&nbsp;&nbsp;※ 숫자만 입력하세요 단, 동일한 이름일 경우 데이터 등록된 순으로 출력 됩니다.</li>
       </ol>
       <span class="notice_btns">
       <input type="button" onclick="addInfo();" value="주거타입 등록" class="meno_btn2"></span>
       </section>
       </form>
    </div>
</div> 
</section>
</main>
<!-- 세대정보 입력 끝 -->
<%@include file="../fragments/footer.jsp"%>
<script src="../js/info/info_write.js?v=<%=System.currentTimeMillis()%>"></script>
</body>
</html>