<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Table of all users</title>
</head>
<body>
<h3>All Users:</h3>
<hr color="blue"/>
<br>
<br>
<a href="${pageContext.servletContext.contextPath}/view/find">Find User</a>
<br>
<br>
<table border="1">
<tr>
    <td>ID</td>
    <td>NAME</td>
    <td>AGE</td>
    <td>ADMIN</td>
    <td>CREATE DATE</td>
    <td>ACTION</td>
</tr>
<c:forEach items="${users}" var="user" varStatus="status">
    <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.age}</td>
        <td>
            <c:if test="${user.getIsAdmin()}">yes</c:if>
            <c:if test="${!user.getIsAdmin()}">no</c:if>
        </td>
        <td>${user.getCreateDateString()}</td>
        <td>
            <a href="${pageContext.servletContext.contextPath}/view/edit?id=${user.id}">Edit</a>
            <a href="${pageContext.servletContext.contextPath}/view/delete?id=${user.id}">Delete</a>
        </td>
    </tr>
</c:forEach>
</table>
<br>
<a href="${pageContext.servletContext.contextPath}/view/CreateUser.jsp">ADD USER</a>


</body>
</html>
