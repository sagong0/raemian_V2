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
	<%@ include file="../fragments/header.jsp" %>
	<!-- header 로고 & 대메뉴,소메뉴 끝 -->


<div id="container">
<div id="index">
    
<div class="sub_title">
<section class="sub_image">
<span>
최적의 입주환경을 준비하는 입주 전 서비스<br>
두근두근 설레는 마음, 레미안 입주를 앞둔 고객님을 위한 사전방문 예약 입니다.</span>
</section>    
</div>    
    
<!-- 예약취소 화면 시작 -->
    <label class="mbship_title">
        <p>RESERVATION CANCEL</p>
        <ul>
          <li style="color: red;">※ 예약취소시 해당 데이터는 복구 되지 않습니다.</li>
        </ul>
      </label>
    <form>
      <fieldset class="mbship_box">
        <h3>예약확인</h3>
        <span class="agree_span">
        <ol class="mbinfos">
        <li><em class="ck_font">■</em> 아이디</li>
        <li>${sessionScope.loginMember.mid}</li>
        <li><em class="ck_font">■</em> 고객명</li>
        <li>${sessionScope.loginMember.mname}</li>
        <li><em class="ck_font">■</em> 예약일자</li>
        <li>${reserve.rdate}</li>
        <li><em class="ck_font">■</em> 예약시간</li>
        <li>${reserve.rtime}</li>
        <li><em class="ck_font">■</em> 휴대전화번호</li>
        <li>
        ${reserve.rtel}
        </li>
        <li><em class="ck_font">■</em> 인원수</li>
        <li>
        <label class="ck_label">${reserve.rcount}</label>
        </li>
        </ol>
        </span>
        <span class="span_buttons">
        <button type="button" id="cancelBtn" class="next_btn1_1">예약취소</button>
        </span>
      </fieldset>
    </form>
<!-- 예약취소 화면 종료>
</div>
  <!-- 카피라이터 시작 -->
  <%@ include file="../fragments/footer.jsp" %>
 <!-- 카피라이터 종료 -->
</div>
    </div>
    <script>
    var cancelBtn = document.getElementById("cancelBtn");
    cancelBtn.addEventListener("click",function(){
    	alert("aa");
    })
    </script>
    
</body>
</html>
    