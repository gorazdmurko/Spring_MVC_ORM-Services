<%--
  Created by IntelliJ IDEA.
  User: Gorazd
  Date: 22. 06. 2022
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Success</title>
</head>
<body style="background-color: black; color: lightseagreen">

    <h1>STUDENT SAVED SUCCESSFULLY</h1>
    <h3>Id: ${savedStudent.id}</h3>
    <h3>Name: ${savedStudent.name}</h3>
    <h3>Age: ${savedStudent.age}</h3>
    <h2>ADDRESS INFO</h2>
    <h3>Street: ${savedStudent.address.street}</h3>
    <h3>State: ${savedStudent.address.state}</h3>
    <h3>Zip Code: ${savedStudent.address.zipcode}</h3>
    <h3>XML: ${savedStudent.content}</h3>

    <c:if test="${not empty encodedImage}">
        <div align="center" style="margin-top: 2em">
            <img src="${encodedImage}" alt=\"\" height=\"230\" width=\"390\" />
        </div>
    </c:if>

</body>
</html>
