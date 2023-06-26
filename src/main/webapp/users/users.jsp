<%@ page import="ifpr.web.controledebiblioteca.domains.models.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: allan
  Date: 25/06/2023
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Users</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
<body>

    <%
      List<User> users = (List<User>) request.getAttribute("users");
    %>

    <%@include file="../navbar.jsp"%>

    <% if (isAdmin) {%>
    <div class="container">

        <h1>Users</h1>

        <% if (isAdmin) {%>
        <div class="table-toolbar">
            <a class="btn btn-primary" href="/user/create"><i class="fas fa-plus"></i> New User</a>
        </div>
        <%}%>
        <br>

        <table class="table table-bordered rounded">
            <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Type</th>
                <th>Options</th>
            </tr>
            </thead>
            <tbody>
            <% if (users != null && !users.isEmpty()) { %>
            <% for (User user : users) { %>
            <tr>
                <td><%= user.getName() %></td>
                <td><%= user.getEmail() %></td>
                <td><%= user.getType() %></td>
                <td>
                    <a href="/delete?id=<%=user.getId()%>" class="btn btn-danger btn-sm"><i class="fa fa-trash">delete</i></a>
                </td>
            </tr>
            <%}%>
            <%}%>
            </tbody>
        </table>
    </div>
    <%}%>
</body>
</html>