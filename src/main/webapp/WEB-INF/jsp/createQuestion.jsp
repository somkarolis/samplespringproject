<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

<form:form method="POST" action="/create-new-question" modelAttribute="question">
    <body>
        <h3>Iveskite nauja klausima:</h3>
            <table class="table table-striped table-bordered text-left">
                <tr>
                    <td><form:label path="text">Iveskite klausimo teksta:</form:label></td>
                    <td><form:input path="text"/></td>
                </tr>
                <tr>
                    <td><form:label path="type">Pasirinkite klausimo tipa:</form:label></td>
                    <td><form:select path="type" value="${questionTypes}" items="${questionTypes}"/></td>
                </tr>
                <br>
                <tr>
                    <td><form:label path="dtos">Iveskite pirma atsakymo varianta:</form:label></td>
                    <td><form:input path="dtos"/></td>
                </tr>
                <tr>
                    <td><form:label path="dtos">Iveskite antra atsakymo varianta:</form:label></td>
                    <td><form:input path="dtos"/></td>
                </tr>
                <tr>
                    <td><form:label path="dtos">Iveskite trecia atsakymo varianta:</form:label></td>
                    <td><form:input path="dtos"/></td>
                </tr>
                <tr>
                    <td><form:label path="dtos">Iveskite ketvirta atsakymo varianta:</form:label></td>
                    <td><form:input path="dtos"/></td>
                </tr>
            </table>
            <tr>
                <td><input type="submit" value="Pateikti"/></td>
            </tr>
    </body>
</form:form>
</html>