<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <script src="${pageContext.request.contextPath}/static/css/style.css"></script>
        <%@include file="../commons/common_cdns.jsp" %>
    </head>
    <body>
        <%@include file="userNav.jsp" %>

        <section class="hero-section text-center d-flex align-items-center justify-content-center">
            <div class="hero-content">
                <div class="text-white fs-2 fw-semibold">
                    <c:choose>
                        <c:when test="${currentTime >= 0 and currentTime < 12}">
                            <p>Good Morning, ${currentUser.firstName}!</p>
                        </c:when>
                        <c:when test="${currentTime >= 12 and currentTime < 18}">
                            <p>Good Afternoon, ${currentUser.firstName}!</p>
                        </c:when>
                        <c:otherwise>
                            <p>Good Evening, ${currentUser.firstName}!</p>
                        </c:otherwise>
                    </c:choose>
                </div>
                <h2 class="text-white">Welcome to Blog Verse</h2>
                <a href="../post/viewAllPosts" class="btn btn-outline-warning text-white">View Blogs</a>
            </div>
        </section>

        <%@include file="../commons/footer.jsp" %>
    </body>
</html>
