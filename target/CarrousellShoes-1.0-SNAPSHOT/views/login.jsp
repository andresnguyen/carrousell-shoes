<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="keywords" content="thuongnguyen.it78 17130239 17130299 17130247">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="thuongnguyen.it78 17130239 17130299 17130247">

    <title>Đăng Nhập</title>

    <%@include file="partials/css-link.jsp" %>

</head>

<body>
<!-- Fixed -->
<a href="#" class="scrollToTop"><i class="fa fa-arrow-up"></i></a>

<%@include file="partials/header.jsp" %>

<h1 class = "contact-usa" style="background-color: #f4f4f4;">ĐĂNG NHẬP</h1>


<!-- Form Login Section Begin -->
<section class="breadcrumb-option" style = "padding-bottom: 100px;">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <form class="login-form" action="/account/login" id = "form-login" method="post">
                    <%
                        if(request.getAttribute("error") != null) {
                    %>

                    <!-- ERROR BEGIN  -->
                    <div class="alert alert-danger" role="alert">
                        <i class="fas fa-exclamation-circle" style="color:#d93025; padding-right: 5px;"></i>
                        <span style="color:#d93025;"><%= (String) request.getAttribute("error")%></span>
                    </div>
                    <!-- ERROR END  -->

                    <%
                        }
                    %>

                    <div class="form-group">
                        <input type="email" name="email" class = "form-control" autofocus id="email" placeholder="Email"
                        <%
                            if(request.getAttribute("email") != null) {
                        %>
                        value = "<%= request.getAttribute("email")%>"
                        <%
                            }
                        %>
                        />
                        <span class="form-message"></span>
                    </div>
                    <div class="input-icon form-group">
                        <input type="password" name="password" class = "form-control" id="password" placeholder="Mật khẩu"/>
                        <span class="form-message"></span>
                        <i class="far fa-eye show-password"></i>
                    </div>
                    <a href="/account/forgot" class="forgot">Quên mật khẩu?</a>
                    <button type = "submit" class ="signup-button">ĐĂNG NHẬP</button>
                    <hr>
                    <div class="social-share">

<%--                        <div class="social-share-item instagram">--%>
<%--                            <i class="fab fa-google-plus-g social-share-icon"></i>--%>
<%--                            <span class="social-share-text">Đăng nhập bằng Google</span>--%>
<%--                        </div>--%>
                        <%--                            <span id="status" class="status"></span>--%>
                        <div class="social-share-item facebook" style="padding: 18px;">

                            <fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
                                <span class="social-share-text">Đăng nhập bằng Facebook</span>
                            </fb:login-button>
                            <%--                                <a href="https://www.facebook.com/dialog/oauth?client_id=2701399640096635&redirect_uri=https://localhost:8090/login-facebook">--%>
                            <%--                                <i class="fab fa-facebook social-share-icon"></i>--%>
                            <%--                                <span class="social-share-text">Đăng nhập bằng Facebook</span>--%>
                            <%--                                </a>--%>
                        </div>

                    </div>
                </form>
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

<script>
    document.addEventListener('DOMContentLoaded', function () {
        // Mong muốn của chúng ta
        Validator({
            form: '#form-login',
            formGroupSelector: '.form-group',
            errorSelector: '.form-message',
            rules: [
                Validator.isRequired('#email', 'Vui lòng nhập trường này'),
                Validator.isRequired('#password', 'Vui lòng nhập trường này'),

                Validator.isEmail('#email'),
                Validator.minLength('#password', 6),
                // Validator.isRequired('#password_confirmation'),
                // Validator.isConfirmed('#password_confirmation', function () {
                //   return document.querySelector('#form-1 #password').value;
                // }, 'Mật khẩu nhập lại không chính xác')
            ],
            //   onSubmit: function (data) {
            //     // Call API
            //     console.log(data);
            //   }
        });
    })

    function statusChangeCallback(response) {  // Called with the results from FB.getLoginStatus().
        console.log('statusChangeCallback');
        console.log(response);                   // The current login status of the person.
        if (response.status === 'connected') {   // Logged into your webpage and Facebook.
            testAPI();
        } else {                                 // Not logged into your webpage or we are unable to tell.
            document.getElementById('status').innerHTML = 'Please log ' +
                'into this webpage.';
        }
    }

    function checkLoginState() {               // Called when a person is finished with the Login Button.
        FB.getLoginStatus(function(response) {   // See the onlogin handler
            statusChangeCallback(response);
        });
    }


    window.fbAsyncInit = function() {
        FB.init({
            appId      : '1881374855352430',
            cookie     : true,                     // Enable cookies to allow the server to access the session.
            xfbml      : true,                     // Parse social plugins on this webpage.
            version    : 'v9.0'           // Use this Graph API version for this call.
        });


        FB.getLoginStatus(function(response) {   // Called after the JS SDK has been initialized.
            statusChangeCallback(response);        // Returns the login status.
        });
    };

    function testAPI() {                      // Testing Graph API after login.  See statusChangeCallback() for when this call is made.
        console.log('Welcome!  Fetching your information.... ');
        FB.api('/me', function(response) {
            console.log('Successful login for: ' + response.name);
            // document.getElementById('status').innerHTML =
            //     'Thanks for logging in, ' + response.name + '!';
            window.location.href='/login-facebook?email='+response.email+'&name='+response.name+'&id='+response.id;
        });
    }
</script>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js">

</script>
</body>

</html>