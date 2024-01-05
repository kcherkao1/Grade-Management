<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/custom_stylesheet.css">
</head>

<body class="container mt-4">

<h2>Login</h2>
<form action="login" method="post" class="form-group">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required class="form-control mb-2">

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required class="form-control mb-2">

    <input type="submit" value="Login" class="btn btn-primary">
</form>
</body>
</html>
