<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CARS LIST</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>

<h1 class="h1 mb-3 fw-normal text-center">CARS LIST</h1>

<table class="table table-bordered border-dark w-50 text-center" style="margin: auto;">

    <thead>
    <tr class="table table-dark">
        <th scope="col">ID</th>
        <th scope="col">Brand</th>
        <th scope="col">Model</th>
        <th scope="col">Cost, $</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>

    <tbody>

    <c:forEach items="${cars}" var="car">
        <form method="post" action="delete">
            <tr>
                <input type="hidden" name="id" value="${car.id}">
                <th scope="row"> ${car.id} </th>
                <td> ${car.brand} </td>
                <td> ${car.model} </td>
                <td> ${car.cost} </td>
                <td><input type="submit" value="Delete"></td>
        </form>

        <form method="post" action="update">
            <input type="hidden" name="id" value="${car.id}">
            <td><input type="submit" value="Update"></td>
        </form>

    </c:forEach>
    </tbody>
</table>

<br><br>

<form action="update" method="get" class="text-center">
    <button type="submit">Go to main page</button>
</form>

</body>
</html>
