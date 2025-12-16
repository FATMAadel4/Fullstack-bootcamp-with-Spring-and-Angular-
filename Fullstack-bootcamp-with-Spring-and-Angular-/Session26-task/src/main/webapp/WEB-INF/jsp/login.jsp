<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div style="margin-top:50px" class="mainbox col-md-4 col-md-offset-4">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Sign In</div>
            </div>
            <div class="panel-body" style="padding-top:30px">
                <!-- Login Form -->
                <form action="${pageContext.request.contextPath}/authenticateUser" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

                    <!-- Error -->
                    <c:if test="${param.error != null}">
                        <div class="alert alert-danger">
                            Username or password is incorrect
                        </div>
                    </c:if>

                    <!-- Logout Message -->
                    <c:if test="${param.logout != null}">
                        <div class="alert alert-info">
                            You have been logged out.
                        </div>
                    </c:if>

                    <!-- Username -->
                    <div class="input-group" style="margin-bottom:25px">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input type="text" name="username" class="form-control" placeholder="Username" required>
                    </div>

                    <!-- Password -->
                    <div class="input-group" style="margin-bottom:25px">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input type="password" name="password" class="form-control" placeholder="Password" required>
                    </div>

                    <!-- Buttons -->

                </form>

                <hr>

                <!-- Register Link -->
                <a href="${pageContext.request.contextPath}/register" class="btn btn-primary btn-block">
                    Register New User
                </a>

            </div>
        </div>
    </div>
</div>
</body>
</html>
