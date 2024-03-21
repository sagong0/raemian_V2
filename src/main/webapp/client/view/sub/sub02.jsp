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
<link rel="stylesheet" type="text/css" href="css/normalize.css">
<link rel="stylesheet" type="text/css" href="css/slick.css">
<link rel="stylesheet" type="text/css" href="css/swiper.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/cal-style.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" href="./dadmin/css/sweetalert.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
    
<link rel="stylesheet" type="text/css" href="./css/top.css?v=2">
    
<!-- 추가된 css -->
<link rel="stylesheet" type="text/css" href="./css/new_member.css?v=26">
<!-- 추가된 css -->
</head>

<body>
<!-- wrap -->
<div id="wrap">
<!-- header 로고 & 대메뉴,소메뉴 -->
<%@include file="../fragments/header.jsp" %>
<!-- header 로고 & 대메뉴,소메뉴 끝 -->


<div id="container">
<div id="index">    
<!-- 입지안내 화면 시작 -->    
<div class="sub_title">
<section class="sub_image1">
<span>
Experience of PRIDE<br>
남다른 삶의 자부심, 레미안의 핵심가치를 통해 경험해 보세요.
</span>
</section>    
</div>    
    <label class="mbship_title">
        <p>입지안내</p>
        <ul>
          <li style="color: #000;">※ 레미안 주위 입지를 확인하실 수 있습니다.</li>
        </ul>
      </label>
 <fieldset class="mbship_box" style="overflow: hidden;">
<img src="./img/01_02.png">
 </fieldset>
<!-- 입지안내 화면 끝 -->
    
</div>
    
<!-- 카피라이터 시작 -->
<%@include file="../fragments/footer.jsp" %>    
<!-- 카피라이터 종료 -->
</div>
    </div>
</body>
</html>
