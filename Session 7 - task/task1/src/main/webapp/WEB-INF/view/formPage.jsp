<html>
<head>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

<body>

    <form action="processForm">
        <input type="text" class="form-control mb-2" placeholder="Enter Year" name="year">
        <input type="text" class="form-control mb-2" placeholder="Enter Month" name="month">
        <input type="text" class="form-control mb-2" placeholder="Enter Day" name="day">
        <button type="submit" class="btn btn-primary w-100">Calculate Age</button>
    </form>

 </body>
</html>
