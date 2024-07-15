<%--
  Created by IntelliJ IDEA.
  User: tphan
  Date: 15/7/24
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form method="post" action="/sandwich/save">
    <input type = "checkbox" name="condiments" id="Lettuce" value="Lettuce">
    <label for="Lettuce">Lettuce</label>
    <input type = "checkbox" name="condiments" id="Tomato" value="Tomato">
    <label for="Tomato">Tomato</label>
    <input type = "checkbox" name="condiments" id="Mustard" value="Mustard">
    <label for="Mustard">Mustard</label>
    <input type = "checkbox" name="condiments" id="Sprouts" value="Sprouts">
    <label for="Sprouts">Sprouts</label>
    <hr>
    <br>
    <button type="submit">save</button>
</form>
</body>
</html>
