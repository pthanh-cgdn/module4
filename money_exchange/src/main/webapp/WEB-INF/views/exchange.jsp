<%--
  Created by IntelliJ IDEA.
  User: tphan
  Date: 14/7/24
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exchange Money</title>
</head>
<body>
<h1>Exchange Money</h1>
<form action="result" method="post">
    <p>Please enter amount: <input type = "number" name="amount" min="0"></p>
    <p>Please choose you currency:
    <select name="currency">
        <option value="usd">USD</option>
        <option value="vnd">VND</option>
    </select>
    </p>
    <button type="submit">Exchange</button>
</form>
</body>
</html>
