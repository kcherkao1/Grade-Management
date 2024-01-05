<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>User Management</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/custom_stylesheet.css">
</head>
<body class="container mt-4">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="navbar-nav">
    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/userDashboard">Home</a>
    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/students">Students</a>
    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/teachers">Teachers</a>
    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/grades">Grades</a>
    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/modules">Modules</a>
    <a class="nav-item nav-link btn btn-danger" href="${pageContext.request.contextPath}/logout">Logout</a>
    <!-- Add other links as needed -->
  </div>
</nav>

<h1>User List</h1>
<table class="table table-bordered">
  <tr>
    <th>ID</th>
    <th>Username</th>
    <th>Email</th>
    <th>Actions</th>
  </tr>
  <c:forEach var="user" items="${users}">
    <tr>
      <td>${user.id}</td>
      <td>${user.username}</td>
      <td>${user.email}</td>
      <td>
        <a href="${pageContext.request.contextPath}/admin/users/edit?id=${user.id}" class="btn btn-sm btn-primary">Edit</a>
        <a href="#" class="btn btn-sm btn-danger" onclick="deleteUser(${user.id});">Delete</a>
      </td>
    </tr>
  </c:forEach>
</table>

<script>
  function deleteUser(id) {
    if (confirm('Are you sure you want to delete this user?')) {
      var xhr = new XMLHttpRequest();
      xhr.open('DELETE', '${pageContext.request.contextPath}/admin/users/edit?id=' + id, true);
      xhr.onload = function () {
        if (xhr.status === 200) {
          alert('User deleted');
          window.location.reload();
        } else {
          alert('Error deleting user');
        }
      };
      xhr.send();
    }
  }
</script>

</body>
</html>
