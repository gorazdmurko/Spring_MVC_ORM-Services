<%--
  Created by IntelliJ IDEA.
  User: Gorazd
  Date: 25. 04. 2022
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!-- for JSTL-CORE tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Users Displayer</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <table style="border: blueviolet" border="1">
        <tr>
            <th style="color: mediumvioletred">ID</th>
            <th style="color: mediumvioletred">NAME</th>
            <th style="color: mediumvioletred">EMAIL</th>
        </tr>
        <!-- "users" is the key value (attributeName) in our UserController method -->
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>
    </table>

<%--    <form method="post" action="userReg.jsp">--%>
<%--        <input type="submit">--%>
<%--    </form>--%>
    <br /><br />
    <form id="target" action="registrationPage">
        <input type="submit" value="Go Back">
    </form>
    <div id="other">
        Trigger the handler
    </div>

    <br /><br />
    <p>Type 'correct' to validate.</p>
    <form action="javascript:alert( 'success!' );">
        <div>
            <input type="text">
            <input type="submit">
        </div>
    </form>
    <span></span>
</body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script>
    $( "#target" ).submit(function( event ) {
        alert( "Handler for .submit() called." );
        // event.preventDefault();  // cancel the submit action
    });
    $( "#other" ).click(function() {
        $( "#target" ).submit();
    });

    $( "form" ).submit(function( event ) {
        if ( $( "input" ).first().val() === "correct" ) {
            $( "span" ).text( "Validated..." ).show();
            return;
        }

        $( "span" ).text( "Not valid!" ).show().fadeOut( 1000 );
        event.preventDefault();
    });
</script>
</html>
