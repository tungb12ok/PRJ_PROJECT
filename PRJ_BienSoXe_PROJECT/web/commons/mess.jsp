<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Display success message with Bootstrap alert -->
        <c:if test="${messSuccess != null}">
            <div class="alert alert-success" role="alert">
                <p>${messSuccess}</p>
            </div>
        </c:if>

        <!-- Display error message with Bootstrap alert -->
        <c:if test="${messError != null}">
            <div class="alert alert-danger" role="alert">
                <p>${messError}</p>
            </div>
        </c:if>
    </body>
</html>
