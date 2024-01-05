<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.miniprojgl.model.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Dashboard</title>
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
<h1>User Dashboard</h1>
<%
    User user = (User) request.getSession().getAttribute("user");
    if (user == null) {
        // Redirect to login if not logged in
        response.sendRedirect("login.jsp");
        return;
    }
    if ("admin".equalsIgnoreCase(user.getRole())) {
        // Redirect to login if not logged in
        response.sendRedirect("adminDashboard.jsp");
        return;
    }

%>
<p>Welcome, <%= user.getUsername() %>!</p>
</br>
<ul class="list-unstyled">
    <li><a href="viewProfile.jsp">View Profile</a></li>
    <li><a href="editProfile.jsp">Edit Profile</a></li>
    <!-- Add other links as needed -->
</ul>

<a href="logout" class="btn btn-danger mt-2">Logout</a>
</body>
</html>
