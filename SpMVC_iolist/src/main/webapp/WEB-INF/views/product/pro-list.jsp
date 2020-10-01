<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script src="${rootPath}/static/js/home.js?ver=0930_1"></script>


<table id="product-list">
	<tr>
		<th>No</th>
		<th>일자</th>
		<th>시각</th>
		<th>상품명</th>
		<th>매입단가</th>
		<th>판매단가</th>
		<th>수량</th>
		<th>매입합계</th>
		<th>판매합계</th>
	</tr>
	<c:forEach items="${PRODUCTS}" var="product" varStatus="i">
		<c:choose>
			<c:when test="${product.io_input=='1'}">
				<tr class= pro_item data-id="${product.seq}">
					<td>${i.count}</td>
					<td>${product.io_date}</td>
					<td>${product.io_time}</td>
					<td>${product.io_pname}</td>
					<td>${product.io_price}</td>
					<td></td>
					<td>${product.io_quan}</td>
					<td class="i_price">${product.io_total}</td>
					<td></td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr class= pro_item data-id="${product.seq}">
					<td>${i.count}</td>
					<td>${product.io_date}</td>
					<td>${product.io_time}</td>
					<td>${product.io_pname}</td>
					<td></td>
					<td>${product.io_price}</td>
					<td>${product.io_quan}</td>
					<td></td>
					<td class="o_price">${product.io_total}</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<tr>
		<td colspan="7">합계 ( 단위 : 원 )</td>
		<td id="i_total"></td>
		<td id="o_total"></td>
	</tr>
</table>

<div id="new-write">
	<a href="${rootPath}/write">새로 작성</a>
</div>