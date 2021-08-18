<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/17/2021
  Time: 9:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<sql:query var="listStudent" dataSource="jdbc/Student">
    select username, fullname from Student
</sql:query>

<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
</head>
<body>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List Of Student</h2></caption>
        <tr>
            <th>Name</th>
            <th>Email</th>
        </tr>
        <c:forEach var="student" items="${listStudent.rows}">
            <tr>
                <td><c:out value="${student.username}"/></td>
                <td><c:out value="${student.fullname}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
