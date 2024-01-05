<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Teacher</title>
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


<h2>Edit Teacher</h2>
<form action="teachers" method="post" class="form-group">
    <input type="hidden" name="action" value="edit" />
    <input type="hidden" name="id" value="${teacher.id}" />

    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName" value="${teacher.firstName}" class="form-control mb-2">

    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName" value="${teacher.lastName}" class="form-control mb-2">

    <label for="specialty">Specialty:</label>
    <input type="text" id="specialty" name="specialty" value="${teacher.specialty}" class="form-control mb-2">

    <input type="submit" value="Update" class="btn btn-primary">
</form>

</body>
</html>
