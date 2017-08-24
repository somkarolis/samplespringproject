<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
    <form:form method="POST" action="/submit-quiz-answers" modelAttribute="submission">
    <body>
        <h3>Sveiki, uzpildykite apklausa:</h3>
            <table border="1">
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
    <table border="1">
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
</html>