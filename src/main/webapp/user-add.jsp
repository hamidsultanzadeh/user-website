<%--
  Created by IntelliJ IDEA.
  User: hamid
  Date: 14.03.21
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.webperside.user_website.model.User" %>
<%@ page import="com.webperside.user_website.dao.inter.UserDao" %>
<%@ page import="com.webperside.user_website.config.Context" %>
<%@ page import="java.util.List" %>
<%@ page import="com.webperside.user_website.model.Skill" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User add</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
</head>
<body>
<%
    List<Skill> skills = (List<Skill>) request.getAttribute("skills");
%>
<div class="container">
    <form action="user-add" method="post">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Name</label>
            <input type="text" class="form-control" id="exampleInputEmail1" name="name">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Surname</label>
            <input type="text" class="form-control" id="exampleInputPassword1" name="surname">
        </div>
        <div class="mb-3">
            <select name="skillId" class="form-select" aria-label="Default select example">
                <option selected>Select an skill</option>
                <%
                    for(Skill skill : skills){
                %>
                <option value="<%=skill.getSkillId()%>"><%=skill.getName()%></option>
                <%
                    }
                %>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>


</body>
</html>