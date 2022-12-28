<%@ page import="app.model.Car" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <th scope="col">Delete</th>
    </tr>
    </thead>

    <tbody>
    <%
        List<Car> cars = (List<Car>) request.getAttribute("cars");
        if (cars != null && !cars.isEmpty()) {
            for (Car car : cars) {
                out.println("<tr><th scope='row'>" + car.id + "</th>");
                out.println("<td>" + car.brand + "</td>");
                out.println("<td>" + car.model + "</td>");
                out.println("<td>" + car.cost + "</td>");
                out.println("<form action='deleteCar?id=" + car.id + "' method='post'><td><button class='w-100 btn btn-lg btn-primary' type='submit'> Delete Car </button></form></td></tr>");
            }
        }
    %>
    </tbody>
</table>
</body>
</html>
