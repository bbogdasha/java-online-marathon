<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.softserve.itacademy.model.Task" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>List of Tasks</title>
</head>
<body>
    <%@include file="menu.html"%>
    <h1>List of Tasks</h1>

    <table border="1">
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Priority</th>
            <th colspan="3">Operation</th>
        </tr>

        <%
            for (Task task : (List<Task>) request.getAttribute("tasks")) {
        %>

        <tr>
            <td><%=task.getId()%></td>
            <td><%=task.getTitle()%></td>
            <td><%=task.getPriority()%></td>
            <td><a href="/read-task?id=<%=task.getId()%>">Read</a></td>
            <td><a href="/edit-task?id=<%=task.getId()%>">Update</a></td>
            <td><a href="/delete-task?id=<%=task.getId()%>">Delete</a></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>