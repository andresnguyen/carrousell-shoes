<%@ page import="thuongnguyen.it78.models.OrderDetail" %>
<%@ page import="thuongnguyen.it78.models.Shoes" %>
<%@ page import="thuongnguyen.it78.daos.ShoesDAO" %>
<%@ page import="thuongnguyen.it78.configs.LibraryMethod" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="keywords" content="thuongnguyen.it78 17130239 17130299 17130247">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="thuongnguyen.it78 17130239 17130299 17130247">

    <title>Thanh Toán</title>
    <style>
        .row .checkout__input input {
            margin-bottom: 5px;

        }

        .checkout-shoes-name {
            font-weight: 600 !important;
            font-size: 15px;
            margin-bottom: 2px;
        }

        .checkout-shoes-color {

        }

        .checkout-shoes-price {
            font-size: 14px;

        }

        .cart__total:last-child {
            margin-bottom: 0px;
        }
    </style>

    <%@include file="partials/css-link.jsp" %>

</head>

<body>

    <!-- Fixed -->
    <a href="#" class="scrollToTop"><i class="fa fa-arrow-up"></i></a>


    <%@include file="partials/header.jsp" %>



    <!-- MAIN SECTION BEGIN -->

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__text">
                        <div class="breadcrumb__links">
                            <a href="/">Home</a>
                            <a href="/product-list">Shop</a>
                            <span>Check Out</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->


    <%
        HashMap<Integer, OrderDetail> mapShoes = (HashMap) request.getSession().getAttribute("cart");

        if(accountLegal == null) {
            response.sendRedirect("/account/login");
            return;
        }

        if(mapShoes == null || mapShoes.isEmpty()) {
        response.sendRedirect("/");
        return;
    }%>

    <!-- Checkout Section Begin -->
    <section class="checkout spad">
        <div class="container">
            <div class="checkout__form">
                <form action="/me/checkout" method="post" id = "form-checkout">
                    <div class="row">
                        <div class="col-lg-7 col-md-6">
                            <div class="row">

                                <div class="col-lg-12">
                                    <div class="checkout__input">
                                        <p>Tên đầy đủ<span>*</span></p>
                                        <input type="text" value = <%=accountLegal.getFullName()%>>
                                    </div>
                                </div>
                            </div>
                            <div class="checkout__input">
                                <p>Địa chỉ<span>*</span></p>
                                <input type="text" class="checkout__input__add" value ="<%=accountLegal.getAddress()%>">
                            </div>

                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Số điện thoại<span>*</span></p>
                                        <input type="text" value = "<%=accountLegal.getNumber()%>">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Email<span>*</span></p>
                                        <input type="text" value = "<%=accountLegal.getEmail()%>">
                                    </div>
                                </div>
                            </div>
                            <div class="checkout__input">
                                <p>Bạn có cần lưu ý gì không? Note tại đây nha<span>*</span></p>
                                <textarea  id="" style="width: 100%;" rows="3" name = "note"></textarea>
                            </div>
                        </div>


                        <div class="col-lg-5 col-md-6">
                            <div class="cart__total">
                                <h6 style="margin-bottom: 32px">ĐƠN HÀNG</h6>
                                <%

                                    double total = 0;
                                    for (int i : mapShoes.keySet()) {
                                        int quantity = mapShoes.get(i).getQuantity();
                                        Shoes shoesDetail = ShoesDAO.getShoesByShoesDetailId(i);
                                        total += quantity * shoesDetail.getPrice();
                                %>
                                <ul class="product__cart__item__text row">
                                    <div class = "col-lg-7">
                                        <h5 class = "checkout-shoes-name"><%=LibraryMethod.capFirstLetter(LibraryMethod.getNameShoes(shoesDetail.getName()))%></h5>
                                        <p class = "checkout-shoes-color"><%=LibraryMethod.capFirstLetter(shoesDetail.getColor())%> - <%=shoesDetail.getSize()%></p>
                                    </div>

                                    <p class = "col-lg-1 text-start fs-6">x<%=quantity%></p>

                                    <h5 class = "checkout-shoes-price col-lg-4"><%=LibraryMethod.priceToString(shoesDetail.getPrice())%></h5>
                                </ul>
                                <%
                                    }
                                %>

<%--                                <ul class="product__cart__item__text row">--%>
<%--                                    <div class = "col-lg-7">--%>
<%--                                        <h5 class = "checkout-shoes-name">Basas Black Lace Low Top</h5>--%>
<%--                                        <p class = "checkout-shoes-color">Dark Grey - 39</p>--%>
<%--                                    </div>--%>

<%--                                    <p class = "col-lg-1 text-start fs-6">x1</p>--%>

<%--                                    <h5 class = "checkout-shoes-price col-lg-4">450.000 VND</h5>--%>
<%--                                </ul>--%>

<%--                                <ul class="product__cart__item__text row">--%>
<%--                                    <div class = "col-lg-7">--%>
<%--                                        <h5 class = "checkout-shoes-name">Basas Black Lace Low Top</h5>--%>
<%--                                        <p class = "checkout-shoes-color">Dark Grey - 39</p>--%>
<%--                                    </div>--%>

<%--                                    <p class = "col-lg-1 text-start fs-6">x1</p>--%>

<%--                                    <h5 class = "checkout-shoes-price col-lg-4">450.000 VND</h5>--%>
<%--                                </ul>--%>

<%--                                <ul class="product__cart__item__text row">--%>
<%--                                    <div class = "col-lg-7">--%>
<%--                                        <h5 class = "checkout-shoes-name">Basas Black Lace Low Top</h5>--%>
<%--                                        <p class = "checkout-shoes-color">Dark Grey - 39</p>--%>
<%--                                    </div>--%>

<%--                                    <p class = "col-lg-1 text-start fs-6 border-bottom">x1</p>--%>

<%--                                    <h5 class = "checkout-shoes-price col-lg-4">450.000 VND</h5>--%>
<%--                                </ul>--%>

                                <ul style="border-top: 2px dashed #888; padding-top: 13px;">

                                    <li>TỔNG CỘNG<span><%=LibraryMethod.priceToString(total)%></span></li>


                                </ul>
                                <a href="#" class="primary-btn" id = "btn-submit-checkout">HOÀN TẤT ĐẶT HÀNG</a>
                            </div>
                        </div>

                    </div>
                </form>
            </div>
        </div>
    </section>
    <!-- Checkout Section End -->

<!-- MAIN SECTION END -->

    <%@include file="partials/footer.jsp" %>

    <!-- Search Begin -->
    <%@include file="partials/search.jsp" %>
    <!-- Search End -->

    <!-- Js Plugins -->
    <%@include file="partials/js-link.jsp" %>

<script>
    const formCheckout = document.getElementById('form-checkout')
    const btnSubmitCheckout = document.getElementById('btn-submit-checkout')

    console.log(formCheckout, btnSubmitCheckout)

    btnSubmitCheckout.addEventListener('click', (e) => {
        e.preventDefault()
        formCheckout.submit()
    })
</script>

</body>

</html>