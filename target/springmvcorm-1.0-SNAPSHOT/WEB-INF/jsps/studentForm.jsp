<%--
  Created by IntelliJ IDEA.
  User: Gorazd
  Date: 23. 06. 2022
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="applianceRegistration" tagdir="/WEB-INF/tags/responsive/applianceRegistration" %>
<%--<jsp:include page="" />--%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Student Form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />--%>
</head>
<body>
    <applianceRegistration:progressBar  noSteps="4" currStep="4" />
    <h2>Student Information</h2>

    <form:form method = "POST" action="addStudent" modelAttribute="student" enctype="multipart/form-data">
        <table>
            <tr>
                <td><form:label path = "id">id</form:label></td>
                <td><form:input path = "id" /></td>
            </tr>
            <tr>
                <td><form:label path = "age">Age</form:label></td>
                <td><form:input path = "age" /></td>
            </tr>
            <tr>
                <td><form:label path = "name">Name</form:label></td>
                <td><form:input path = "name" /></td>
            </tr>
            <tr>
                <td><form:label path = "address.street">Address</form:label></td>
                <td><form:input path = "address.street" /></td>
            </tr>
            <tr>
                <td><form:label path = "address.state">State</form:label></td>
                <td><form:input path = "address.state" /></td>
            </tr>
            <tr>
                <td><form:label path = "address.zipcode">Zipcode</form:label></td>
                <td><form:input path = "address.zipcode" /></td>
            </tr>
            <tr>
                <td><form:label path = "multipartFile">Multipart</form:label></td>
                <td><form:input path = "multipartFile" type="file" /></td>
            </tr>
            <tr>
                <td colspan = "2">
                    <input type = "submit" value = "SAVE"/>
                </td>
            </tr>
        </table>
    </form:form>
    <applianceRegistration:continueButton />
</body>

<style>
    <%@ include file="/WEB-INF/css/style.css" %>
</style>
</html>
