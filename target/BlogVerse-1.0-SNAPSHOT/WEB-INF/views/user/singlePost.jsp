<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../commons/common_cdns.jsp" %>
    </head>
    <body>
        <%@include file="userNav.jsp" %>

        <div class="container">
            <div class="row mt-3">
                <div class="col-md-8 offset-md-2">
                    <div class="card mb-3">
                        <div class="card-header bg-warning text-white">
                            <div class="d-flex justify-content-between">
                                <h3 class="card-title">${post.title}</h3>
                                <p class="card-text"><small class="text-muted">Category: ${post.category.name}</small></p>
                            </div>
                        </div>
                        <div class="card-body">
                            <div class="my-2">
                                <h4>Content :</h4>
                                <p class="fs-5">${post.content}</p>
                            </div>
                            <div class="d-flex justify-content-between">
                                <p class="card-text"><small class="text-muted">Posted by: ${post.user.firstName} ${post.user.lastName}</small></p>
                                <p class="card-text"><small class="text-muted">Posted at: <fmt:formatDate value="${post.createdAt}" pattern="dd-MM-yyyy"/></small></p>
                            </div>
                        </div>
                        <div class="card-footer bg-warning text-white d-flex justify-content-around">
                            <a href="#" class="btn btn-sm btn-outline-light"><i class="fa-regular fa-thumbs-up"></i><span> 10</span></a>
                            <a href="#" class="btn btn-sm btn-outline-light"><i class="fa-regular fa-comments"></i><span> 10</span></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>        

        <%@include file="../commons/footer.jsp" %>
    </body>
</html>
