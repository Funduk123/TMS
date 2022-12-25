<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding car</title>
</head>
<body>
<%
    java.util.Date date = new java.util.Date();
%>

<p><%= date %>
</p>

<h2>Adding car</h2>

<form action="cars" method="POST">

    ID: <input name="id"/>
    <br><br>
    Brand: <input name="brand"/>
    <br><br>
    Model: <input name="model"/>
    <br><br>
    <input type="submit" value="Save"/>

</form>
</body>
</html>
