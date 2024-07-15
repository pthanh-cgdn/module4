
<%--
  Created by IntelliJ IDEA.
  User: tphan
  Date: 15/7/24
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sandwich</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<a href="/sandwich/save" methods="get">
    <button class="btn btn-primary mt-4">Order</button>
</a>
<table class="table table-hover">
    <thead>
    <tr>
        <th>Order</th>
        <th>Condiment</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="orders" items="${orders}">
    <tr>
        <td>${orders.id}</td>
        <td>
                <%--            <c:forEach var="condiments" items="${orders.condiments}">--%>
                <%--                ${condiments}--%>
                <%--            </c:forEach>--%>
                ${orders.toString()}
        </td>
        </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
