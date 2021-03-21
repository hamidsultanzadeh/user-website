<%@ page import="com.webperside.user_website.dao.inter.UserDao" %>
<%@ page import="com.webperside.user_website.model.User" %>
<%@ page import="com.webperside.user_website.config.Context" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hamid
  Date: 14.03.21
  Time: 13:53
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
    List<User> users =(List<User>) request.getAttribute("alma");
%>

<div class="container">
    <form action="users" method="get">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Name</label>
            <input type="text" class="form-control" id="exampleInputEmail1" name="name">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Surname</label>
            <input type="text" class="form-control" id="exampleInputPassword1" name="surname">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Surname</th>
            <th scope="col">Operation</th>
        </tr>
        </thead>
        <tbody>
        <%
            for(int i = 0 ; i < users.size() ; i++){
                User u = users.get(i);
        %>
        <tr>
            <th scope="row"><%=(i+1)%></th>
            <td><%=u.getUserId()%></td>
            <td><%=u.getName()%></td>
            <td><%=u.getSurname()%></td>
            <td>
                <a href="user-edit?id=<%=u.getUserId()%>" class="btn btn-info" >Update</a>
                <button class="btn btn-danger"
                        data-bs-toggle="modal"
                        data-bs-target="#exampleModal"
                        onclick="setIdForDelete(<%=u.getUserId()%>)">Delete</button>
            </td>
        </tr>
        <%
            }
        %>

        </tbody>
    </table>

    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Are you sure to delete user?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <form method="post" action="user-edit">
                        <input name="action" value="delete" type="hidden">
                        <input type="hidden" id="userIdForDelete" name="id" value="">
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<script>
    function setIdForDelete(id){
        var inp = document.getElementById("userIdForDelete");
        inp.value = id
    }
</script>

</body>
</html>
