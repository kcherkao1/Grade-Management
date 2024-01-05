<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Generate Grade Report</title>
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

<h1>Generate Grade Report</h1>
<form action="${pageContext.request.contextPath}/grades" method="get" class="form-group">
  <input type="hidden" name="action" value="generateReport" />

  <label for="studentId">Student ID:</label>
  <input type="number" id="studentId" name="studentId" required class="form-control mb-2">

  <button type="submit" class="btn btn-primary">Generate Report</button>
</form>
<button type="button" onclick="history.back();" class="btn btn-secondary mt-2">Back</button>

</body>
</html>
