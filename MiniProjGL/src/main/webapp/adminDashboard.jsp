<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.miniprojgl.model.User" %>

<html>
<head>
  <title>Home - Management Dashboard</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/custom_stylesheet.css">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="navbar-nav">
    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/students">Students</a>
    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/teachers">Teachers</a>
    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/modules">Modules</a>
    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/grades">Grades</a>
    <a class="nav-item nav-link btn btn-danger" href="${pageContext.request.contextPath}/logout">Logout</a>
  </div>
</nav>
<%  User user = (User) request.getSession().getAttribute("user"); %>

<div class="container mt-4">
  <h1>Welcome to the Management Dashboard <%= user.getUsername() %> !</h1>
  <p>Select an option from the menu to manage the respective entities.</p>
</div>

</body>
</html>
