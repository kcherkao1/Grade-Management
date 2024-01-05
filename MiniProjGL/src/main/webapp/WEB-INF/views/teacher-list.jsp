<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Teacher List</title>
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


<h1>List of Teachers</h1>

<a href="/MiniProjGL_war/add-teacher.jsp" class="btn btn-success mb-3">Add New Teacher</a>

<table class="table table-bordered">
  <tr>
    <th>ID</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Specialty</th>
    <th>Actions</th>
  </tr>
  <c:forEach var="teacher" items="${teachers}">
    <tr>
      <td>${teacher.id}</td>
      <td>${teacher.firstName}</td>
      <td>${teacher.lastName}</td>
      <td>${teacher.specialty}</td>
      <td>
        <a href="teachers?action=editForm&id=${teacher.id}" class="btn btn-sm btn-primary">Edit</a>
        <a href="teachers?action=delete&id=${teacher.id}" class="btn btn-sm btn-danger" onclick="return confirm('Are you sure you want to delete this teacher?');">Delete</a>
      </td>
    </tr>
  </c:forEach>
</table>

</body>
</html>
