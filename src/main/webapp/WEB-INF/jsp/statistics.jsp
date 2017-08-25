<!DOCTYPE html>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script src="../js/bootstrap.min.js"></script>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">

    <title>Quiz</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div role="navigation">
    <div class="navbar navbar-inverse">
        <a href="/" class="navbar-brand">Quiz</a>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/get-statistics">Statistika</a></li>
                <li><a href="/quiztest">Atsakyti klausimyna</a></li>
                <li><a href="/question">Prideti klausima</a></li>
            </ul>
        </div>
    </div>
</div>

<br>
<br>

<div class="container">

  <div class="starter-template">
    <h3>Klausimyno statistika:</h3>
    <table class="table table-striped table-bordered text-left">
    <thead>
        <tr>
            <th>Klausimai ir atsakymu variantai</th>
            <th>Atsakymu skaicius</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${statistics.statistics}" var="entry">
            <tr>
                <td>${entry.key}</td>
                        <c:forEach items="${entry.value}" var="answer">
                            <tr>
                                <td>${answer.key}</td>
                                    <td><c:choose>
                                        <c:when test="${answer.value != null}">
                                            ${answer.value}
                                        </c:when>
                                        <c:otherwise>
                                        </c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                        </c:forEach>
            </tr>
        </c:forEach>
        </tbody>
    </table>
  </div>

</div><!-- /.container -->
</body>
</html>