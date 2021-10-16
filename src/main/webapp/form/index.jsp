<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart 10元商店</title>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
</head>
<body style="padding: 15px">

	<!-- 將這個表單 丟進去 action=的位置 -->
	<form class="pure-form" method="post"
		action="${pageContext.request.contextPath}/servlet/cart">
		<fieldset>
			<legend>10元商店 請選擇禮品</legend>
			編號 : <input type="text" name="id" value=""><p />
			禮品 : <p />
				<input type="checkbox" name = "data" value="書本">書本 <p />
			 	<input type="checkbox" name = "data" value="鉛筆">鉛筆 <p />
			 	<input type="checkbox" name = "data" value="墊板">墊板 <p />
			 	<input type="checkbox" name = "data" value="橡皮">橡皮 <p />
			 	<input type="checkbox" name = "data" value="彈珠">彈珠 <p />
			<p />
			<button type="submit" class="pure-button pure-button-primary">加入購物車</button>
			
			<button type="button"
				onclick="location.href='${pageContext.request.contextPath}/servlet/cart?type=1'"
				class="pure-button pure-button-primary">查詢購物車</button>
			<button type="button"
				onclick="location.href='${pageContext.request.contextPath}/servlet/cart?type=2'"
				class="pure-button pure-button-primary">查詢訂單紀錄</button>
		</fieldset>
	</form>

</body>
</html>