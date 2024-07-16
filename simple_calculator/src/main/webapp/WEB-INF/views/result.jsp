<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tphan
  Date: 28/6/24
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<p>
    <c:if test="${msg==''}">
        ${firstOp} ${op} ${secondOp} = ${result}
    </c:if>
    <c:if test="${msg!=''}">
        ${msg}
    </c:if>
</p>
</body>
</html>
