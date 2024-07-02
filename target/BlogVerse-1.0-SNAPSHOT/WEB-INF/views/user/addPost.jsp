<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../commons/common_cdns.jsp" %>
        <script src="${pageContext.request.contextPath}/static/js/addPost.js"></script>
    </head>
    <body>
        <%@include file="userNav.jsp" %>

        <div class="mt-2 container">
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="card box-effect">
                        <div class="card-header bg-warning text-light text-center fs-5">
                            &nbsp;&nbsp;<i class="fa-solid fa-blog fa-3x"></i> 
                            <p class="fw-bold">Add Post</p>
                        </div>
                        <div class="card-body">

                            <form class="row g-3" action="../post/addPostForm" method="POST" id="addPostForm">

                                <c:if test="${not empty msg}">
                                    <input type="hidden" id="msg" value="${msg}">
                                    <c:remove var="msg"/>
                                </c:if>

                                <div>
                                    <select class="form-control" name="category.categoryId">
                                        <option disabled selected> --- Select Category ---</option>
                                        <c:forEach var="category" items="${categories}">
                                            <option value="${category.categoryId}">${category.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <input type="hidden" name="user.userId" value="${currentUser.userId}">
                                <div class="col-md-12">
                                    <label for="title" class="form-label fw-semibold">Title</label>
                                    <input type="text" class="form-control" id="title" name="title" required="required">
                                </div>
                                <div class="col-md-12">
                                    <label for="content" class="form-label fw-semibold">Content</label>
                                    <textarea id="content" name="content" class="form-control" style="height: 150px"></textarea>
                                </div>
                                <div class="col-12 text-center">
                                    <button type="submit" class="btn btn-warning text-white btn-lg fw-semibold " id="sign-btn"> Post </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="../commons/footer.jsp" %>
    </body>
</html>
