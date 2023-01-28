<%--
  Created by IntelliJ IDEA.
  User: Gorazd
  Date: 21. 06. 2022
  Time: 07:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Multipart</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
</head>
<body style="background-color: black; color: orange">
    <div class="container">
        <h1>WORKING PART</h1>
        <h3>Multipart</h3>
        <form action="uploadMultipart" method="post" enctype="multipart/form-data" name="uploadedForm">
            <input type="file" name="selectedFile" id="selectedFile" />
            <input type="submit" name="upload" value="Upload file">
        </form>
    </div>

    <hr />

    <!-- FORM DATA -->
    <div class="container">
        <h1>Multipart Upload (not working yet)</h1>
        <h3>FORM DATA</h3>
        <form id="form" enctype="multipart/form-data">
            <div class="input-group">
                <label for="file">Select files</label>
                <input id="file" type="file" name="selectedFile" value="Upload Multipart" />
            </div>
            <button class="submit-btn" type="submit">Upload</button>
        </form>
    </div>

    <div>
        ${person}
    </div>
</body>
<script>
    $(document).ready(function() {
        const form = document.getElementById("form");
        const file = document.getElementById("file").files[0];
        let formData = new FormData();
        console.log("INSIDE");

        function handleSubmit() {
            formData.append('selectedFile', file);
            fetch('uploadMultipart', {
                method: "POST",
                body: formData
            });
        }
        form.addEventListener("submit", handleSubmit);
    });

    // const form = document.getElementById("form");
    // const inputFile = document.getElementById("file");
    //
    // const formData = new FormData();
    //
    // const handleSubmit = (event) => {
    //     event.preventDefault();
    //
    //     for (const file of inputFile.files) {
    //         formData.append("files", file);
    //     }
    //
    //     fetch("http://localhost:8282/Spring_MVC_ORM/multipartForm", {
    //         method: "post",
    //         body: formData,
    //     }).catch((error) => ("Something went wrong!", error));
    // };
    //
    // form.addEventListener("submit", handleSubmit);
</script>
<style>
    .container {
        margin: 4vh;
        padding: 2vh;
        width: 75vh;
        border: 2px solid white;
    }
</style>
</html>
