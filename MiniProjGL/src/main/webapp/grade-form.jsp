<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>${grade != null ? 'Edit Grade' : 'Add Grade'}</title>
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

<h1>${grade != null ? 'Edit Grade' : 'Add Grade'}</h1>
<form action="grades" method="post" class="form-group">
  <input type="hidden" name="action" value="${grade != null ? 'update' : 'insert'}">
  <c:if test="${grade != null}">
    <input type="hidden" name="id" value="${grade.id}">
  </c:if>

  <label for="studentId">Student ID:</label>
  <input type="number" id="studentId" name="studentId" value="${grade != null ? grade.studentId : ''}" class="form-control mb-2">

  <label for="moduleId">Module ID:</label>
  <input type="number" id="moduleId" name="moduleId" value="${grade != null ? grade.moduleId : ''}" class="form-control mb-2">

  <label for="grade">Grade:</label>
  <input type="number" step="0.01" id="grade" name="grade" value="${grade != null ? grade.grade : ''}" class="form-control mb-2">

  <input type="submit" value="${grade != null ? 'Update' : 'Add'} Grade" class="btn btn-primary">
</form>
<a href="grades" class="btn btn-secondary mt-2">Back to List</a>
</body>
</html>
