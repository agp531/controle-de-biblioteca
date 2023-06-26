<%--
  Created by IntelliJ IDEA.
  User: allan
  Date: 25/06/2023
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
  <style>
    body {
      background-image: url("https://uploaddeimagens.com.br/images/004/519/562/full/colecao-abundante-de-livros-antigos-em-prateleiras-de-madeira-geradas-por-ia.jpg?1687718572");
      background-repeat: revert;
      background-clip: border-box;
      background-size: cover;
      background-position: center;
      background-attachment: fixed;
    }

    .login-container {
      background-color: grey;
      opacity: 0.9;
      padding: 30px;
      border-radius: 10px;
      box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.1);
      margin: auto;
      margin-top: 100px;
      max-width: 400px;
    }

  </style>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

  <title>Página de login</title>
</head>
<body>

<div class="container">

  <div class="login-container">
    <h1 class="text-center mb-4">Login</h1>
    <form method="POST" action="/login">
      <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" class="form-control" id="email" name="email">
      </div>
      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" class="form-control" id="password" name="password">
      </div>
      <button type="submit" class="btn btn-primary btn-block">Login</button>
    </form>
    <small class="text-muted mt-3">Don't have account? contact <b>Charles!</b></small>
  </div>
</div>

<script>
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</script>


</body>
</html>
