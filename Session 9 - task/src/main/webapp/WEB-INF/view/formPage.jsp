<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <style>
        .error {
            color: red;
            font-size: 0.9em;
        }
    </style>
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card p-4 shadow-lg">
        <h2 class="text-center mb-3">Employee Registration Form</h2>

        <form:form action="processform" modelAttribute="employee" method="post">

            <div class="mb-3">
                <label>Username</label>
                <form:input path="username" class="form-control" placeholder="Enter Username"/>
                <form:errors path="username" cssClass="error"/>
            </div>

            <div class="mb-3">
                <label>Email</label>
                <form:input path="email" class="form-control" placeholder="Enter Email"/>
                <form:errors path="email" cssClass="error"/>
            </div>

            <div class="mb-3">
                <label>Password</label>
                <form:password path="password" class="form-control" placeholder="Enter Password"/>
                <form:errors path="password" cssClass="error"/>
            </div>

            <div class="mb-3">
                <label>Confirm Password</label>
                <form:password path="confirmPassword" class="form-control" placeholder="Confirm Password"/>
                <form:errors path="confirmPassword" cssClass="error"/>
                <form:errors path="confirmPassword" cssClass="error"/>
            </div>

            <button type="submit" class="btn btn-primary w-100">Submit</button>
        </form:form>
    </div>
</div>

</body>
</html>