<%--
  Created by IntelliJ IDEA.
  User: Gorazd
  Date: 14. 06. 2022
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>File Chooser</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
</head>
<body>
    <!-- send xml content -->
    <div style="background-color: skyblue">
        <h4>PRIME</h4>
        <input id="file-input" type="file" value="Open File" />

        <h3>Contents of the file:</h3>
        <pre id="file-content" hidden="hidden" style="border: 1px solid black; padding: 1vw;"></pre>
        <p>RESPONSE</p>
        <pre id="file-response" hidden="hidden" style="border: 1px solid black; padding: 1vw;"></pre>
    </div>
    <hr />
</body>
<script>
    function displayContents(contents) {
        let element = document.getElementById('file-content');
        element.hidden = false;
        element.textContent = contents;
    }
    $(document).ready(function() {
        $("#file-input").change((e) => {
            let file = e.target.files[0];
            if (!file) {
                return;
            }
            console.log("FILE:", file);
            let reader = new FileReader();          // OBJECT
            reader.onload = function(e) {
                let contents = e.target.result;     // STRING
                console.log("TYPE:", typeof contents);
                displayContents(contents);
                $.ajax({
                    url: 'parseXml',        // method from controller
                    type: 'post',
                    contentType: "application/rss+xml",  // text/plain;charset=utf-8
                    processData: false,
                    data: contents,
                    success: function(response) {
                        console.log("RESPONSE:", response);
                        let element = document.getElementById('file-response');
                        element.hidden = false;
                        element.textContent = response;
                    }
                });
            };
            reader.readAsText(file);
        });
    })
</script>
</html>
