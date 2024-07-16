<%--
  Created by IntelliJ IDEA.
  User: tphan
  Date: 28/6/24
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create new customer</title>
    <style>
        .message {
            color: green;
        }
    </style>
</head>
<body>
<h1>Create new student</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/student">Back to student list</a>
</p>

<form:form method="post" modelAttribute="student">
    <fieldset>
        <legend>Student information</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><form:input path="address"/></td>
            </tr>
            <tr>
                <td>Point:</td>
                <td><form:input path="point"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create new student"></td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
