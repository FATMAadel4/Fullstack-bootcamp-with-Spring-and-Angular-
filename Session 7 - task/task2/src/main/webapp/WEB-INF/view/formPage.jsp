<html>
    <head>

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

        <%--        import Bootstrap--%>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

    </head>
    <body class="container mt-5">
    <h2 class="mb-4">User Profile Form</h2>
    <form action="processForm" >
        <div class="mb-3">
            <label>First Name:</label>
            <input type="text" name="firstName" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Last Name:</label>
            <input type="text" name="lastName" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Email:</label>
            <input type="email" name="email" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Date of Birth:</label>
            <input type="date" name="dateOfBirth" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>City:</label>
            <input type="text" name="city" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>

        </form>
    </body>
</html>

