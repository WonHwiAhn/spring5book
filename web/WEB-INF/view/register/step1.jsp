<%--
  Created by IntelliJ IDEA.
  User: whahn
  Date: 2019-03-10
  Time: 오전 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
  <head>
    <title>
      <spring:message code="member.register">
        <spring:argument value="하즈아~~~~" />
      </spring:message>
    </title>
  </head>
  <body>
    <h2><spring:message code="term" /></h2>
    <p><spring:message code="term" /> 내용</p>
    <form action="step2" method="post">
      <label>
        <input type="checkbox" name="agree" value="true"> <spring:message code="term.agree" />
      </label>
      <input type="submit" value="<spring:message code="next.btn" />"/>
    </form>
  </body>
</html>
