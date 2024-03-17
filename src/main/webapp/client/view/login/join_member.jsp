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
    
<link rel="stylesheet" type="text/css" href="./css/top.css?v=1">
    
<!-- 추가된 css -->
<link rel="stylesheet" type="text/css" href="./css/new_member.css?v=26">
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
    
<!-- 회원가입 화면 시작 -->
    <label class="mbship_title">
        <p>MEMBER-SHIP</p>
        <ul>
          <li style="color: #000;">01. 약관동의</li>
          <li><img src="./img/step_off.png" /></li>
          <li style="color: #1B9C9E;">02. 정보입력</li>
          <li><img src="./img/step_on.png" /></li>
          <li>03. 가입완료</li>
        </ul>
      </label>
      
      <form id="joinForm">
      <fieldset class="mbship_box">
        <h3>기본정보 입력 <span style="display: inline-block; font-size: 12px; vertical-align: 5px; float: right;">■ 표시는 필수 입력 항목입니다.</span></h3>
        <span class="agree_span">
        <ol class="mbinfos">
        <li><em class="ck_font">■</em> 이름</li>
        <li><input type="text" name="mname" class="mbinput1" placeholder="이름을 입력하세요"></li>
        <li><em class="ck_font">■</em> 아이디</li>
        <li>
        <input type="text" id="mid" name="mid" class="mbinput2" placeholder="6~12자의 아이디를 입력하세요">
        <button type="button" id="checkIdBtn" class="mb_btn1">중복확인</button>
        </li>
        <li><em class="ck_font">■</em> 비밀번호</li>
        <li>
        <input type="text" name="mpw" class="mbinput3" placeholder="8~14자의 패스워드를 입력하세요">
        </li>
        <li><em class="ck_font">■</em> 비밀번호 확인</li>
        <li>
        <input type="text" name="mpw2" class="mbinput3" placeholder="동일한 패스워드를 입력하세요">
        </li>
        <li><em class="ck_font">■</em>휴대전화번호</li>
        <li>
        <input type="text" name="mtel" class="mbinput2" placeholder="숫자만 입력하세요">
        <button type="button" id="sendSmsBtn" class="mb_btn1">인증발송</button>
        </li>
        <li><em class="ck_font">■</em> 인증번호</li>
        <li>
        <input type="text" name="certification_num" class="mbinput2" placeholder="숫자 6자리를 입력하세요" maxlength="6">
        <button type="button" id="checkSms" class="mb_btn1">인증완료</button>
        </li>
        <li> 이메일</li>
        <li>
        <input type="text" name="memail" onkeyup="emailcheck(this.value);" class="mbinput3" 
        placeholder="이메일을 입력하세요">
        </li>
        <li style="height: 125px;"><em class="ck_font">■</em> 주소</li>
        <li style="height: 120px; line-height: normal; margin-top: 5px;">
        <input type="text" name="mzipcode" class="mbinput1" placeholder="우편번호" maxlength="5" readonly>
        <button type="button" id="findAddrBtn" class="mb_btn1">주소찾기</button>
        <input type="text" name="mstreetaddr" class="mbinput4" placeholder="도로명 주소" readonly>
        <input type="text" name="mdetailaddr" class="mbinput4" placeholder="상세주소를 입력하세요" readonly>
        </li>
        <li style="height: 100px;"> 마케팅 수신여부</li>
        <li style="height: 100px;">
        <label class="ck_label"><input type="checkbox" id="ckemail" disabled="disabled"
         name="ckemail" class="mbinput5"> 이메일 </label>
        <label class="ck_label"><input type="checkbox" name="cktel" class="mbinput5"> 전화 </label>
        <label class="ck_label"><input type="checkbox" name="ckaddr" class="mbinput5"> 우편물 </label>
        <label class="ck_label"><input type="checkbox" name="cksms" class="mbinput5"> SMS (문자 메세지)</label><br>
        선택하신 정보 수신에 동의하겠습니다. (서비스, 이벤트 소식 등의 홍보/마케팅 정보를 수신하게 됩니다.)
        </li>
        </ol>
        </span>
        <span class="span_buttons">
        <button type="button" id="joinBtn" class="next_btn1_1">회원가입</button>
        <button type="button" class="next_btn2_1">가입취소</button>
        </span>
      </fieldset>
      </form>
</div>    
<!-- 회원가입 화면 종료 -->
<!-- 카피라이터 시작 -->
<%@ include file="../fragments/footer.jsp"%>	  	
 <!-- 카피라이터 종료 -->
 <script src="../js/login/join_member.js?v=<%=System.currentTimeMillis()%>"></script>
 <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</div>
    </div>
</body>
</html>
    