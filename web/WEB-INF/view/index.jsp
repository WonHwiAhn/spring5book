<%--
  Created by IntelliJ IDEA.
  User: whahn
  Date: 2019-03-10
  Time: 오전 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%
      response.sendRedirect(request.getContextPath() + "/register/step1");
    %>
  </body>
</html>
