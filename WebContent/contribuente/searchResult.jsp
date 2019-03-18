<%@page import="it.prova.gescaresa.model.Contribuente"%>
<%@page import="java.util.List"%>
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
				<th>Eta'</th>
				<th>Residenza</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:forEach items="${listaContribuentiAttributeName}" var="elemContribuente">
			<tr>
				<td>${elemContribuente.nome}</td>
				<td>${elemContribuente.cognome}</td>
				<td>${elemContribuente.eta}</td>
				<td>${elemContribuente.residenza}</td>
				<td>
					<a href="DettaglioContribuenteServlet?idContribuente=${elemContribuente.id}" class="btn btn-info">Dettaglio</a>
					<a href="PrepareModificaContribuenteServlet?idContribuente=${elemContribuente.id}" class="btn btn-info">Modifica</a>
					<a href="PrepareEliminaContribuenteServlet?idContribuente=${elemContribuente.id}" class="btn btn-danger">Elimina</a>
				</td>
			</tr>
		</c:forEach>
	
	</table>
	<a href="PrepareInsertContribuenteServlet" class="btn btn-info">Inserisci Nuovo Contribuente</a>

	</div>
</body>
</html>