<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
<meta property="og:type" content="website">
<meta property="og:title" content="인천검단 레미안">
<title>인천검단 레미안</title>
<!-- css -->
<link rel="stylesheet" type="text/css" href="css/normalize.css?v=<%=System.currentTimeMillis()%>">
<link rel="stylesheet" type="text/css" href="css/slick.css?v=<%=System.currentTimeMillis()%>">
<link rel="stylesheet" type="text/css" href="css/swiper.min.css?v=<%=System.currentTimeMillis()%>">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css?v=<%=System.currentTimeMillis()%>">
<link rel="stylesheet" type="text/css" href="css/cal-style.css?v=<%=System.currentTimeMillis()%>">
<link rel="stylesheet" type="text/css" href="css/common.css?v=<%=System.currentTimeMillis()%>">
<link rel="stylesheet" href="./dadmin/css/sweetalert.min.css?v=<%=System.currentTimeMillis()%>">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js?v=<%=System.currentTimeMillis()%>"></script>
<script src="js/bootstrap.min.js"></script>
    
<link rel="stylesheet" type="text/css" href="./css/top.css??v=<%=System.currentTimeMillis()%>">
    
<!-- 추가된 css -->
<link rel="stylesheet" type="text/css" href="./css/new_member.css??v=<%=System.currentTimeMillis()%>">
<!-- 추가된 css -->
</head>

<body>
<!-- wrap -->
<div id="wrap">
	<!-- header 로고 & 대메뉴,소메뉴 -->
	<%@ include file="../fragments/header.jsp" %>
	<!-- header 로고 & 대메뉴,소메뉴 끝 -->


<div id="container">
<div id="index">
    
<!-- 서브 화면 시작 -->
<label class="mbship_title">
        <p>MEMBER-SHIP</p>
        <ul>
          <li>01. 약관동의</li>
          <li><img src="./img/step_on.png" /></li>
          <li>02. 정보입력</li>
          <li><img src="./img/step_off.png" /></li>
          <li>03. 가입완료</li>
        </ul>
      </label>
      
      <form id="agreeForm">
      <fieldset class="mbship_box">
        <h3>약관동의</h3>
        <span class="agree_span">
        <label class="mbship_text">
          <input type="checkbox" id="all_agree" name="all" onclick="allagree(this.checked)" /> 의 모든 약관을 확인하고 전체 동의 합니다.
          (전체동의, 선택항목도 포함됩니다.)
        </label>
        <label class="mbship_text">
            <input type="checkbox" id="a1" name="a1" onclick="chbox(this.checked);"><font color="red"> (필수)</font>이용약관
        </label>
        <div class="agree_text" id="agree1"></div>
        <label class="mbship_text">
            <input type="checkbox" id="a2" name="a2" onclick="chbox(this.checked);"><font color="red"> (필수)</font> 개인정보 수집 및 이용
        </label>
        <div class="agree_text" id="agree2"></div>
        </span>
        <button type="button" id="nextBtn" class="next_btn">다음단계</button>
      </fieldset>
      </form>
<!-- 서브 화면 종료 -->
</div>
  <!-- 카피라이터 시작 -->
  <%@include file="../fragments/footer.jsp" %>
  <script src="../js/login/agree.js?v=<%=System.currentTimeMillis()%>"></script>
 <!-- 카피라이터 종료 -->
</div>
    </div>
</body>
</html>
