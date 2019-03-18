<%@page import="it.prova.gescaresa.model.Contribuente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettaglio Contribuente</title>
</head>
<body>


	<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Dettaglio</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Azioni</dt>
					<dd class="col-sm-9">
						<a href="PrepareModificaContribuenteServlet?idContribuente=${contribuenteAttributeName.id}" class="btn btn-info">Modifica</a>
						<a href="PrepareEliminaContribuenteServlet?idContribuente=${contribuenteAttributeName.id}" class="btn btn-danger">Elimina</a>
					</dd>
			</dl>
			<hr>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9">${contribuenteAttributeName.nome}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cognome</dt>
				<dd class="col-sm-9">${contribuenteAttributeName.cognome}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Eta'</dt>
				<dd class="col-sm-9">${contribuenteAttributeName.eta}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Residenza</dt>
				<dd class="col-sm-9">${contribuenteAttributeName.residenza}</dd>
			</dl>							
			<hr>
<%-- 			<c:if test="${contribuenteAttributeName.cartelleEsattoriali != null}"> --%>
				<c:forEach items="${contribuenteAttributeName.cartelleEsattoriali}" var="elemCartelleEsatt">
					<dl class="row">
						<dt class="col-sm-3 text-right">Cartella id ${elemCartelleEsatt.id}</dt>
						<dd class="col-sm-9"><a href="DettaglioCartellaServlet?idCartella=${elemCartelleEsatt.id}" class="btn btn-info">Dettagli</a>  ${elemCartelleEsatt.descrizione}</dd>
					</dl>
				</c:forEach>
<%-- 			</c:if> --%>
			
		</div>

	</div>

</body>
</html>