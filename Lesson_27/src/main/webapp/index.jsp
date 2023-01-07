<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>AUTO SERVICE (JSTL)</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>

<div class="container text-center">
    <div class="row">
        <div class="col">

            <main class="form-signin w-75 m-auto text-center">
                <form action="all" method="get">
                    <h1 class="h1 mb-3 fw-normal">SEARCH BAR</h1>

                    <div class="form-floating">
                        <input type="text" class="form-control" name="id">
                        <label>Car ID</label>
                    </div>

                    <button class="w-100 btn btn-lg btn-primary" type="submit">Submit</button>

                </form>
            </main>

        </div>

        <div class="col">

            <main class="form-signin w-75 m-auto text-center">
                <form action="add" method="post">
                    <h1 class="h1 mb-3 fw-normal">ADD CAR</h1>

                    <div class="form-floating">
                        <input type="number" class="form-control" name="id">
                        <label>Car ID</label>
                    </div>

                    <div class="form-floating">
                        <input type="text" class="form-control" name="brand">
                        <label>Brand</label>
                    </div>

                    <div class="form-floating">
                        <input type="text" class="form-control" name="model">
                        <label>Model</label>
                    </div>

                    <div class="form-floating">
                        <input type="number" class="form-control" name="cost">
                        <label>Cost</label>
                    </div>

                    <button class="w-100 btn btn-lg btn-primary" type="submit">Submit</button>

                </form>
            </main>

        </div>
    </div>
</div>

<br>

<%--<c:forEach items="${cars}" var="car">--%>
<%--    ${car.id} ${car.brand} ${car.model} ${car.cost} <br>--%>
<%--</c:forEach>--%>

<%--<my:Loop count="4">--%>
<%--    hello--%>
<%--</my:Loop>--%>

<%--<br>--%>

<%--<c:out value="${title}"></c:out>--%>

<%--<br>--%>

<%--<c:if test="${isAdmin == true}">--%>
<%--    Hello my dear Admin--%>
<%--</c:if>--%>

<%--<c:if test="${isAdmin == false}">--%>
<%--    You are not Admin!!!--%>
<%--</c:if>--%>

<%--<br>--%>

<%--<c:choose>--%>

<%--    <c:when test="${brand == 1}">--%>
<%--        Mers--%>
<%--    </c:when>--%>

<%--    <c:when test="${brand == 2}">--%>
<%--        Toyota--%>
<%--    </c:when>--%>

<%--    <c:otherwise>--%>
<%--        Unknown--%>
<%--    </c:otherwise>--%>

<%--</c:choose>--%>

<%--<br>--%>

<%--<c:if test="${red == true}">--%>
<%--    <c:redirect url="add.jsp"/>--%>
<%--</c:if>--%>

</body>
</html>
