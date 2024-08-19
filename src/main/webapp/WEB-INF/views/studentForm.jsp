<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Student Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        .form-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }
        .form-container div {
            margin-bottom: 15px;
        }
        .form-container label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #333;
        }
        .form-container input[type="text"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .form-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        .form-container input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .error {
            color: red;
            font-size: 12px;
            font-weight: bold;
        }
        .required{
            color: red;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Student Registration Form</h2>

        <form:form action="registerStudent" modelAttribute="student">

            <div>
                <form:label path="firstName">First Name <span class="required">*</span></form:label>
                <form:input path="firstName"/>
                <form:errors path="firstName" cssClass="error"/>
            </div>

            <div>
                <form:label path="lastName">Last Name </form:label>
                <form:input path="lastName"/>
                <form:errors path="lastName" cssClass="error"/>
            </div>

            <div>
                <form:label path="enrollmentNo">Enrollment Number <span class="required">*</span></form:label>
                <form:input path="enrollmentNo"/>
                <form:errors path="enrollmentNo" cssClass="error"/>
            </div>

            <div>
                <form:label path="phoneNumber">Phone Number <span class="required">*</span></form:label>
                <form:input path="phoneNumber"/>
                <form:errors path="phoneNumber" cssClass="error"/>
            </div>

            <div>
                <form:label path="aggregatePercentage">Aggregate Percentage <span class="required">*</span></form:label>
                <form:input path="aggregatePercentage"/>
                <form:errors path="aggregatePercentage" cssClass="error"/>
            </div>

            <div>
                <form:label path="gender">Gender <span class="required">*</span></form:label>
                <form:input path="gender"/>
                <form:errors path="gender" cssClass="error"/>
            </div>

            <div>
                <form:label path="email">Email <span class="required">*</span></form:label>
                <form:input path="email"/>
                <form:errors path="email" cssClass="error"/>
            </div>

            <div>
                <input type="submit" value="Register"/>
            </div>

        </form:form>
    </div>
</body>
</html>

