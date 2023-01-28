<%--
  Created by IntelliJ IDEA.
  User: Gorazd
  Date: 22. 06. 2022
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
<%--    <h3>Profile Image: <img width="30%" height="30%" src="<spring:url value='${savedStudent.image}' />"></h3>--%>
<%--    <p>Profile Image: <img width="30%" height="30%" src="<spring:url value='/resources/images/${savedStudent.image.originalFilename}' />"></p>--%>

</body>
</html>
