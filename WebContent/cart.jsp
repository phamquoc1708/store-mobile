<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./assets/themify-icons/themify-icons.css">
<link rel="stylesheet" href="./assets/css/grid.css">
<link rel="stylesheet" href="./assets/css/style.css">
<link rel="stylesheet" href="./assets/css/style_cart.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="body">
		<div class="grid wide">
		<c:forEach items="${order.lp}" var="o">
			<div class="row cart">
				<div class="col l-2">
					<img
						src="${o.product.src}"
						alt="" width="70%">
				</div>
				<div class="col l-4">
					<p class="cart__body-name">${o.product.name}</p>
				</div>
				<div class="col l-2">
					<p class="cart__body-qty">Qty: ${o.amountProduct}</p>
				</div>
				<div class="col l-4">
					<p class="cart__body-price">Price: ${o.price}$</p>
				</div>
			</div>
		
		</c:forEach>
		<div class="row cart__body-total">
            <a href="DeleteCart" class="cart__remove">Remove All</a>
			<div class="cart__total">Total: ${total}$</div>
		</div>

			<div class="row">
				<form action="PayController" method="post" class="cart__body-form">
					<label for="name">Customer Name:</label> 
					<input type="text" name="name" id="name" placeholder="Customer Name"> 
					<label for="address">Customer Address: </label> 
					<input type="text" name="address" id="address" placeholder="Customer Address"> 
					<label for="code">Discount code (if any): </label> 
					<input type="text" name="code" id="code" placeholder="Discount code (if any)"> 
					<label for="phone">Customer phone: </label> 
					<input type="text" name="phone" id="phone" placeholder="Your phone"> 
					<input type="submit" class="cart__body-form-btn" value="SUBMIT">
				</form>

			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>