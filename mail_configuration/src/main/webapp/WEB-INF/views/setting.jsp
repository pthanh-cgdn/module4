<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tphan
  Date: 16/7/24
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mail Setting</title>
</head>
<body>
<c:if test="${msg!=''}">
    <p style="color:green">${msg}</p>
</c:if>
<h1>Settings</h1>
<form:form method="post" modelAttribute="mailSetting">
    <table>
        <tr>
            <td> Language:</td>
            <td>
                <form:select path="language" items="${languageArray}">
                </form:select>
            </td>
        </tr>
        <tr>
            <td> Page size: </td>
            <td>
                Show <form:select path="pageSize" items="${pagesArray}"></form:select> emails per page
            </td>
        </tr>
        <tr>
            <td>
                Span filter:
            </td>
            <td>
                <form:checkbox path="SpamFilter"/>
            </td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td>
                <form:textarea path="signature"></form:textarea>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:button type="submit" value="Update">Update</form:button>
                <form:button type="button" value="Cancel">Cancel</form:button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
