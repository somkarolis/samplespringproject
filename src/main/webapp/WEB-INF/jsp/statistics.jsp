<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
    <body>
        <h3>Klausimyno statistika:</h3>
            <table border="1">
                <c:forEach items="${statistics.statistics}" var="entry">
                    <tr>
                        <td>${entry.key}</td>
                        <tr>
                            <td>Atsakymu variantai</td>
                            <td>Atsakymu kiekis</td>
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
                    </tr>
                </c:forEach>
            </table>
    </body>
</html>