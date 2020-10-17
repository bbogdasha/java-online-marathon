<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.softserve.itacademy.model.Task" %>
<html>
<head>
    <title>Edit existing Task</title>
</head>
<body>
    <%@include file="menu.html"%>
    <h1>Edit existing Task</h1>

    <%
        Task task = (Task) request.getAttribute("task");
    %>

    <form action="/edit-task" method="post">
        <table>
            <tr>
                <td><label for="Id">Id: </label></td>
                <td><input type="text" id="id" name="id" value="<%=task.getId()%>" disabled></td>
            </tr>
            <tr>
                <td><label for="title">Name: </label></td>
                <td><input type="text" id="title" name="title" value="<%=task.getTitle()%>"></td>
            </tr>
            <tr>
                <td><label for="priority">Name:</label>Priority: </td>
                <td>
                    <select id="priority" name="priority" value="<%=task.getPriority()%>">
                        <option value="LOW">Low</option>
                        <option value="MEDIUM">Medium</option>
                        <option value="HIGH">High</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Edit"></td>
                <td><input type="reset" value="Reset"></td>
            </tr>
        </table>
    </form>
</body>
</html>