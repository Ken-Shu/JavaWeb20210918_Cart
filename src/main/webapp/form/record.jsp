<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart 10元商店 訂單紀錄</title>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
</head>
<body style="padding: 15px">

	<!-- 將這個表單 丟進去 action=的位置 -->
	<form class="pure-form" method="post">
		
		<fieldset>
			<legend>10元商店 訂單紀錄</legend>
			編號 : <input type="text" name="id" value="${user.id}"><p />
			 ${user.name} 的訂單紀錄 : 
			<table class="pure-table pure-table-bordered">
			
				<thead>
					<tr>
					<th>id</th><th>userId</th><th>productId</th><th>productNmae</th><th>ts</th>
					</tr>
				</thead>
			
				<c:forEach var="o" items="${orders}">
					<tr>
					<td>${o.id}</td>
					<td>${o.userId}</td>
					<td>${o.productId}</td>
					<td>
						<c:forEach var="p" items="${products }">
							<c:if test="${p.id eq o.productId }">
								${p.name }
							</c:if>
						</c:forEach>
					</td>
					<td>${o.ts}</td>
					</tr>
				</c:forEach>
			
			</table>
			<p />
			<button type="submit" class="pure-button pure-button-primary">加入購物車</button>
			
			<button type="button"
				onclick="location.href='${pageContext.request.contextPath}/form/index.jsp'"
				class="pure-button pure-button-primary">繼續購物</button>
			<button type="button"
				onclick="location.href='${pageContext.request.contextPath}/servlet/cart?type=1'"
				class="pure-button pure-button-primary">查詢購物車</button>
			<button type="button"
				onclick="location.href='${pageContext.request.contextPath}/logout'"
				class="pure-button pure-button-primary">登出</button>
		</fieldset>
	</form>

</body>
</html>