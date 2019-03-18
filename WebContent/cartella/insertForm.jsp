<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserimento nuova Cartella Esattoriale</title>
<script>
function campiPieni(){
 var denominazione = document.getElementById('denominazioneInputId').value.trim();
 var descrizione = document.getElementById('descrizioneInputId').value.trim();
 var importo = document.getElementById('importoInputId').value.trim();
 if(denominazione == "" || descrizione == "" || importo == ""){
	alert("Riempire tutti i campi!");
	return false;
 }
 return true;
}
</script>
</head>
<body>

<div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Pagina di Inserimento nuova Cartella Esattoriale</h3>
	</div>
	
	<c:forEach var="messaggioItem" items="${messaggiErrore}">
		<div class="alert alert-danger" role="alert">
		  ${messaggioItem}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
	</c:forEach>
	
		<form class="form-horizontal" onsubmit="return campiPieni()" action="ExecuteInsertCartellaServlet" method="post">
		
			<div class="form-group">
				<label class="control-label col-sm-2" for="municipioInputId">Contribuente:</label>
					<div class="col-sm-4">
						<select class="form-control" id="contribuenteIdInputId" name="contribuenteIdInput">
								<option value="0">Seleziona contribuente</option>
								<c:forEach items="${listaContribuentiAttributeName}" var="elemContribuente">
									<%String selected = "";%>
									<c:if test="${elemContribuente.id == cartellaDto.contribuente.id}">
										<%selected = "selected='selected'";%>
									</c:if>
										<option value="<c:out value = "${elemContribuente.id}"/>" <%= selected%>><c:out value = "${elemContribuente.nome} ${elemContribuente.cognome}"/></option>
								</c:forEach>
						</select>
					</div>	
			</div>	

      		<div class="form-group">
      			<label class="control-label col-sm-2" for="denominazioneInputId">Denominazione:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="denominazioneInputId" name="denominazioneInput" value="${cartellaDto.denominazione}">
			 	</div>
  			</div>
  			
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId" name="descrizioneInput" value="${cartellaDto.descrizione}">
			 	</div>
  			</div>
  			
			<div class="form-group">
      			<label class="control-label col-sm-2" for="importoInputId">Importo:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="number" id="importoInputId" name="importoInput" value="${cartellaDto.importo}">
			 	</div>
  			</div>  	
  					
  			
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Inserisci</button>
		      </div>
		    </div>
		</form>
		
    </div><!-- /.container -->



</body>
</html>