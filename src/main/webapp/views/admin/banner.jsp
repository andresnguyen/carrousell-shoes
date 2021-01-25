<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Quản lý Banner</title>

    <!-- Custom fonts for this template -->
    <link href="/resources/admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/resources/admin/css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="/resources/admin/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                <div class="sidebar-brand-icon rotate-n-15">
                </div>
                <div class="sidebar-brand-text mx-3">Carroushoes</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="index.html">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Tổng Quan</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">


            <!-- Heading -->
            <div class="sidebar-heading">
                Quản lý
            </div>

            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="users.html">
                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                    <span>Tài Khoản</span></a>
            </li>

            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="products.html">
                    <i class="fas fa-calendar fa-fw mr-2 text-gray-400"></i>
                    <span>Sản phẩm</span></a>
            </li>


            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="orders.html">
                    <i class="fas fa-fw fa-clipboard-list mr-2 text-gray-400"></i>
                    
                    <span>Đơn hàng</span></a>
            </li>

            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="banners.html">
                    <i class="fas fa-fw fa-table  mr-2 text-gray-400"></i>
                    <span>Banner</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Search -->
                    <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group">
                            <input type="text" class="form-control bg-light border-0 small" placeholder="Tìm kiếm..."
                                aria-label="Search" aria-describedby="basic-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="button">
                                    <i class="fas fa-search fa-sm"></i>
                                </button>
                            </div>
                        </div>
                    </form>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto w-100 navbar-search">
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-0 small"
                                            placeholder="Search for..." aria-label="Search"
                                            aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button">
                                                <i class="fas fa-search fa-sm"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </li>

                        <!-- Nav Item - Alerts -->
                        <li class="nav-item dropdown no-arrow mx-1">
                            <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-bell fa-fw"></i>
                                <!-- Counter - Alerts -->
                                <span class="badge badge-danger badge-counter">3+</span>
                            </a>
                            <!-- Dropdown - Alerts -->
                            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="alertsDropdown">
                                <h6 class="dropdown-header">
                                    Alerts Center
                                </h6>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-primary">
                                            <i class="fas fa-file-alt text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 12, 2019</div>
                                        <span class="font-weight-bold">A new monthly report is ready to download!</span>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-success">
                                            <i class="fas fa-donate text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 7, 2019</div>
                                        $290.29 has been deposited into your account!
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-warning">
                                            <i class="fas fa-exclamation-triangle text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 2, 2019</div>
                                        Spending Alert: We've noticed unusually high spending for your account.
                                    </div>
                                </a>
                                <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
                            </div>
                        </li>

                        <!-- Nav Item - Messages -->
                        <li class="nav-item dropdown no-arrow mx-1">
                            <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-envelope fa-fw"></i>
                                <!-- Counter - Messages -->
                                <span class="badge badge-danger badge-counter">7</span>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="messagesDropdown">
                                <h6 class="dropdown-header">
                                    Message Center
                                </h6>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="/resources/admin/img/undraw_profile_1.svg"
                                            alt="">
                                        <div class="status-indicator bg-success"></div>
                                    </div>
                                    <div class="font-weight-bold">
                                        <div class="text-truncate">Hi there! I am wondering if you can help me with a
                                            problem I've been having.</div>
                                        <div class="small text-gray-500">Emily Fowler · 58m</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="/resources/admin/img/undraw_profile_2.svg"
                                            alt="">
                                        <div class="status-indicator"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">I have the photos that you ordered last month, how
                                            would you like them sent to you?</div>
                                        <div class="small text-gray-500">Jae Chun · 1d</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="/resources/admin/img/undraw_profile_3.svg"
                                            alt="">
                                        <div class="status-indicator bg-warning"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">Last month's report looks great, I am very happy with
                                            the progress so far, keep up the good work!</div>
                                        <div class="small text-gray-500">Morgan Alvarez · 2d</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="https://source.unsplash.com/Mv9hjnEUHR4/60x60"
                                            alt="">
                                        <div class="status-indicator bg-success"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">Am I a good boy? The reason I ask is because someone
                                            told me that people say this to all dogs, even if they aren't good...</div>
                                        <div class="small text-gray-500">Chicken the Dog · 2w</div>
                                    </div>
                                </a>
                                <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
                            </div>
                        </li>

                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Thường Nguyễn</span>
                                <img class="img-profile rounded-circle"
                                    src="/resources/admin/img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Tài khoản của tôi
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Đổi mật khẩu
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Quản lý tài khoản
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Đăng xuất
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">


                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary" style="display: flex; justify-content: space-between;">
                                <span>Quản lý banner</span>
                                <a href="#" class="btn btn-success btn-sm btn-icon-split">
                                    <!-- Add  -->
                                    <span class="text" style="margin-right: auto" data-toggle="modal" data-target="#add-product">Thêm Banner</span>
                                </a>

                            </h6>
                        </div>



                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th class = "id">ID</th>
                                            <th class = "name-product">Tên</th>
                                            <th class = "avatar">Hình ảnh</th>
                                            <th class = "active">Active</th>
                                            <th class = "action">Action</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th class = "id">ID</th>
                                            <th class = "name-product">Tên</th>
                                            <th class = "img-product">Hình ảnh</th>
                                            <th class = "active">Active</th>
                                            <th class = "action">Action</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <tr>
                                            <td class = "id-td">1</td>
                                            <td class = "name-td">Baner 1</td>
                                            <td><img src="https://i.pinimg.com/736x/63/5a/59/635a5978ec17517a9fc24532ae5a7847.jpg" alt="Avatar"></td>
                                            <td class = "active-td">
                                                <span class="badge bg-danger">Ẩn</span>
                                            </td>
                                            <td class = "action-td">
                                                <input type="text" value = "Description"class = "description-input" hidden>
                                                <input type="text" value = "2" class = "category-input" hidden>
                                                <input type="text" value = "BLACK" class = "color-input" hidden>
                                                <input type="text" value = "1" class = "image-input" hidden>
                                                <button class="btn btn-warning btn-circle btn-sm" data-toggle="modal" data-target = "#edit-product">
                                                    <i class="fas fa-file-alt text-white"></i>
                                                </button>
                                                <button class="btn btn-danger btn-circle btn-sm" data-toggle="modal" data-target = "#delete-product">
                                                    <i class="fas fa-trash"></i>
                                                </button>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td class = "id-td">2</td>
                                            <td class = "name-td">Baner 2</td>
                                            <td><img src="https://i.pinimg.com/736x/63/5a/59/635a5978ec17517a9fc24532ae5a7847.jpg" alt="Avatar"></td>
                                            <td class = "active-td">
                                                <span class="badge bg-success">Hiện</span>
                                            </td>
                                            <td class = "action-td">
                                                <input type="text" value = "Description"class = "description-input" hidden>
                                                <input type="text" value = "2" class = "category-input" hidden>
                                                <input type="text" value = "BLACK" class = "color-input" hidden>
                                                <input type="text" value = "1" class = "image-input" hidden>
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
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Add Product Modal  -->
    <div class="modal fade" id="add-product" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-size">
            <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Thêm Banner</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form class="user" action="/admin/product?type=add" method="POST" enctype="multipart/form-data">
                    <div class="form-group row">
                        <div class="col-sm-12">
                            <label for="name-form">Tên sản phẩm</label>
                            <input type="text" class="form-control form-control-user" id="name-form" name = "name">
                        </div>
                    </div>

                    <div class="form-group img">
                        <label for="file-form1">Hình ảnh banner</label>
                        <input type="file" class="form-control-file" id="file-form1" accept="image/jpeg, image/png, image/gif" name = "image1">
                    </div>
                    
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                <button type="button" class="btn btn-primary" id="btn-add-product">Thêm</button>
            </div>
            </div>
        </div>
    </div>

    <!-- Update Product Modal  -->
    <div class="modal fade" id="edit-product" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-size">
            <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Cập nhật banner</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form class="user" action="/admin/product?type=edit" method="POST" enctype="multipart/form-data">
                    <input type="text" name = "id" hidden/>
                    <div class="form-group row">
                        <div class="col-sm-12">
                            <label for="name-form1">Tên banner</label>
                            <input type="text" class="form-control form-control-user" id="name-form1" name ="name">
                        </div>
                        
                    </div>

                    <div class="form-group img">
                        <label for="file-form11">Hình ảnh banner</label>
                        <input type="file" class="form-control-file" id="file-form11" accept="image/jpeg, image/png, image/gif" name = "image1"/>
                    </div>

                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                        <label class="form-check-label" for="flexCheckDefault">
                          Ẩn banner
                        </label>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                <button type="button" class="btn btn-primary" id = "btn-edit-product">Cập nhật</button>
            </div>
            </div>
        </div>
    </div>

    <!-- Modal Delete Product -->
    <div class="modal fade" id="delete-product" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Xóa...</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            </div>
            <div class="modal-body">
                <span>
                    Bạn có chắc chắn xóa <b></b>
                </span>
                <form action="/admin/product?type=delete" method = "POST" hidden>
                    <input type="text" name = "id">
                </form>
            </div>
            <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
            <button type="button" class="btn btn-primary" id = "btn-delete-product">Xóa</button>
            </div>
        </div>
        </div>
    </div>

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

        // delete product modal control
        $('#delete-product').on('show.bs.modal', function (event) {
            // get row
            const row = $(event.relatedTarget)[0].parentElement.parentElement
            
            // get value from row
            const id = row.querySelector('.id-td').innerText.trim()
            const shoesName = row.querySelector('.name-td').innerText.trim()

            // log value test
            console.log(id, shoesName, size)




            // get form delete
            const modal = $(this)[0]
            const form = modal.querySelector('form')

            // // edit text

            modal.querySelector(".modal-body b").innerText = `${shoesName}, SIZE ${size}?`

            // asign id value to input
            form.querySelector("input").value = id

            // get button [Delete] of modal
            const button = modal.querySelector('#btn-delete-product');
            console.log(button);

            // add event when button click so will submit form delete
            button.addEventListener('click', (e) => {
                //form.submit()
                console.log("form submited");
            })

        })

        // edit product modal control
        $('#edit-product').on('show.bs.modal', function (event) {

            // get row present
            const row = $(event.relatedTarget)[0].parentElement.parentElement

            // get modal
            const modal = $(this)[0]

            console.log(row, modal);

            // get value form row present to asign form edit account

            const id = row.querySelector('.id-td').innerText.trim()
            const name = row.querySelector('.name-td').innerText.trim()
            const image = row.querySelector('.image-input').value.trim()




        // should be call api but I using DOM
        // get element to asign value
        const idInput =  modal.querySelector('input[name="id"]')
        const nameInput = modal.querySelector('input[name="name"]')

        // asign value
            
        idInput.value = id
        nameInput.value = name
       

        


        // get button
        const button = modal.querySelector('#btn-edit-product');
        const form = modal.querySelector('form')


        // add event listener
        button.addEventListener('click', (e) => {

            idValue = idInput.value
            nameValue = nameInput.value
        
            // validate value
            if(idValue.length == 0 || nameValue.length == 0) {
                return alert("Có lỗi! Vui lòng kiểm tra lại")
            }

            // if okie. submit form
            form.submit()

        })
    
    })

    
        // edit product modal control
        $('#add-product').on('show.bs.modal', function (event) {

            // get row present
            const row = $(event.relatedTarget)[0].parentElement.parentElement

            // get modal
            const modal = $(this)[0]

            // should be call api but I using DOM
            // get element to asign value
            const nameInput = modal.querySelector('input[name="name"]')
            
            const arrFile = modal.querySelectorAll('input[type="file"]')

            function addEvent(...arr) {
                for(let element of arr) {
                    element.addEventListener('change', (e) => {
                        if(e.target.value < 1) {
                            e.target.value = 1
                        }
                    })
                }
            }

            function checkEventFile(arr) {
                const elements = [...arr]
                for(let element of elements) {
                    if(element.files.length !== 1) return false
                }
                return true;
            }

            // get button
            const button = modal.querySelector('#btn-add-product');
            const form = modal.querySelector('form')


            // add event listener
            button.addEventListener('click', (e) => {

            nameValue = nameInput.value
          

            if(!checkEventFile(arrFile)) return alert("Vui lòng chọn file cho chính xác!")

            // validate value
            if(nameValue.length == 0 ) {
                return alert("Có lỗi! Vui lòng kiểm tra lại")
            }

            // if okie. submit form
            form.submit()

        })

    })


    </script>

