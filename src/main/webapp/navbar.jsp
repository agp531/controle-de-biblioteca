<%@ page import="ifpr.web.controledebiblioteca.domains.models.User" %>
<%@ page import="ifpr.web.controledebiblioteca.domains.enums.TypeUsers" %><%--
  Created by IntelliJ IDEA.
  User: allan
  Date: 25/06/2023
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
  User currentUser = (User) request.getSession().getAttribute("user");
  boolean isAdmin = false;
  if (currentUser.getType().equals(TypeUsers.ADMIN)) {
    isAdmin = true;
  }
  String mensagem = (String) request.getAttribute("mensagem");
%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container" style="background-color: #d8ffdc">
    <a class="navbar-brand" href="/library">
      <img src="https://scv.ifpr.edu.br/img/logo_ifpr.png" alt="Inicio">
    </a>

    <div>
      <a class="nav-link" href="/library">Books</a>
    </div>


    <div class="navbar-collapse justify-content-end">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link"><b><%= currentUser.getName()%></b></a>
        </li>

        <li class="nav-item">
          <a class="nav-link" href="/logout"><i class="fas fa-sign-out-alt"></i> Sair</a>
        </li>

        <% if (isAdmin){%>
        <li class="nav-item">
          <a class="nav-link" href="/users"><i class="fas fa-cog"></i> Users</a>
        </li>
        <%}%>
      </ul>
    </div>
  </div>
</nav>

<% if (mensagem != null && !mensagem.isEmpty()) { %>
<div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="myModalLabel">Aviso</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <%= mensagem %>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
      </div>
    </div>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script>
  $(document).ready(function() {
    $('#myModal').modal('show');
  });
</script>
<% } %>
