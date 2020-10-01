<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var = "rootPath" value="${pageContext.request.contextPath}"/>
<link href="${rootPath}/static/css/pro-write.css?ver=0929_2" rel="stylesheet"/>
<script src="${rootPath}/static/js/pro-write.js?ver=0929_2"></script>

<form:form id="product" modelAttribute="PROVO">
	<fieldset>
		<legend>상품매입매출</legend>
		
			<div class="hidden">
				<label for="seq"></label>
				<form:input path="seq" type="hidden"/>
			</div>
		
			<div class="hidden">
				<label for="io_date"></label>
				<form:input path="io_date" type="hidden"/>
			</div>
			
			<div class="hidden">
				<label for="io_time"></label>
				<form:input path="io_time" type="hidden"/>
			</div>
					
			<div>
				<label for="io_pname">상품명</label>
				<form:input path="io_pname" placeholder="상품명"/>
			</div>
			
			<div>
				<label for="io_input">구분</label>
				<form:select path="io_input">
					<option value="1">매입</option>
					<option value="2">매출</option>
				</form:select>
			</div>
			
			<div>
				<label for="io_price">단가</label>
				<form:input path="io_price" placeholder="단가"/>
			</div>
			
			<div>
				<label for="io_quan">수량</label>
				<form:input path="io_quan" placeholder="수량"/>
			</div>
			
			<div class="btn-box">
				<button id="btn-save">저장</button>
			</div>
	</fieldset>
</form:form>