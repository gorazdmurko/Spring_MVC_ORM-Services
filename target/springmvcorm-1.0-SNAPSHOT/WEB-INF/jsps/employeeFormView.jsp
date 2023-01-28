<%--
  Created by IntelliJ IDEA.
  User: Gorazd
  Date: 24. 06. 2022
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee Registration</title>
</head>
<body>
    <div align="center">
        <!-- commandName attribute is the key which specifies name of the model class object that acts as a backing object for this form -->
        <!-- if you use Spring framework 5, use the modelAttribute attribute instead -->
        <form:form action="register" method="post" modelAttribute="employeeForm">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Spring MVC Form Demo - Registration</h2></td>
                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><form:input path="username" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:password path="password" /></td>
                </tr>
                <tr>
                    <td>E-mail:</td>
                    <td><form:input path="email" /></td>
                </tr>
                <tr>
                    <td>Birthday (mm/dd/yyyy):</td>
                    <td><form:input path="birthDate" /></td>
                </tr>
                <tr>
                    <td>Profession:</td>
                    <td><form:select path="profession" items="${professionList}" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="hidden" name="hidden" value="" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Register" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
<style>
    body {
        background-color: black;
        color: orange;
    }
</style>
</html>
