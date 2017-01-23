
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Create User</title>
</head>
<body>
<h3>Create User:</h3>
<hr color="blue"/>
<br>
<br>
<form action="${pageContext.servletContext.contextPath}/view/create" method="post">
<table>
  <tr>
    <td align="right">USER NAME :</td>
    <td><input type="text" name="name"></td>
  </tr>
  <tr>
    <td align="right">USER AGE :</td>
    <td><input type="text" name="age"> </td>
  </tr>
  <tr>
    <td align="right">USER IS ADMIN :</td>
   <td>
     <select required size="1" name="isAdmin">
      <option value="${true}">Yes</option>
      <option value="${false}">No</option>
    </select>
    </td>
  </tr>
  <tr>
     <td><input type="submit" align="center" value="Submit"></td>
  </tr>
</table>
</form>
</body>
</html>
