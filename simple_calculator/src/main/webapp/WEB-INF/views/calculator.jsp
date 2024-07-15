<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Simple Calculatot</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="/result" method = post>
    <fieldset>
        <legend>Calculator</legend>
        <label for="fop">First Operator:</label>
        <input type="text" id="fop" name="fop" value="0"><br>
        <br>
        <label for="operator">Operator:</label>
        <select name="operator" id="operator">
            <option value="add">Addition</option>
            <option value="ded">Deduction</option>
            <option value="mul">Multiply</option>
            <option value="div">Division</option>
        </select><br>
        <br>
        <label for="sop">Second Operator:</label>
        <input type="text" id="sop" name="sop" value="0"><br>
        <br>
        <input type="submit" value="Calculate">
    </fieldset>
</form>
</body>
</html>