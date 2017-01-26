
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Find User</title>
</head>
<body>
<h3>Find User :</h3>
<hr color="blue"/>
<br>
<br>
<a href="${pageContext.servletContext.contextPath}/">All Users</a>
<br>
Enter name of user fo search
<br>
<form action="${pageContext.servletContext.contextPath}/view/find" method="post">
  <table>
    <tr>
      <td align="right">USER NAME</td>
      <td>
        <input type="text" name="name">
      </td>
    </tr>
    <tr>
      <td>
        <input type="submit" align="center" value="Submit">
      </td>
    </tr>
  </table>
</form>
<br>
<br>
<h4>Finded Users</h4>
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
  <c:forEach items="${findUsers}" var="user" varStatus="status">
    <tr>
      <td>${user.id}</td>
      <td>${user.name}</td>
      <td>${user.age}</td>
      <td>
        <c:if test="${user.isAdmin()}">yes</c:if>
        <c:if test="${!user.isAdmin()}">no</c:if>
      </td>
      <td>${user.getCreateDateString()}</td>
      <td>
        <a href="${pageContext.servletContext.contextPath}/view/edit?id=${user.id}">Edit</a>
        <a href="${pageContext.servletContext.contextPath}/view/delete?id=${user.id}">Delete</a>
      </td>
    </tr>
  </c:forEach>
</table>


</body>
</html>
