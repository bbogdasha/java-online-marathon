<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.softserve.itacademy.model.Task" %>
<%@ page import="java.util.List" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.softserve.itacademy.model.Priority" %>
<html>
<head>
    <title>Create new Task</title>
</head>
<body>
    <%@include file="menu.html"%>
    <h1>Create new Task</h1>

    <p>${message}</p>

    <form action="/create-task" method="post">
        <table>
            <tr>
                <td><label for="title">Name: </label></td>
                <td><input type="text" id="title" name="title" required></td>
            </tr>
            <tr>
                <td><label for="priority">Priority:</label></td>
                <td>
                    <select name="priority" id="priority">
                    <%
                        for(Priority priority : Priority.values()) {
                            if(priority.name().equals(task.getPriority().name())) {
                    %>
                    <option selected><%priority.name().charAt(0) + priority.name().substring(1).toLowerCase()%></option>
                    <%
                            } else {
                    %>
                    <option><%priority.name().charAt(0) + priority.name().substring(1).toLowerCase()%></option>
                    <%
                            }
                        }
                    %>
                    </select>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Create"></td>
                <td><input type="reset" value="Reset"></td>
            </tr>
        </table>
    </form>
</body>
</html>