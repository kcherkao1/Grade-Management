<%@ page import="com.example.miniprojgl.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/custom_stylesheet.css">
</head>
<body class="container mt-4">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="navbar-nav">
        <a class="nav-item nav-link" href="${pageContext.request.contextPath}/userDashboard.jsp">Home</a>
        <a class="nav-item nav-link" href="${pageContext.request.contextPath}/students">Students</a>
        <a class="nav-item nav-link" href="${pageContext.request.contextPath}/teachers">Teachers</a>
        <a class="nav-item nav-link" href="${pageContext.request.contextPath}/grades">Grades</a>
        <a class="nav-item nav-link" href="${pageContext.request.contextPath}/modules">Modules</a>
        <a class="nav-item nav-link btn btn-danger" href="${pageContext.request.contextPath}/logout">Logout</a>
        <!-- Add other links as needed -->
    </div>
</nav>

<h1>User Registration</h1>
<%
    User user = (User) request.getSession().getAttribute("user");
    if ("user".equalsIgnoreCase(user.getRole())) {
        // Redirect to login if not logged in
        response.sendRedirect("accessDenied.jsp");
        return;
    }

%>

<form action="${pageContext.request.contextPath}/register" method="post" class="form-group">
    <div>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required class="form-control mb-2">
    </div>
    <div>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required class="form-control mb-2">
    </div>
    <div>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required class="form-control mb-2">
    </div>
    <div>
        <label for="role">Role:</label>
        <select id="role" name="role" required class="form-control mb-2">
            <option value="">Select a role</option>
            <option value="admin">Admin</option>
            <option value="user">User</option>
        </select>
    </div>
    <div>
        <button type="submit" class="btn btn-primary">Register</button>
    </div>
</form>
</body>
</html>
