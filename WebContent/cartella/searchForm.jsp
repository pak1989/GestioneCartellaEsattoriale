<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca Cartella Esattoriale</title>
</head>
<body>

<div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Pagina di Ricerca Cartella Esattoriale</h3>
	</div>
      	<form class="form-horizontal" action="ExecuteSearchCartellaServlet" method="post">
			<div class="col-sm-4">
				<select class="form-control" id="contribuenteIdInputId"
					name="contribuenteIdInput">
					<option value="0">Contribuente</option>
						<c:forEach items="${listaContribuentiAttributeName}" var="elemContribuente">
							<option value="<c:out value = "${elemContribuente.id}"/>"><c:out value = "${elemContribuente.nome}"/></option>
						</c:forEach>
				</select>
			</div>
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="denominazioneInputId">Denominazione:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="denominazioneInputId" name="denominazioneInput" >
			 	</div>
  			</div>
  			
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId" name="descrizioneInput" >
			 	</div>
  			</div>
  			
			<div class="form-group">
      			<label class="control-label col-sm-2" for="importoInputId">Importo:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="number" id="importoInputId" name="importoInput" >
			 	</div>
  			</div>  	
  			
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Effetua Ricerca</button>
		        <a href="PrepareInsertCartellaServlet" class="btn btn-primary btn-md">Inserisci Nuova Cartella Esattoriale</a>
		      </div>
		    </div>
		</form>
		
    </div><!-- /.container -->



</body>
</html>