<%@ page import="com.webperside.user_website.model.User" %><%--
  Created by IntelliJ IDEA.
  User: hamid
  Date: 14.03.21
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

</head>
<body>
<%
    User u =(User) request.getAttribute("user");
%>
<div class="container">
    <form action="user-edit" method="post">
        <input type="hidden" value="update" name="action">
        <input type="hidden" value="<%=u.getUserId()%>" name="id">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Name</label>
            <input type="text" class="form-control" id="exampleInputEmail1" name="name"
            value = <%="'"+u.getName()+"'"%>>
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Surname</label>
            <input type="text" class="form-control" id="exampleInputPassword1" name="surname"
            value = <%="'"+u.getSurname()+"'"%>>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>

</body>
</html>
