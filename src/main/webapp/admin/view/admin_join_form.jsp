<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Date today = new Date();
DateFormat df = new SimpleDateFormat("yyyyMMddhms");
String datess = df.format(today);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/admin_css.css?v=<%=datess%>">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<title>관리자 페이지</title>
</head>
<body>
    <form id="joinForm">
        <div class="membody">
           <div class="adtitle">ADMINISTRATOR MEMBERSHIP</div>
           <div class="memoutline" >
              <div class="memsel1">
                <ul class="memu">
                    <li class="memfont">소속 및 부서선택</li>
                    <li class="memlisel1">
                        <select name="aarea" class="kosel">
                            <option value="">소속선택</option>
                            <option value="본사">본사</option>
                            <option value="경기도">경기도</option>
                            <option value="인천">인천</option>
                            <option value="대전">대전</option>
                            <option value="세종">세종</option>
                            <option value="광주">광주</option>
                            <option value="대구">대구</option>
                            <option value="울산">울산</option>
                            <option value="전라남도">전라남도</option>
                            <option value="전라북도">전라북도</option>
                            <option value="충청남도">충청남도</option>
                            <option value="충청북도">충청북도</option>
                            <option value="경상남도">경상남도</option>
                            <option value="경상북도">경상북도</option>
                            <option value="제주도">제주도</option>                            
                        </select>
                    </li>
                </ul>
                <ul class="memu">
                    <li class="memlisel1">
                        <select name="adept" class="kosel">
                            <option value="">부서선택</option>
                            <option value="임원">임원</option>
                            <option value="회계팀">회계팀</option>
                            <option value="영업팀">영업팀</option>
                            <option value="전산팀">전산팀</option>
                            <option value="디자인팀">디자인팀</option>
                            <option value="MD팀">MD팀</option>
                            <option value="고객관리팀">고객관리팀</option>
                        </select>
                    </li>
                  </ul>
              </div>
              <div class="memsel1">
                <ul class="memu">
                    <li class="memfont">이름</li>
                    <li>
                    	<input type="text" class="admamber1" id="aname" name="aname" 
                    	value="" placeholder="이름을 입력해 주세요">
                    </li>
                    <li class="memfont1">직책</li>
                    <li>
                        <select name="aposition" class="kosel">
                            <option value="임원">임원</option>
                            <option value="실장">실장</option>
                            <option value="팀장">팀장</option>
                            <option value="부장">부장</option>
                            <option value="차장">차장</option>
                            <option value="과장">과장</option>
                            <option value="대리">대리</option>
                            <option value="주임">주임</option>
                            <option value="사원">사원</option>
                            <option value="전체 관리자">전체 관리자</option>
                        </select>
                    </li>
                </ul>
              </div>
             <div class="memsel2">
                <ul>
                    <li class="memfont">아이디</li>
                    <li><input type="text" class="admamber2" id="" name="aid" value="" placeholder="아이디를 입력해 주세요"></li>
                    <li><button class="idcheck" id="ck_idBtn" name="" value="">중복체크</button></li>
                </ul>    
              </div>
              <div class="memsel2">
                <ul>
                    <li class="memfont">패스워드</li>
                    <li><input type="password" class="admamber1" id="" name="apw1" value="" placeholder="패스워드를 입력해 주세요"></li>
                    <li class="memfont">패스워드확인</li>
                    <li><input type="password" class="admamber4" id="" name="apw2" value="" placeholder="동일한 패스워드를 입력해 주세요"></li>
                </ul>    
              </div>
              <div class="memsel3">
                <ul>
                    <li class="memfont">이메일</li>
                    <li><input type="text" class="admamber3" id="" name="aemail" value="" placeholder="이메일을 입력해 주세요"></li>
                </ul>    
              </div>
              <div class="memsel4">
                <ul>
                    <li class="memfont">연락처</li>
                    <li>
                        <select class="adnumber" name="atell1" id="">
                            <option value="010">010</option>
                            <option value="011">011</option>
                        </select>
                    </li>
                    <li class="ad_number">-</li>
                    <li>
                    <input type="text" class="adnumber" id="" name="atell2" onkeyup="tell_value();" maxlength="4">
                    </li>
                    <li class="ad_number">-</li>
                    <li>
                    <input type="text" class="adnumber" id="" name="atell3" onkeyup="tell_value();" maxlength="4">
                    </li>
                    <li>
                    <input type="hidden" name="atel"/>
                    </li>
                </ul>    
              </div> 
           </div>
        </div>
       <div class="admembt">
         <ul>
           <li><button type="button" class="admembt_ok" id="adm_ok">신청하기</button></li>
           <li><button type="button" class="admembt_no" id="adm_cancel">취소하기</button></li>
        </ul>
       </div>
    </form> 
</body>
<script src="../js/joinForm.js?v=<%=datess%>"></script>
</html>