<%@ page import="com.example.miniprojgl.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student List</title>
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

<h1>Student List</h1>
<a href="/MiniProjGL_war/student-form.jsp" class="btn btn-success mb-3">Add New Student</a>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Enrollment Number</th>
        <th>Email</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.firstName}</td>
            <td>${student.lastName}</td>
            <td>${student.enrollmentNumber}</td>
            <td>${student.email}</td>
            <td>
                <a href="students?action=edit&id=${student.id}" class="btn btn-sm btn-primary">Edit</a>
                <a href="students?action=delete&id=${student.id}" class="btn btn-sm btn-danger" onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
