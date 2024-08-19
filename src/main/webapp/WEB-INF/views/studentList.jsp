<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student List</title>
</head>
<body>
    <h2>Registered Students</h2>
    <table border="1">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Enrollment Number</th>
            <th>Phone Number</th>
            <th>Aggregate Percentage</th>
            <th>Gender</th>
            <th>Email</th>
        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.firstName}</td>
                <td>${student.lastName}</td>
                <td>${student.enrollmentNo}</td>
                <td>${student.phoneNumber}</td>
                <td>${student.aggregatePercentage}</td>
                <td>${student.gender}</td>
                <td>${student.email}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
