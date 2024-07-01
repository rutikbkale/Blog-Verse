<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="commons/common_cdns.jsp" %>
    </head>
    <body>
        <%@include file="commons/navbar.jsp" %>

        <section class="hero-section text-center d-flex justify-content-center">
            <div class="hero-content">
                <h1 class="text-white">Welcome to Blog Verse</h1>
                <p class="text-white">Your platform to share and explore amazing stories and ideas.</p>
                <a href="signup" class="btn btn-outline-warning text-white">Get Started</a>
            </div>
        </section>

        <%@include file="commons/footer.jsp" %>
    </body>
</html>
