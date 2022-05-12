<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="body">
	<div class="grid wide">
		<div class="row">
			<div class="col l-8">
				<div class="row">
					<c:choose>
						<c:when test="${listEmpty == null}">
							<c:forEach items="${listP}" var="o">
								<div class="col l-4">
									<div class="body__item">
										<h5>
											<a href="detail?pid=${o.id}">${o.name}</a>
										</h5>
										<i>Up to 20% off</i>
										<div class="fakeimg">
											<img src="${o.src}" alt="" width="100%">
										</div>
										<h5 style="margin-top: 2px">${o.price}$</h5>
										<p>${o.description}</p>
										
										<a class="body__item-more" href="detail?pid=${o.id}">See more</a>
										
									</div>
								</div>
							</c:forEach>
						</c:when>
						
						<c:when test="${listEmpty != null}">
							<div class="body__no-items"><i>${listEmpty}</i></div>
						</c:when>
						
					</c:choose>

				</div>
			</div>

			<div class="col l-4">
				<div class="body__card">
					<h5>
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