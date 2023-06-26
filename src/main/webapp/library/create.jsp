<%--
  Created by IntelliJ IDEA.
  User: allan
  Date: 25/06/2023
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="ifpr.web.controledebiblioteca.domains.models.Author" %>
<%@ page import="ifpr.web.controledebiblioteca.domains.enums.BookStatus" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

    <title>Cadastro de Livros</title>
</head>
<body>

<%
    List<BookStatus> bookStatus = (List<BookStatus>) request.getAttribute("bookStatus");
%>

<%@include file="../navbar.jsp"%>
<div class="container">

    <br>
    <h1><%= "Novo livro." %></h1>
    <br>
    <div class="border rounded p-4">
        <h4 class="mb-3"></h4>
        <form action="/book/create" method="POST">
            <div class="form-group">
                <label for="name">Book name:</label>
                <input type="text" class="form-control" name="name" id="name" placeholder="Book name">
            </div>
            <br>
            <div class="form-group">
                <label for="authorName">Autor</label>
                <input type="text" class="form-control" name="authorName" id="authorName" placeholder="Author name">
            </div>
            <br>
            <div class="form-group">
                <label for="status">Status</label>
                <select class="custom-select" name="status" id="status">
                    <% for (BookStatus bookStatus1 : bookStatus) { %>
                    <option value="<%= bookStatus1 %>"><%= bookStatus1 %></option>
                    <% } %>
                </select>
            </div>

            <br>

            <button type="submit" class="btn btn-success">Salvar</button>

        </form>
    </div>



</div>






<!-- Scripts -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

</body>
</html>
