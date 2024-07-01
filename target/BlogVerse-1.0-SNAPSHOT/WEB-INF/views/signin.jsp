<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <%@include file="commons/common_cdns.jsp" %>
        <script src="${pageContext.request.contextPath}/static/js/signin.js"></script>
    </head>
    <body>
        <%@include file="commons/navbar.jsp" %>
        <div class="mt-2 container">
            <div class="row">
                <div class="col-md-4 offset-md-4">
                    <div class="card box-effect">
                        <div class="card-header bg-warning text-light text-center fs-5">
                            &nbsp;&nbsp;<i class="fas fa-user-shield fa-3x"></i> 
                            <p class="fw-bold">Sign In</p>
                        </div>
                        <div class="card-body">

                            <form class="row g-3" action="user/signinForm" method="post" id="signinForm">
                                <div class="col-md-12">

                                    <c:if test="${not empty msg}">
                                        <input type="hidden" id="msg" value="${msg}">
                                        <c:remove var="msg"/>
                                    </c:if>

                                    <label for="mobno" class="form-label fw-semibold">Mobile No. </label>
                                    <input type="tel" class="form-control" id="mobno" name="mobNo">
                                </div>
                                <div class="col-md-12">
                                    <label for="password" class="form-label fw-semibold">Password</label>
                                    <input type="password" class="form-control" id="password" name="password">
                                </div>
                                <div class="col-12 text-center">
                                    <button type="submit" class="btn btn-warning text-white btn-lg fw-semibold " id="signin-btn"> Login </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="commons/footer.jsp" %>
    </body>
</html>
