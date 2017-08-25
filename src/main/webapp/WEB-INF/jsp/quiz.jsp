<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

<div class="table-responsive">
    <form:form method="POST" action="/submit-quiz-answers" modelAttribute="submission">
    <body>
        <h3>Sveiki, uzpildykite apklausa:</h3>
            <table class="table table-striped table-bordered text-left">
                <tr>
                    <td><form:label path="name">Vardas</form:label></td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td><form:label path="surname">Pavarde</form:label></td>
                    <td><form:input path="surname"/></td>
                </tr>
            </table>
</body>
<br>
<body>
    <table class="table table-striped table-bordered text-left">
        <c:forEach items="${questions}" var="question">
            <tr>
                <td>${question.text}</td>
                <td>
                        <c:forEach items="${question.questionValues}" var="questionValue">
                            <c:choose>
                                <c:when test="${question.type == 'INPUT'}">
                                <input type="text" name="inputs['${questionValue.id}']"/>
                                </c:when>
                                <c:otherwise>
                                    <c:choose>
                                        <c:when test="${question.type == 'SELECT'}">
                                            <form:select path="answerDTOs" value="${questionValue.id}"/>${questionValue.text}
                                        </c:when>
                                        <c:otherwise>
                                            <c:choose>
                                                <c:when test="${question.type == 'RADIO'}">
                                                    <form:radiobutton path="answerDTOs" value="${questionValue.id}"/>${questionValue.text}
                                                </c:when>
                                                <c:otherwise>
                                                    <c:choose>
                                                        <c:when test="${question.type == 'CHECKBOX'}">
                                                            <form:checkbox path="answerDTOs" value="${questionValue.id}"/>${questionValue.text}
                                                        </c:when>
                                                        <c:otherwise>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:otherwise>
                            </c:choose>
                            </c:otherwise>
                            </c:choose>
                        </c:forEach>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td><input type="submit" value="Pateikti"/></td>
        </tr>
    </table>
</body>
    </form:form>
</div>
</html>