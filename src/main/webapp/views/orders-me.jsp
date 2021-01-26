<%@ page import="thuongnguyen.it78.models.Order" %>
<%@ page import="thuongnguyen.it78.models.Shoes" %>
<%@ page import="thuongnguyen.it78.daos.ShoesDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="keywords" content="thuongnguyen.it78 17130239 17130299 17130247">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="thuongnguyen.it78 17130239 17130299 17130247">

    <title>Đơn Hàng Của Tôi</title>

    <%@include file="partials/css-link.jsp" %>
    <!-- Custom fonts for this template -->
    <link href="/resources/admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/resources/admin/css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="/resources/admin/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

    <style>
        tr th {
            width: 220px;
        }

        tr td {
            text-align: center !important;
        }
    </style>

</head>

<body>
    <!-- Fixed -->
    <a href="#" class="scrollToTop"><i class="fa fa-arrow-up"></i></a>

    <%@include file="partials/header.jsp" %>



     <!-- Form Login Section Begin -->
     <section class="breadcrumb-option" style = "padding-bottom: 100px; padding-top : 40px">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Đơn hàng của tôi</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                    <tr>
                                        <th>Mã Đơn Hàng</th>
                                        <th>Ngày Đặt Hàng</th>
                                        <th>Tình Trạng</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>

                                    <tbody>

                                    <%
                                        HashMap<Integer, Order> listOrder = (HashMap<Integer, Order>) request.getAttribute("order-me");

                                        for (int i : listOrder.keySet()) {
                                            Order order = listOrder.get(i);

                                    %>
                                    <tr>
                                        <td><%=i%></td>
                                        <td><%=order.getOrderDate()%></td>
                                        <td
                                                <%
                                                    String result = "";
                                                    String text = "";
                                                    String[] className = {"bg-info", "bg-success", "bg-warning", "bg-danger"};

                                                    switch (order.getStatus()) {
                                                        case 0:
                                                            text = "Đang chờ duyệt";
                                                            result = className[0];
                                                            break;
                                                        case 1:
                                                            text = "Đang giao hàng";
                                                            result = className[1];
                                                            break;
                                                        case 2:
                                                            text = "Đã mua";
                                                            result = className[2];
                                                            break;
                                                        case -1:
                                                            text = "Bị từ chối";
                                                            result = className[3];
                                                            break;

                                                    }



                                                %> class = "<%=result%>"
                                        ><%=text%></td>
                                        <td>

                                            <button class="btn btn-warning btn-circle btn-sm btn-view-order" data-toggle="modal">
                                                <i class="fas fa-file-alt text-white"></i>
                                            </button>
                                            <%
                                                if(order.getStatus() == 0) {
                                            %>
                                            <button class="btn btn-danger btn-circle btn-sm" data-toggle="modal" data-target = "#delete-product">
                                                <i class="fas fa-trash"></i>
                                            </button>
                                            <%
                                                }
                                            %>
                                        </td>
                                    </tr>
                                    <%
                                        }
                                    %>
                                    </tbody>

                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Form Login Sectionn End -->

    <%@include file="partials/footer.jsp" %>
    <!-- Search Begin -->
    <%@include file="partials/search.jsp" %>
    <!-- Search End -->

    <!-- Js Plugins -->
    <%@include file="partials/js-link.jsp" %>
    <!-- Bootstrap core JavaScript-->
    <script src="/resources/admin/vendor/jquery/jquery.min.js"></script>
    <script src="/resources/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/resources/admin/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/resources/admin/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="/resources/admin/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="/resources/admin/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="/resources/admin/js/demo/datatables-demo.js"></script>

<script>
    const buttons = [...document.getElementsByClassName('btn-view-order')]
    for(let button of buttons) {
        button.addEventListener('click', (e) => {
            let parentOfElement = e.target.parentElement.parentElement
            if(e.target.tagName === 'I')
                parentOfElement = e.target.parentElement.parentElement.parentElement

                const orderID = parentOfElement.querySelector("td").innerText.trim()

                window.location = "/me/order-detail/" + orderID
        } )
    }
</script>

</body>

</html>