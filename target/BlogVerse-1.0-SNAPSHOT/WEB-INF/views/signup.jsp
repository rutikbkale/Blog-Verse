<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <%@include file="commons/common_cdns.jsp" %>
        <script src="${pageContext.request.contextPath}/static/js/signup.js"></script>
    </head>
    <body>
        <%@include file="commons/navbar.jsp" %>
        <div class="mt-2 container">
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="card box-effect">
                        <div class="card-header bg-warning text-light text-center fs-5">
                            &nbsp;&nbsp;<i class="fa-solid fa-user-plus fa-3x"></i> 
                            <p class="fw-bold">Sign Up</p>

                            <c:if test="${not empty msg}">
                                <input type="hidden" id="msg" value="${msg}">
                                <c:remove var="msg"/>
                            </c:if>
                        </div>
                        <div class="card-body">

                            <form class="row g-3" action="user/signupForm" method="POST" id="signupForm">
                                <div class="col-md-6">
                                    <label for="fName" class="form-label fw-semibold">First Name</label>
                                    <input type="text" class="form-control" id="firstName" name="firstName" required="required">
                                </div>
                                <div class="col-md-6">
                                    <label for="lName" class="form-label fw-semibold">Last Name</label>
                                    <input type="text" class="form-control" id="lastName" name="lastName" required="required">
                                </div>
                                <div class="col-12">
                                    <label for="inputEmail" class="form-label fw-semibold">Email</label>
                                    <input type="email" class="form-control" id="inputEmail" name="email" required="required">
                                </div>
                                <div class="col-md-6">
                                    <label for="mobno" class="form-label fw-semibold">Mobile No. </label>
                                    <input type="tel" class="form-control" id="mobNo" name="mobNo" required="required">
                                </div>
                                <div class="col-md-6">
                                    <label for="dob" class="form-label fw-semibold">Date of Birth</label>
                                    <input type="date" class="form-control" id="dob" name="dob" required="required">
                                </div>
                                <div class="col-md-6">
                                    <label for="password" class="form-label fw-semibold">Password</label>
                                    <input type="password" class="form-control" id="password" name="password" required="required">
                                </div>
                                <div class="col-md-6">
                                    <label for="checkpass" class="form-label fw-semibold">Re-Enter Password </label>
                                    <input type="password" class="form-control" id="checkpass" name="checkpass" required="required">
                                </div>
                                <div class="container text-center my-3" style="display: none" id="loader">
                                    <span class="fa fa-refresh fa-spin fa-3x" style="color: red"></span>
                                </div>
                                <div class="col-12 text-center">
                                    <button type="submit" class="btn btn-warning text-white btn-lg fw-semibold " id="sign-btn"> Register </button>
                                </div>
                            </form>
                            <div class="text-center mb-0" id="login-btn">
                                <div>
                                    <p class="fw-semibold">Already have an account ?</p>
                                    <a href="signin" class="text-warning text-decoration-none">Click here to Login</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="commons/footer.jsp" %>
    </body>
</html>
