<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
<meta property="og:type" content="website">
<meta property="og:title" content="인천검단 레미안">
<title>인천검단 레미안</title>
<!-- css -->
<link rel="stylesheet" type="text/css" href="/raemian/client/css/normalize.css?v=<%=System.currentTimeMillis()%>">
<link rel="stylesheet" type="text/css" href="/raemian/client/css/slick.css?v=<%=System.currentTimeMillis()%>">
<link rel="stylesheet" type="text/css" href="/raemian/client/css/swiper.min.css?v=<%=System.currentTimeMillis()%>">
<link rel="stylesheet" type="text/css" href="/raemian/client/css/bootstrap.min.css?v=<%=System.currentTimeMillis()%>">
<link rel="stylesheet" type="text/css" href="/raemian/client/css/cal-style.css?v=<%=System.currentTimeMillis()%>">
<link rel="stylesheet" type="text/css" href="/raemian/client/css/common.css?v=<%=System.currentTimeMillis()%>">
<link rel="stylesheet" href="/raemian/client/dadmin/css/sweetalert.min.css?v=<%=System.currentTimeMillis()%>">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js?v=<%=System.currentTimeMillis()%>"></script>
<script src="/raemian/client/js/bootstrap.min.js"></script>
    
<link rel="stylesheet" type="text/css" href="/raemian/client/css/top.css?v=<%=System.currentTimeMillis()%>">
    
<!-- 추가된 css -->
<link rel="stylesheet" type="text/css" href="/raemian/client/css/new_member.css?v=<%=System.currentTimeMillis()%>">
<!-- 추가된 css -->
</head>

<body>
<!-- wrap -->
<div id="wrap">
	<!-- header 로고 & 대메뉴,소메뉴 -->
	<%@ include file="../fragments/header.jsp"%>
	<!-- header 로고 & 대메뉴,소메뉴 끝 -->


<div id="container">
<div id="index">
    
<!-- 서브 화면 시작 -->
    <label class="mbship_title">
        <p>FAQ</p>
        <ul>
          <li>RAEMIAN 자주묻는 질문</li>
        </ul>
      </label>
      <fieldset class="faq_box">
      
      	<c:forEach var="faq" items="${faqs}">
        <ul>
	        <li>질문</li>
	        <li class="faq-question">${faq.fquestion}</li>
	        <li class=".faq-answer" style="display: none;">${faq.fanswer}</li>
        </ul>
        </c:forEach>
        
      </fieldset>
    
<!-- 서브 화면 종료 -->
</div>
  <!-- 카피라이터 시작 -->
	  	<%@ include file="../fragments/footer.jsp"%>
 <!-- 카피라이터 종료 -->
</div>
    </div>
<script src="/raemian/js/main_faq/faq.js?v=<%=System.currentTimeMillis()%>"></script>
</body>
</html>
    