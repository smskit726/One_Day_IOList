<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link href="${rootPath}/static/css/index.css?ver=0929_3"
	rel="stylesheet">
<title>Loo9 Shop</title>
</head>
<body>
	<header>
		<h2>Loo9 매입매출</h2>
	</header>

	<section id="main-section">
		<c:choose>
			<c:when test="${BODY == 'PRO-LIST'}">
				<%@ include file="/WEB-INF/views/product/pro-list.jsp" %>
			</c:when>
			<c:when test="${BODY =='PRO-WRITE'}">
				<%@ include file="/WEB-INF/views/product/pro-write.jsp"%>
			</c:when>
			
		</c:choose>
	</section>


	<footer>
		<address>CopyRight &copy; smskit726@naver.com</address>
	</footer>
</body>
</html>