<%--
  Created by IntelliJ IDEA.
  User: allan
  Date: 25/06/2023
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="ifpr.web.controledebiblioteca.domains.models.Book" %>
<%@ page import="ifpr.web.controledebiblioteca.domains.models.Author" %>
<%@ page import="ifpr.web.controledebiblioteca.domains.enums.BookStatus" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

  <title>Biblioteca IFPR</title>
</head>
<body>

<%
  List<Book> books = (List<Book>) request.getAttribute("books");
  List<Author> authors = (List<Author>) request.getAttribute("authors");
%>
<%@include file="../navbar.jsp"%>
<div class="container">

  <h1><%="Library."%></h1>
  <br>


  <% if (isAdmin) {%>
  <div class="table-toolbar">
    <a class="btn btn-primary" href="/book/create"><i class="fas fa-plus"></i> New Book</a>
  </div>
  <%}%>


  <br>

  <table class="table table-bordered rounded">
    <thead class="thead-dark">
    <tr>
      <th>Id</th>
      <th>Name</th>
      <th>Creation Date</th>
      <th>Author</th>
      <th>Status</th>
      <th>Options</th>
    </tr>

    </thead>
    <tbody>
    <% for (Book book : books) { %>
    <tr>
      <td><%=book.getId()%></td>
      <td><%=book.getName()%></td>
      <td><%=book.getDate()%></td>
      <td><%=book.getAuthor().getName()%></td>
      <td><%=book.getBookStatus()%></td>
      <td>
        <% if (isAdmin){%>

        <button class="btn btn-danger btn-sm" data-toggle="modal" data-target="#confirmDeleteModal<%= book.getId() %>"><i class="fa fa-trash"></i> Deletar</button>
        <div class="modal fade" id="confirmDeleteModal<%= book.getId() %>" tabindex="-1" role="dialog" aria-labelledby="confirmDeleteModalLabel<%= book.getId() %>" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="confirmDeleteModalLabel<%= book.getId() %>">Confirmar Exclusão</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-body">
                <p>Are you sure you want to delete book " <%=book.getName()%> " ? </p>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <a href="/book/delete?id=<%= book.getId() %>" class="btn btn-danger">Excluir</a>
              </div>
            </div>
          </div>
        </div>

        <a href="/book/edit?id=<%=book.getId()%>" class="btn btn-info btn-sm"><i class="fas fa-pencil-alt"></i> Editar</a>
      </td>
    </tr>
    <%}%>
    <%}%>
    </tbody>
  </table>

</div>

<!-- Scripts -->

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>
</html>