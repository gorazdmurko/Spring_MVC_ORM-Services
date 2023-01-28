<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<style>
    .inputButton {
        height: 5vh;
        width: 18vw;
        min-width: 200px;
        border-radius: 2vh;
        color: red;
        font-weight: bold;
        background-color: skyblue;
        margin: 1vh;
        padding: 1px;
        cursor: pointer;
    }
</style>
<body style="background-color: black; color: darkorange">
    <div>
        <div>
            <h2>Hello World!</h2>
        </div>
        <div>
            <form:form action="registration/registrationPage" method="POST">
                <input type="submit" name="userSignIn" value="Sign In" class="inputButton" />
            </form:form>
        </div>
        <div>
            <form:form action="form/xmlForm" method="POST">
                <input type="submit" name="Choose" value="Post XML" class="inputButton" />
            </form:form>
        </div>
        <div>
            <form:form action="form/multipartForm" method="POST">
                <input type="submit" name="Multipart" value="Post Multipart" class="inputButton" />
            </form:form>
        </div>
        <div>
            <form:form action="form/uploadForm" method="POST">
                <input type="submit" name="Multipart" value="Upload File & Post Model Class" class="inputButton" />
            </form:form>
        </div>


        <div>
            <form:form action="student/studentUploadForm" method="GET">
                <input type="submit" name="student" value="STUDENT FORM 1" class="inputButton" />
            </form:form>
        </div>
        <div>
            <form:form action="student/addStudent" method="GET">
                <input type="submit" name="student" value="STUDENT FORM (image)" class="inputButton" />
            </form:form>
        </div>
        <div>
            <form:form action="employee/viewRegistrationForm" method="GET">
                <input type="submit" name="employee" value="EMPLOYEE FORM" class="inputButton" />
            </form:form>
        </div>
    </div>
</body>
</html>
