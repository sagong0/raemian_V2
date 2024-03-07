<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/admin_css.css?v=30">
<link rel="stylesheet" href="../css/page_default.css?v=25">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<title>관리자 페이지</title>
</head>
<body>
<%@ include file="./fragments/header.jsp"%>


<main>
<section>
   <div class="ad_top" ></div>
   
 <div class="ad_mainall">
   <div class="ad_main">
<!-- 일반회원 리스트 시작(추가) -->
       <div class="ad_main1">
         <ul>
            <li class="ad_maintitle">일반회원</li>
            <li class="ad_mainbox">
            <ol>
                <li>아이디</li>
                <li>고객명</li>
                <li>연락처</li>
                <li>이메일</li>
                <li>주소</li>
            </ol>
            <ol class="bgcancel">
                <li>hong</li>
                <li>홍길동</li>
                <li>01012345678</li>
                <li>hong@nate.com</li>
                <li style="text-align: left;">(05611) 서울시 종로구 종로3가 국일빌딩 5층</li>
            </ol>  
            </li>
         </ul>
      </div>
<!-- 일반회원 리스트 끝(추가) -->
   </div>
   <div class="ad_main">
      <div class="ad_main1">
         <ul>
            <li class="ad_maintitle">1:1 문의사항</li>
            <li class="ad_mainbox"></li>
         </ul>
      </div>
   </div>
   <div class="ad_main">
      <div class="ad_main1">
         <ul>
            <li class="ad_maintitle">예약현황</li>
            <li class="ad_mainbox2">
            <ol>
                <li>아이디</li>
                <li>고객명</li>
                <li>연락처</li>
                <li>예약일자</li>
                <li>예약시간</li>
                <li>예약인원</li>
            </ol>
            <ol class="bgcancel">
                <li>hong</li>
                <li>홍길동</li>
                <li>01012345678</li>
                <li>2023-10-09</li>
                <li>10:00</li>
                <li>2명</li>
            </ol>  
            </li> 
         </ul>
      </div>
   </div>
 </div>
<!-- 관리자 메인 파트 끝 -->
   <div class="ad_botom"></div>
</section>
</main>
<%@ include file="./fragments/footer.jsp" %>
<script src="../js/menus.js?v=2"></script>
</body>
</html>