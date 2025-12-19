<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>

<div class="container">

    <div style="margin-top: 50px"
         class="mainbox col-md-4 col-md-offset-4">

        <div class="panel panel-info">

            <div class="panel-heading">
                <div class="panel-title">Register New User</div>
            </div>

            <div class="panel-body" style="padding-top:30px">

                <form action="${pageContext.request.contextPath}/register"
                      method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

                    <!-- Username -->
                    <div class="input-group" style="margin-bottom:25px">
                        <span class="input-group-addon">
                            <i class="glyphicon glyphicon-user"></i>
                        </span>
                        <input type="text" name="username"
                               class="form-control"
                               placeholder="Username" required>
                    </div>

                    <!-- Password -->
                    <div class="input-group" style="margin-bottom:25px">
                        <span class="input-group-addon">
                            <i class="glyphicon glyphicon-lock"></i>
                        </span>
                        <input type="password" name="password"
                               class="form-control"
                               placeholder="Password" required>
                    </div>

                    <!-- Confirm Password -->
                    <div class="input-group" style="margin-bottom:25px">
                        <span class="input-group-addon">
                            <i class="glyphicon glyphicon-lock"></i>
                        </span>
                        <input type="password" name="confirmPassword"
                               class="form-control"
                               placeholder="Confirm Password" required>
                    </div>

                    <!-- First Name -->
                    <div class="input-group" style="margin-bottom:25px">
                        <span class="input-group-addon">
                            <i class="glyphicon glyphicon-user"></i>
                        </span>
                        <input type="text" name="firstName"
                               class="form-control"
                               placeholder="First Name">
                    </div>

                    <!-- Last Name -->
                    <div class="input-group" style="margin-bottom:25px">
                        <span class="input-group-addon">
                            <i class="glyphicon glyphicon-user"></i>
                        </span>
                        <input type="text" name="lastName"
                               class="form-control"
                               placeholder="Last Name">
                    </div>

                    <!-- Email -->
                    <div class="input-group" style="margin-bottom:25px">
                        <span class="input-group-addon">
                            <i class="glyphicon glyphicon-envelope"></i>
                        </span>
                        <input type="email" name="email"
                               class="form-control"
                               placeholder="Email">
                    </div>

                    <!-- Button -->
                    <button type="submit"
                            class="btn btn-primary btn-block">
                        Register
                    </button>

                </form>

            </div>
        </div>
    </div>
</div>

</body>
</html>
