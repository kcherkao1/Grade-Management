<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Grade List</title>
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

<h1>Grade List</h1>
<a href="/MiniProjGL_war/grade-form.jsp" class="btn btn-success mb-3">Add New Grade</a>
<table class="table table-bordered">
  <thead>
  <tr>
    <th>ID</th>
    <th>Student Name</th>
    <th>Module Name</th>
    <th>Grade</th>
    <th>Actions</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="grade" items="${grades}">
    <tr>
      <td>${grade.id}</td>
      <td>${grade.studentName}</td>
      <td>${grade.moduleName}</td>
      <td>${grade.grade}</td>
      <td>
        <a href="grades?action=edit&id=${grade.id}" class="btn btn-sm btn-primary">Edit</a>
        <a href="grades?action=delete&id=${grade.id}" class="btn btn-sm btn-danger" onclick="return confirm('Are you sure?')">Delete</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<a href="/MiniProjGL_war/grade-report-form.jsp" class="btn btn-info">Generate Student Grade Report</a>

</body>
</html>
