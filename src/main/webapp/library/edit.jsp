<%--
  Created by IntelliJ IDEA.
  User: allan
  Date: 25/06/2023
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="java.util.List" %>
<%@ page import="ifpr.web.controledebiblioteca.domains.enums.BookStatus" %>
<%@ page import="ifpr.web.controledebiblioteca.domains.models.Book" %>
<%@ page import="ifpr.web.controledebiblioteca.domains.models.Author" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

    <title>Edit Book</title>
</head>
<body>

<%
    List<BookStatus> bookStatus = (List<BookStatus>) request.getAttribute("status");
    Book book = (Book) request.getAttribute("book");
    Author author = (Author) request.getAttribute("author");
%>

<%@include file="../navbar.jsp"%>
<% if (isAdmin) {%>
<div class="container">


    <br>

    <h1><%= "Book Edit" %></h1>

    <br>

    <div class="border rounded p-4">
        <h4 class="mb-3"></h4>
        <form action="/book/edit?id=<%=book.getId()%>" method="POST">
            <div class="form-group">
                <label for="name">Book Name:</label>
                <input type="text" class="form-control" name="name" id="name" placeholder="Book name" value="<%= book.getName() %>">
            </div>
            <br>
            <div class="form-group">
                <label for="authorName">Author Name:</label>
                <input type="text" class="form-control" name="authorName" id="authorName" placeholder="Author name" value="<%= author.getName() %>">
            </div>
            <br>
            <div class="form-group">
                <label for="status">Status</label>
                <select class="custom-select" name="status" id="status">
                    <option selected="selected"><%= book.getBookStatus() %></option>
                    <% for (BookStatus status : bookStatus) { %>

                    <% if (!status.equals(book.getBookStatus())){%>
                    <option value="<%= status %>"><%= status %></option>
                    <%}%>

                    <% } %>
                </select>
            </div>

            <br>

            <button type="submit" class="btn btn-success">Save</button>

        </form>
    </div>

</div>

<%}%>

<!-- Scripts -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

</body>
</html>