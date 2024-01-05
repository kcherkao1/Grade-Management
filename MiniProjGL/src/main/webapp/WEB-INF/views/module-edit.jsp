<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Edit Module</title>
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


<h1>Edit Module</h1>

<c:if test="${not empty module}">
  <form action="modules" method="post" class="form-group">
    <input type="hidden" name="action" value="edit"/>
    <input type="hidden" name="id" value="${module.id}"/>

    <label for="name">Module Name:</label>
    <input type="text" id="name" name="name" value="${module.name}" class="form-control mb-2" required/>

    <label for="semester">Semester:</label>
    <input type="number" id="semester" name="semester" value="${module.semester}" class="form-control mb-2" required/>

    <input type="submit" value="Update Module" class="btn btn-primary"/>
  </form>
</c:if>

<a href="modules" class="btn btn-secondary mt-3">Back to Module List</a>

</body>
</html>
