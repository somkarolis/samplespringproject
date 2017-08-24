<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
    <form:form method="POST" action="/create-new-question" modelAttribute="question">
        <body>
            <h3>Iveskite nauja klausima:</h3>
                <table border="1">
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