<%--
  Created by IntelliJ IDEA.
  User: Gorazd
  Date: 22. 04. 2022
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

    <script>
        $(document).ready(function() {
            // at input change
            $("#id").change(function() {
                $.ajax({
                    url: 'validateEmail',                   // url of the server ( + validateEmail() function is called)
                    data: {id:$("#id").val()},              // get the value of particular field that has to be sent to a server
                    success: function(responseText) {       // callback function (invoked when the response comes back)
                        $("#errMsg").text(responseText);
                        if (responseText != "") {
                            $("#id").focus();               // returns the focus back to id field
                        }
                    }
                });
            });
            // get users using jQuery
            $("#getUsersButton").click(() => {
                $("#submitForm").attr('method', 'post').attr('action', 'getUsers').submit();
            });
            // show browsers popup
            $("#popup").click(() => {
                if (confirm("Do you really want to continue?")) {
                    console.log("CONFIRMED");
                    $("#popupForm").attr("method", "post").attr("action", "getUsers").submit();
                } else {
                    console.log("CANCELED");
                }
            });
            // jQuery submit
            $("#targetForm").submit((e) => {
                if (confirm("Want to proceed?")) {
                    console.log("Processed");
                } else {
                    e.preventDefault();
                    console.log("Canceled");
                }
            })
            // show modal
            $(document).ready(function () {
                $("#btnShow").click(function () {
                    // $('#SampleModal').modal('show');
                    $('#SampleModal').modal('show');
                    $("#save").click(() => {
                        console.log("Modal confirmed!");
                        $('#SampleModal').modal('hide');
                    });
                    $("#close").click(() => {
                        $('#SampleModal').modal('hide');
                        console.log("Modal canceled!");
                        // $("#getUsers").attr('method', 'post').attr('action', 'registerUser').submit();
                    })
                });
            });
        })
    </script>
</head>
<!-- BODY -->
<body>
    <!-- 1. FORM -->
    <div>
        <!-- R E G I S T R A T I O N -->
        <form action="registerUser" method="post" autocomplete="off">      <!-- "/registerUser" goes to Spring container first, which creates corresponding model object for this POM -->
            <pre>
                Id: <input type="text" name="id" id="id" style="margin: 5px" /><span id="errMsg"></span>
                Name: <input type="text" name="name" style="margin: 5px" />
                Email: <input type="text" name="email" style="margin: 5px" />
                <br />
                <input type="submit" name="register" value="SEND" />     <!-- when submit button is hit, registerUser() method is called and browser goes to /regResult url -->
            </pre>
        </form>
    </div>

    <!-- 2. FORM ~~ submit vs. button -->
    <div style="margin-left: 2vw">
        <!-- a) action -->
        <form action="getUsers" method="get">
            <input type="submit" value="ALL USERS" id="getAll" /><br />
        </form>
        <!-- b) jQuery -->
        <form id="submitForm">
            <input type="button" value="GET USERS" id="getUsersButton" />
        </form>
        <!-- c) BUTTON / jQuery -->
        <form id="popupForm">
            <input type="button" value="POPUP" id="popup" />
        </form>
        <br /><br />
    </div>
    <br /><br />
    <!-- 3. FORM >> jQuery submit -->
    <div>
        <form id="targetForm" action="getUsers" method="post" autocomplete="off">
            <pre>
                <input type="submit" name="getUsers" value="SEND" />
            </pre>
        </form>
    </div>

    <!-- 4. MODAL -->
    <div style="text-align:center; margin-top:10%">
        <button id="btnShow" class="btn btn-success">Show Modal Popup</button>
    </div>
    <div class="modal fade" id="SampleModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">Modal Popup</h4>
                </div>
                <div class="modal-body">Welcome to Modal Popup</div>
                <div class="modal-footer">
<%--                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>--%>
<%--                    <button type="button" class="btn btn-primary" id="save">Save</button>--%>
                    <form id="getUsers" action="getUsers">
                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Close" id="close" />
                        <input type="submit" value="SAVE" id="save">
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- values returned from controller -->
    <div>
        ${message}
        ${result}
    </div>
</body>
</html>
