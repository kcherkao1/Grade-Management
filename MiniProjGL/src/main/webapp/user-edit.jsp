<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Edit User</title>
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

<h1>Edit User</h1>
<form action="${pageContext.request.contextPath}/admin/users/edit" method="post" class="form-group">
  <input type="hidden" name="id" value="${user.id}" />
  <div>
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" value="${user.username}" required class="form-control mb-2"/>
  </div>
  <div>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${user.email}" required class="form-control mb-2"/>
  </div>
  <div>
    <label for="role">Role:</label>
    <select id="role" name="role" class="form-control mb-2">
      <option value="user" ${user.role == 'user' ? 'selected' : ''}>User</option>
      <option value="admin" ${user.role == 'admin' ? 'selected' : ''}>Admin</option>
    </select>
  </div>
  <div>
    <input type="submit" value="Update" class="btn btn-primary" />
  </div>
</form>
</body>
</html>
