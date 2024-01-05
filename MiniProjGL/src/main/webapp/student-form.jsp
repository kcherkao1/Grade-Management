<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${student != null ? 'Edit Student' : 'Add Student'}</title>
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

<h1>${student != null ? 'Edit Student' : 'Add Student'}</h1>
<form action="students" method="post" class="form-group">
    <input type="hidden" name="action" value="${student != null ? 'update' : 'insert'}">
    <c:if test="${student != null}">
        <input type="hidden" name="id" value="${student.id}">
    </c:if>
    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName" value="${student != null ? student.firstName : ''}" class="form-control mb-2">
    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName" value="${student != null ? student.lastName : ''}" class="form-control mb-2">
    <label for="enrollmentNumber">Enrollment Number:</label>
    <input type="text" id="enrollmentNumber" name="enrollmentNumber" value="${student != null ? student.enrollmentNumber : ''}" class="form-control mb-2">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${student != null ? student.email : ''}" class="form-control mb-2">
    <input type="submit" value="${student != null ? 'Update' : 'Add'} Student" class="btn btn-primary">
</form>
<a href="students" class="btn btn-secondary mt-2">Back to List</a>
</body>
</html>
