<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
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
                <li><a href="quiz">Quiz</a></li>
                <li><a href="result">Results</a></li>
                <li><a href="new-question">Add new Question</a></li>
            </ul>
        </div>
    </div>
</div>

<c:choose>
    <c:when test="${mode == 'MODE_HOME'}">
        <div class="container invisible-at-first" id="homeDiv">
            <div class="jumbotron text-center">
                <h1>Welcome to VCS0630 Java Quiz!</h1>
            </div>
        </div>
    </c:when>

    <c:when test="${mode == 'MODE_SUCCESS'}">
        Successfully submitted quiz!
    </c:when>

    <c:when test="${mode == 'MODE_NEW_QUESTION_SUCCESS'}">
        Successfully submitted new question!
    </c:when>

    <c:when test="${mode == 'MODE_QESTIONS'}">
        <div class="container text-center" id="questionsDiv">
            <h3>Quiz</h3>
            <hr>
            <div class="table-responsive">
                <form:form modelAttribute="submissionDTO" method="POST" action="/quiz">

                    Vardas<input path="submissionDTO.firstName" name="firstName" />
                    Pavarde<input path="submissionDTO.lastName" name="lastName" />

                    <hr>
                    <table class="table table-striped table-bordered text-left">
                        <thead>
                        <tr>
                            <th>Question</th>
                            <th>Answer</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="questionValue" items="${questionValues}">
                            <tr>
                                <td>${questionValue.question.questionText}</td>
                                <td>
                                    <c:if test="${questionValue.question.type=='RADIO'}">
                                        <c:forEach var="answer" items="${questionValue.answers}">

                                            <form:radiobutton path="answerDTOs" name="inputs['${questionValue.id}']" value="${questionValue.question.id}"/>${answer}
                                        </c:forEach>

                                    </c:if>
                                    <c:if test="${questionValue.question.type=='SELECT'}">

                                        <form:select path="answerDTOs" multiple="false">
                                            <form:options items="${questionValue.answers}" value="${questionValue.question.id}"></form:options>
                                        </form:select>

                                    </c:if>
                                    <c:if test="${questionValue.question.type=='CHECK'}">

                                        <c:forEach var="answer" items="${questionValue.answers}">
                                            <form:checkbox path="answerDTOs" value="${questionValue.question.id}"/>${answer}
                                            <br>
                                        </c:forEach>

                                    </c:if>

                                    <c:if test="${questionValue.question.type=='INPUT'}">
                                        <form:input path="answerDTOs" name="inputs['${questionValue.question.id}']"/>

                                    </c:if>

                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <input type="submit" class="btn btn-primary" value="Submit">
                </form:form>
            </div>
        </div>
    </c:when>

    <c:when test="${mode == 'MODE_NEW' || MODE_EDIT}">
        <form:form modelAttribute="questionDTO" method="POST" action="/save-question">
            <div class="container text-center">
                <h3>Create new question</h3>
                <hr/>

                <form class="form-horizontal" method="POST" action="save-question">

                    <div class="form-group row">
                        <form:label path="text" for="example-text-input"
                                    class="col-2 col-form-label">Enter Question Text</form:label>
                        <div class="col-10">
                            <form:input path="text" class="form-control" type="text" id="example-text-input"/>
                        </div>
                    </div>

                    <form:label path="type" class="mr-sm-2" for="inlineFormCustomSelect">Question Type</form:label>
                    <form:select path="type" class="custom-select mb-2 mr-sm-2 mb-sm-0" id="inlineFormCustomSelect">
                        <form:options items="${type}"></form:options>
                    </form:select>

                    <div class="form-group">
                        <form:label path="dtos" for="possibleAnswer">Possible Answers (max. 5)</form:label>
                        <form:input path="dtos" type="text" class="form-control" id="possibleAnswer"
                                    placeholder="Possible Answer"/>
                    </div>

                    <div class="form-group">
                        <form:label path="dtos" for="possibleAnswer"></form:label>
                        <form:input path="dtos" type="text" class="form-control" id="possibleAnswer"
                                    placeholder="Possible Answer"/>
                    </div>

                    <div class="form-group">
                        <form:label path="dtos" for="possibleAnswer"></form:label>
                        <form:input path="dtos" type="text" class="form-control" id="possibleAnswer"
                                    placeholder="Possible Answer"/>
                    </div>

                    <div class="form-group">
                        <form:label path="dtos" for="possibleAnswer"></form:label>
                        <form:input path="dtos" type="text" class="form-control" id="possibleAnswer"
                                    placeholder="Possible Answer"/>
                    </div>

                    <div class="form-group">
                        <form:label path="dtos" for="possibleAnswer"></form:label>
                        <form:input path="dtos" type="text" class="form-control" id="possibleAnswer"
                                    placeholder="Possible Answer"/>
                    </div>

                    <input type="submit" class="btn btn-primary" value="Save New Question"/>
                </form>
            </div>
        </form:form>

    </c:when>

    <c:when test="${mode == 'MODE_RESULTS'}">
        <div class="container text-center" id="questionsDiv">

            <h3>Results</h3>

            <table class="table table-striped table-bordered text-left">
                <thead>
                <tr>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Answers</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="result" items="${resultDTO}">
                    <tr>
                        <td>${result.firstName}</td>
                        <td>${result.lastName}</td>
                        <td>
                            <c:forEach var="answer" items="${result.answers}">
                                <%--<form:checkbox path="dtos" name="text" value="${answer}"/>${answer}--%>
                                ${answer}
                                <br>
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


        </div>
    </c:when>
</c:choose>

<script src="static/js/jquery-1.11.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
</body>
</html>