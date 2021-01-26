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
            width: 193px;
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
                                        <th>Tổng Tiền</th>
                                        <th>Tình Trạng</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>2011/04/25</td>
                                        <td>100.000 VND</td>
                                        <td>1</td>
                                        <td>
                                            <button class="btn btn-warning btn-circle btn-sm" data-toggle="modal" data-target = "#edit-product">
                                                <i class="fas fa-file-alt text-white"></i>
                                            </button>

                                            <button class="btn btn-danger btn-circle btn-sm" data-toggle="modal" data-target = "#delete-product">
                                                <i class="fas fa-trash"></i>
                                            </button>
                                        </td>
                                    </tr>
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

</body>

</html>