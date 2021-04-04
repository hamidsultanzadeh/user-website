<%--
  Created by IntelliJ IDEA.
  User: hamid
  Date: 14.03.21
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.webperside.user_website.jpa.model.Skill" %>
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
            <label for="exampleInputEmail12" class="form-label">Email</label>
            <input type="text" class="form-control" id="exampleInputEmail12" name="email">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword12" class="form-label">Password</label>
            <input type="text" class="form-control" id="exampleInputPassword12" name="password">
        </div>
        <div class="mb-3" id="skill-power-div">

        </div>
        <div class="mb-3">
            <select onclick="createSkillAndPowerDiv()"
                    id="select-skill"
                    class="form-select" aria-label="Default select example">
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

<script>

    function deleteSkill(id) {
        document.getElementById(id).remove()
    }

    function createSkillAndPowerDiv() {

        const selectSkill = document.getElementById("select-skill");
        const skillId = selectSkill.options[selectSkill.selectedIndex].value
        const skillName = selectSkill.options[selectSkill.selectedIndex].innerText

        console.log(skillId, skillName)
        const root = document.createElement("div");
        root.id = skillId.trim() + skillName.trim();

        const input = document.createElement("input");
        input.setAttribute("name", "skillId[]")
        input.hidden = true;
        input.setAttribute("value",skillId)

        const label = document.createElement("span");
        label.innerText = skillName;

        const input2 = document.createElement("input");
        input2.setAttribute("name", "power[]")

        const button = document.createElement("button");
        button.innerText = "Delete"
        button.type="button";
        button.onclick = function () {
            deleteSkill(root.id);
        };

        const skillPowerDiv = document.getElementById("skill-power-div");

        root.append(input, label, input2, button)

        skillPowerDiv.append(root);
    }
</script>

</body>
</html>