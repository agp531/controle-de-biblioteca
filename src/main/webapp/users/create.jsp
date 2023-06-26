<%--
  Created by IntelliJ IDEA.
  User: allan
  Date: 25/06/2023
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="ifpr.web.controledebiblioteca.domains.enums.TypeUsers" %>
<%@ page import="java.lang.reflect.Type" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

  <title>Cadastro de Usuarios</title>
</head>
<body>

<%
  List<TypeUsers> typeUsers = (List<TypeUsers>) request.getAttribute("type");
%>

<%@include file="../navbar.jsp"%>
<div class="container">
  <% if (isAdmin){%>
  <br>
  <h1>Cadastrar Usuario</h1>
  <br>

  <div class="border rounded p-4">
    <h4 class="mb-3"></h4>
    <form action="/user/create" method="POST">
      <div class="form-group">
        <label for="name">Nome do Usuario:</label>
        <input type="text" class="form-control" name="name" id="name" placeholder="Nome do Usuario">
      </div>
      <br>
      <div class="form-group">
        <label for="email">Email:</label>
        <input type="text" class="form-control" name="email" id="email" placeholder="email@email.com">
      </div>
      <br>
      <div class="form-group">
        <label for="type">Tipo:</label>
        <select class="custom-select" name="type" id="type">
          <% for (TypeUsers type : typeUsers) { %>
          <option value="<%= type %>"><%= type %></option>
          <% } %>
        </select>
      </div>
      <br>
      <div class="form-group">
        <label for="password">Email:</label>
        <input type="password" class="form-control" name="password" id="password" placeholder="password">
      </div>


      <br>

      <button type="submit" class="btn btn-success">Salvar</button>

    </form>
  </div>
  <%}else{%>
  <div class="p-3 text-primary-emphasis bg-primary-subtle border border-primary-subtle rounded-3">
    Only admin can create new user!
  </div>
  <%}%>
</div>





<!-- Scripts -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

</body>
</html>