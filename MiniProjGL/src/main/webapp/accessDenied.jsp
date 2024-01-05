<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Access Denied</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      text-align: center;
      padding: 50px;
    }
    .container {
      background-color: #fff;
      margin: auto;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
      max-width: 400px;
    }
    h1 {
      color: #ff6347; /* Tomato color */
    }
    p {
      color: #333;
    }
    a {
      display: inline-block;
      padding: 10px 15px;
      background-color: #007bff;
      color: #fff;
      text-decoration: none;
      border-radius: 4px;
      transition: background-color 0.3s;
    }
    a:hover {
      background-color: #0056b3;
    }
  </style>
</head>
<body>

<div class="container">
  <h1>Access Denied</h1>
  <p>Sorry, you do not have permission to view this page.</p>
  <a href="<%=request.getContextPath()%>/userDashboard.jsp">Return to Dashboard</a>
</div>

</body>
</html>