<script>

var ALERT_TITLE = "Oops!";
var ALERT_BUTTON_TEXT = "Ok";

if(document.getElementById) {
	window.alert = function(txt) {
		createCustomAlert(txt);
	}
}

function createCustomAlert(txt) {
	d = document;

	if(d.getElementById("modalContainer")) return;

	mObj = d.getElementsByTagName("body")[0].appendChild(d.createElement("div"));
	mObj.id = "modalContainer";
	mObj.style.height = d.documentElement.scrollHeight + "px";
	
	alertObj = mObj.appendChild(d.createElement("div"));
	alertObj.id = "alertBox";
	if(d.all && !window.opera) alertObj.style.top = document.documentElement.scrollTop + "px";
	alertObj.style.left = (d.documentElement.scrollWidth - alertObj.offsetWidth)/2 + "px";
	alertObj.style.visiblity="visible";

	h1 = alertObj.appendChild(d.createElement("h1"));
	h1.appendChild(d.createTextNode(ALERT_TITLE));

	msg = alertObj.appendChild(d.createElement("p"));
	//msg.appendChild(d.createTextNode(txt));
	msg.innerHTML = txt;

	btn = alertObj.appendChild(d.createElement("a"));
	btn.id = "closeBtn";
	btn.appendChild(d.createTextNode(ALERT_BUTTON_TEXT));
	btn.href = "#";
	btn.focus();
	btn.onclick = function() { removeCustomAlert();return false; }

	alertObj.style.display = "block";
	
}

function removeCustomAlert() {
	document.getElementsByTagName("body")[0].removeChild(document.getElementById("modalContainer"));
}

</script>

</body>

</html>