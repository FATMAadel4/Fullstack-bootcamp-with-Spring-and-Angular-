<html>
<head>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body class="container mt-5">
    <h2 class="text-success">${message}</h2>
    <p><b>First Name:</b> ${user.firstName}</p>
    <p><b>Last Name:</b> ${user.lastName}</p>
    <p><b>Email:</b> ${user.email}</p>
    <p><b>Date of Birth:</b> ${user.dateOfBirth}</p>
    <p><b>City:</b> ${user.city}</p>
</body>
</html>
