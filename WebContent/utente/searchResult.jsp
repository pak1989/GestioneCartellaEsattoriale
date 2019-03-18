<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Risultati</title>
</head>
<body>

	<div class="container">

  	<%@ include file="../header.jsp" %>
  	
  	<div class="page-header">
	  <h3>Contribuenti Risultato</h3>
	</div>
  	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Username</th>
				<th>Data</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:forEach items="${listaUtentiAttributeName}" var="elemUtente">
			<tr>
				<td>${elemUtente.nome}</td>
				<td>${elemUtente.cognome}</td>
				<td>${elemUtente.username}</td>
				<td>${elemUtente.dataRegistrazione}</td>
				<td>
					<a href="DettaglioUtenteServlet?idUtente=${elemUtente.id}" class="btn btn-info">Dettaglio</a>
					<a href="PrepareModificaUtenteServlet?idUtente=${elemUtente.id}" class="btn btn-info">Modifica</a>
					<a href="PrepareEliminaUtenteServlet?idUtente=${elemUtente.id}" class="btn btn-danger">Elimina</a>
				</td>
			</tr>
		</c:forEach>
	
	</table>
	<a href="PrepareInsertUtenteServlet" class="btn btn-info">Inserisci Nuovo Utente</a>

	</div>
</body>
</html>