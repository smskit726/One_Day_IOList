<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var = "rootPath" value="${pageContext.request.contextPath}"/>
<link href="${rootPath}/static/css/pro-detail.css?ver=0930_3"
	rel="stylesheet">
<script src="${rootPath}/static/js/pro-detail.js?ver=0930_2"></script>

<section id="detail-main">
	<article id="pro-info">
		<c:choose>
			<c:when test="${PROVO.io_input=='1'}">
				<h3>일자</h3><p>${PROVO.io_date}</p><br />
				<h3>시각</h3><p>${PROVO.io_time}</p><br />
				<h3>상품명</h3><p>${PROVO.io_pname}</p><br />
				<h3>매입단가</h3><p>${PROVO.io_price}</p><br />
				<h3>수량</h3><p>${PROVO.io_quan}</p><br />
				<h3>매입합계</h3><p>${PROVO.io_total}</p><br />				
			</c:when>
			
			<c:otherwise>
				<h3>일자</h3><p>${PROVO.io_date}</p><br />
				<h3>시각</h3><p>${PROVO.io_time}</p><br />
				<h3>상품명</h3><p>${PROVO.io_pname}</p><br />
				<h3>매출단가</h3><p>${PROVO.io_price}</p><br />
				<h3>수량</h3><p>${PROVO.io_quan}</p><br />
				<h3>매출합계</h3><p>${PROVO.io_total}</p><br />
			</c:otherwise>
		</c:choose>
	</article>
</section>
<hr/>

<section id="detail-menu">
	<a href="${rootPath}/">리스트</a>
	<a href="${rootPath}/update?id=${PROVO.seq}">수정</a>
	<a href="javascript:void(0)" id="pro-delete" data-id="${PROVO.seq}">삭제</a>
</section>