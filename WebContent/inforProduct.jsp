<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./assets/css/grid.css">
<link rel="stylesheet" href="./assets/css/style.css">
<link rel="stylesheet" href="./assets/css/style_inforProduct.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="body">
		<div class="grid wide">
			<div class="row">
				<div class="col l-8">
					<div class="body__header">${product.name}</div>

					<div class="row">
						<div class="col l-6">
							<img
								src="${product.src}"
								alt="" width="100%" style="padding-top: 12px">
						</div>
						<div class="col l-6">
							<h3 class="body__price">${product.price}$</h3>
							<div class="body__infor">
								${product.description}
							</div>

							<a href="AddToCart?id=${product.id}" class="body__btn">ADD TO CART</a>
						</div>
					</div>
				</div>

				<div class="col l-4">
					<div class="body__card">
						<h5 style="border: 1px solid #ebebeb">
							Cart <i class="ti-shopping-cart"></i>
						</h5>
						<a href="cart.jsp" class="body__cart-payment">Buy now</a>
					</div>

					<div class="body__card">
					<h5>Top product popular</h5>
					<c:forEach items="${listTopProduct}" var="o">
						<div class="row margin-top-8px">
							<div class="col l-2 body__card-stt">${o.id}</div>
							<div class="col l-4">
								<img src="${o.src}" alt="" width="100%">
							</div>
							<a href="detail?pid=${o.id}" class="col l-6 body__card-infor">${o.name}</a>
						</div>
					</c:forEach>

				</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>