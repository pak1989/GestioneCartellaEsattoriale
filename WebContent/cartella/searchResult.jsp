<%@page import="it.prova.gescaresa.model.Contribuente"%>
<%@page import="it.prova.gescaresa.model.CartellaEsattoriale"%>
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
	  <h3>Cartelle Esattoriali Risultato</h3>
	</div>
  	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Denominazione</th>
				<th>Descrizione</th>
				<th>Importo</th>
				<th>Contribuente</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:forEach items="${listaCartelleAttributeName}" var="elemCartella">
			<tr>
				<td>${elemCartella.denominazione}</td>
				<td>${elemCartella.descrizione}</td>
				<td>${elemCartella.importo}</td>
				<td>${elemCartella.contribuente.nome}</td>
				<td>
					<a href="DettaglioCartellaServlet?idCartella=${elemCartella.id}" class="btn btn-info">Dettaglio</a>
					<a href="PrepareModificaCartellaServlet?idCartella=${elemCartella.id}" class="btn btn-info">Modifica</a>
					<a href="PrepareEliminaCartellaServlet?idCartella=${elemCartella.id}" class="btn btn-danger">Elimina</a>
				</td>
			</tr>
		</c:forEach>
	
	</table>
	<a href="PrepareInsertContribuenteServlet" class="btn btn-info">Inserisci Nuovo Contribuente</a>

	</div>
</body>
</html>