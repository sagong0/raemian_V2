<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="raemian.admin.domain.AdminMember"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
Date tt = new Date();
DateFormat dft = new SimpleDateFormat("yyyyMMddhms");
String dds = dft.format(tt);

List<AdminMember> admins = (List<AdminMember>) request.getAttribute("admins");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/page_default.css?v=<?php echo $daterecall?>">
<link rel="stylesheet" href="../css/admin_css.css?v=<?php echo $daterecall?>">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<title>관리자 페이지</title>
</head>
<body>
	<%@ include file="./fragments/header.jsp"%>
	<!-- 관리자 리스트 시작 -->
	<main class="page_main">
		<section class="page_section">
			<form id="frm" name="frm" method="post" onsubmit="return member_search();">
				<div class="listbody">
					<div class="adlisttitle">관리자 현황</div>
					<div class="procho">
						<ul>
							<li class="prochoL procfont">소속</li>
							<li class="prochoL ">
							<select class="adlistcsel1" name="aarea" id="aarea">
				                <option value="all">전체</option>
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
					</div>
					<div class="procho">
						<ul>
							<li class="prochoL procfont">검색형식</li>
							<li class="prochoL "><select class="adlistcsel1" name="search_part">
									<option>이름</option>
									<option>아이디</option>
									<option>연락처</option>
							</select></li>
							<li class="prochoL"><input type="text" class="adlistcsel1"></li>
							<li class="prochoL"><input type="submit" class="proclick" value="검색"></li>
							<li class="prochoL"><button type="button" class="proclick">전체</button></li>
						</ul>
					</div>
					<div class="protaball">
						<table width="1100">
							<thead>
								<tr style="color: white; background-color: rgb(67, 66, 66);">
									<td class="listcenter" width=50>NO</td>
									<td class="listcenter" width=150>구분</td>
									<td class="listcenter" width=150>아이디</td>
									<td class="listcenter" width=120>이름</td>
									<td class="listcenter" width=80>직책</td>
									<td class="listcenter" width=200>이메일</td>
									<td class="listcenter" width=120>연락처</td>
									<td class="listcenter" width=120>현황</td>
									<td class="listcenter" width=110>적용</td>
								</tr>
							</thead>
							<tbody>

								<c:if test="${empty admins}">
									<tr height="30">
										<td class="listcenter" colspan="9">등록된 관리자가 없습니다.</td>
									</tr>
								</c:if>

								<c:if test="${not empty admins}">
									<c:forEach var="admin" items="${admins}" varStatus="loop">
										<tr class="master_list">
											<td class="listcenter" width=50>${loop.index + 1}</td>
											<td class="listcenter" width=150>${admin.aarea}</td>
											<td class="listcenter" width=150>${admin.aid}</td>
											<td class="listcenter" width=120>${admin.aname}</td>
											<td class="listcenter" width=80>${admin.aposition}</td>
											<td class="listcenter" width=200>${admin.aemail}</td>
											<td class="listcenter" width=120>${admin.atel}</td>
											<td class="listcenter" width=120>
											<select id="status${admin.aidx}" class="adlistsel3">
													<c:choose>
														<c:when test="${admin.ause eq 'N'}">
															<option>근무중</option>
															<option selected>퇴직중</option>
														</c:when>
														<c:otherwise>
															<option selected>근무중</option>
															<option>퇴직중</option>
														</c:otherwise>
													</c:choose>
											</select></td>
											<td class="listcenter" width=110>
												<button type="button" class="listclick" onclick="applyAdmin(${admin.aidx});">적용</button>
											</td>
										</tr>
									</c:forEach>
								</c:if>
							</tbody>
						</table>
					</div>

					<div class="propagebt">
						<ul>
						<c:set var="aarea" value="${param.aarea}" />
						<!-- Previous 시작 -->
							<li style="color: white;" 
							onclick="adminPagination(${list.startPage > 5 ? listt.startPage - 5 : 1 },'${not empty aarea ? aarea : ''}');"
							<c:if test='${list.startPage<6 }'>disabled</c:if>>
							Prev</li>
							<!-- Page번호 시작 -->
							<c:forEach var="pNo" begin="${list.startPage}" end="${list.endPage}" step="1">
								<li style="color:white;"onclick="adminPagination(${pNo},'${not empty aarea ? aarea : ''}');" 
								<c:if test='${param.currentPage eq pNo }'>active</c:if>>
								${pNo}</li>
							</c:forEach>
							<!-- Page번호 끝 -->
							<!-- Next 시작 -->
							<li style="color: white;"
							onclick="adminPagination(${list.totalPages < 5 ? list.endPage : list.startPage+5 },'${not empty aarea ? aarea : ''}');" 
							<c:if test='${list.endPage>=list.totalPages }'>disabled</c:if> >
							Next</li>
							<!-- Next 끝 -->
						</ul>
					</div>
				</div>
			</form>
			<!-- 관리자 리스트 끝 -->
		</section>
	</main>
	<%@ include file="./fragments/footer.jsp"%>
	<script src="../js/config.js?v=<%=dds%>"></script>
</body>
</html>