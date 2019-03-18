<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creazione Contribuente</title>
<script>
	function campiPieni(){
		var nome = document.getElementById('nomeInputId').value;
		var cognome = document.getElementById('cognomeInputId').value;
		var residenza = document.getElementById('residenzaInputId').value;
		var eta = document.getElementById('etaInputId').value;
		if(nome == "" || cognome == "" || residenza == "" || eta == ""){
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
	  <h3>Pagina di Creazione nuovo Contribuente</h3>
	</div>
	
	<c:forEach var="messaggioItem" items="${messaggiErrore}">
		<div class="alert alert-danger" role="alert">
		  ${messaggioItem}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
	</c:forEach>
	

		<form class="form-horizontal" onsubmit="return campiPieni()" action="ExecuteInsertContribuenteServlet" method="post">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId" name="nomeInput" value="${contribuenteDto.nome}">
			 	</div>
  			</div>
  			
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId" name="cognomeInput" value="${contribuenteDto.cognome}">
			 	</div>
  			</div>
  			
			<div class="form-group">
      			<label class="control-label col-sm-2" for="etaInputId">Eta':</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="number" id="etaInputId" name="etaInput" value="${contribuenteDto.eta}">
			 	</div>
  			</div>  	
  					
			<div class="form-group">
      			<label class="control-label col-sm-2" for="residenzaInputId">Residenza:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="residenzaInputId" name="residenzaInput" value="${contribuenteDto.residenza}">
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