<%--
  Created by IntelliJ IDEA.
  User: whahn
  Date: 2019-03-18
  Time: 오후 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>로그인 폼</title>
</head>
<body>
    <form:form modelAttribute="loginCommand">
        <form:errors />
        <p>
            <label>
                <spring:message code="email" />
                <form:input path="email" />
                <form:errors path="email" />
            </label>
        </p>
        <p>
            <label>
                <spring:message code="password" />
                <form:input path="password" />
                <form:errors path="password" />
            </label>
        </p>
        <p>
            <label>
                <spring:message code="rememberEmail" />
                <form:checkbox path="rememberEmail"/>
            </label>
        </p>
        <input type="submit" value="<spring:message code="login.btn" />">
    </form:form>
</body>
</html>
