<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../commons/common_cdns.jsp" %>
        <!--<script src="${pageContext.request.contextPath}/static/js/viewPost.js"></script>-->
    </head>
    <body>
        <%@ include file="userNav.jsp" %>

        <div class="container mt-2">
            <div class="row">
                <div class="col-md-12">
                    <form action="../post/viewAllPosts" method="GET" class="d-flex my-4 align-items-center justify-content-center">
                        <div>
                            <h5 class="mx-2">Filter by Category</h5>
                        </div>
                        <div class="mx-2">
                            <select class="form-control" id="categoryId" name="categoryId">
                                <option value="0">--- All Categories ---</option>
                                <c:forEach var="category" items="${categories}">
                                    <option value="${category.categoryId}">${category.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="mx-2">
                            <button type="submit" class="btn btn-primary mt-2">Filter</button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="row">
                <c:forEach var="post" items="${posts}">
                    <div class="col-md-6">
                        <div class="card mb-3">
                            <div class="card-header bg-warning text-white">
                                <div class="d-flex justify-content-between">
                                    <h5 class="card-title">${post.title}</h5>
                                    <p class="card-text"><small class="text-muted">Category: ${post.category.name}</small></p>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="d-flex justify-content-between">
                                    <p class="card-text"><small class="text-muted">Posted by: ${post.user.firstName} ${post.user.lastName}</small></p>
                                    <p class="card-text"><small class="text-muted">Posted at: <fmt:formatDate value="${post.createdAt}" pattern="dd-MM-yyyy"/></small></p>
                                </div>
                            </div>
                            <div class="card-footer bg-warning text-white d-flex justify-content-around">
                                <a href="singlePost?postId=${post.postId}" class="btn btn-sm btn-outline-light">Learn More ...</a>
                                <a href="#" class="btn btn-sm btn-outline-light"><i class="fa-regular fa-thumbs-up"></i><span> 10</span></a>
                                <a href="#" class="btn btn-sm btn-outline-light"><i class="fa-regular fa-comments"></i><span> 10</span></a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

        <%@ include file="../commons/footer.jsp" %>
    </body>
</html>
