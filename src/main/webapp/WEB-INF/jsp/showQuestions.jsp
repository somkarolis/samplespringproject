<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<body>
<h3>Sveiki, uzpildykite klausimyna</h3>
    <table border="2">
        <c:forEach items="${questions}" var="question">
            <tr>
                <td>Klausimas: ${question.text}</td>
            </tr>
        </c:forEach>
    </table>
</body>

</html>