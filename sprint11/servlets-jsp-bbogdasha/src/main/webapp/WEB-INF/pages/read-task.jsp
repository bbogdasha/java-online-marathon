<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.softserve.itacademy.model.Task" %>
<html>
<head>
    <title>Read existing Task</title>
</head>
<body>
    <%@include file="menu.html"%>
    <h1>Read existing Task</h1>

    <%
        Task task = (Task) request.getAttribute("task");
    %>

    <table>
        <tr>
            <td>Id: </td>
            <td><b><%=task.getId()%></b></td>
        </tr>
        <tr>
            <td>Title: </td>
            <td><b><%=task.getTitle()%></b></td>
        </tr>
        <tr>
            <td>Priority: </td>
            <td><b><%=task.getPriority()%></b></td>
        </tr>
    </table>
</body>
</html>