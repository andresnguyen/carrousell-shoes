<%@ page import="java.util.HashMap" %>
<%@ page import="thuongnguyen.it78.models.OrderDetail" %>
<%@ page import="thuongnguyen.it78.configs.LibraryMethod" %>
<%@ page import="thuongnguyen.it78.models.Order" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="keywords" content="thuongnguyen.it78 17130239 17130299 17130247">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="thuongnguyen.it78 17130239 17130299 17130247">

    <title>Chi Tiết Đơn Hàng</title>

    <%@include file="partials/css-link.jsp" %>
    <style>
        .form-control {
            width: 100%;
        }
    </style>

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
                            <a href="/index.html">Home</a>
                            <a href="/shop.html">Shop</a>
                            <span>Shopping Cart</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Shopping Cart Section Begin -->
    <section class="shopping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-7">
                    <div class="shopping__cart__table">
                        <table>
                            <thead>
                            <tr>
                                <th>SẢN PHẨM</th>
                                <th>SỐ LƯỢNG</th>
                                <th>THÀNH TIỀN</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                HashMap<Integer, Order> listOrder = (HashMap<Integer, Order>) request.getAttribute("order-me");
                                int orderID = (int) request.getAttribute("order-id");
                                double total = 0;


                                Order order = listOrder.get(orderID);

                                ArrayList<OrderDetail> orderDetails = order.getListOrderDetail();

                                for(OrderDetail orderDetail : orderDetails) {

                                    total += orderDetail.getQuantity() * orderDetail.getShoes().getPrice();



                            %>
                            <tr>
                                <td class="product__cart__item">
                                    <div class="product__cart__item__pic">
                                        <img src="/resources/img<%=orderDetail.getShoes().getImage().split(",")[0]%>" alt="">
                                    </div>
                                    <div class="product__cart__item__text">
                                        <h6><%=LibraryMethod.capFirstLetter(LibraryMethod.getNameShoes(orderDetail.getShoes().getName()))%></h6>
                                        <p><%=LibraryMethod.capFirstLetter(orderDetail.getShoes().getColor())%> - <%=orderDetail.getShoes().getSize()%></p>
                                        <h5><%=LibraryMethod.priceToString(orderDetail.getShoes().getPrice())%></h5>
                                    </div>
                                </td>
                                <td class="quantity__item">
                                    <div class="quantity">
                                        <div class="pro-qty-2">
                                            <input type="text" value="<%=orderDetail.getQuantity()%>">
                                        </div>
                                    </div>
                                </td>
                                <td class="cart__price"><%=LibraryMethod.priceToString(orderDetail.getShoes().getPrice() * orderDetail.getQuantity())%></td>
                            </tr>
                            <%
                                }
                            %>

                            <tr>
                                <td class="product__cart__item">
                                    <div class="product__cart__item__pic">
                                    </div>
                                    <div class="product__cart__item__text">

                                    </div>
                                </td>
                                <td class="quantity__item">
                                    <div class="quantity">

                                    </div>
                                </td>
                                <td class="cart__price"><%=LibraryMethod.priceToString(total)%></td>
                            </tr>



                            </tbody>
                        </table>
                    </div>

                </div>
                <div class="col-lg-5">

                    <div class="cart__total">
                        <h6>THÔNG TIN ĐƠN HÀNG</h6>
                        <ul>

                            <li>Mã đơn hàng: <%=orderID%></li>
                            <li>Người đặt hàng: <%=order.getAccount().getFullName()%></li>
                            <li style="border-bottom: none">Số điện thoại: <%=order.getAccount().getNumber()%></li>
                            <li style="font-weight: 400 ; padding: 0">Địa chỉ: <%=order.getAccount().getAddress()%></li>
                            <li>Email: <%=order.getAccount().getEmail()%></li>
                            <li>Ghi chú: <%=order.getOrderNote()%></li>
                        </ul>

                        <form action="/admin/order" method="post" id = "form-status">
                            <div class = form-group>
                                <label for="exampleFormControlSelect1" style="width: 100%">Cập nhật trạng thái: </label>
                                <input value = "<%=orderID%>" name ="orderID" hidden>
                                <select class="form-control" id="exampleFormControlSelect1" name = "status">
                                    <option value = "1">Đang vận chuyển</option>
                                    <option value = "2" >Đã hoàn tất</option>
                                    <option value = "-1" >Từ chối</option>

                                </select>
                            </div>

                        </form>
                        <a href="/me/checkout" class="primary-btn" style="margin-top: 50px" id ="btn-update-status">CẬP NHẬT</a>

                    </div>


                </div>

            </div>
        </div>
    </section>
    <!-- Shopping Cart Section End -->

<!-- MAIN SECTION END -->

    <%@include file="partials/footer.jsp" %>

    <!-- Search Begin -->
    <%@include file="partials/search.jsp" %>
    <!-- Search End -->

    <!-- Js Plugins -->
    <%@include file="partials/js-link.jsp" %>
    <script src="/resources/js/shopping-cart.js"></script>

<script>
    window.addEventListener('DOMContentLoaded', (e) => {
        const elementsCountInput = document.querySelectorAll('.qtybtn')
        for(element of elementsCountInput) {
            element.remove()
        }
    });
</script>

<script>
    const btnUpdateStatus = document.getElementById('btn-update-status')
    const btnFormStatus = document.getElementById('form-status')

    console.log(btnUpdateStatus, btnFormStatus)

    btnUpdateStatus.addEventListener('click', () => {
        btnFormStatus.submit()
    })

</script>



</body>

</html>