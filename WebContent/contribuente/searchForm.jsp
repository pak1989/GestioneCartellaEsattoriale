<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca Contribuente</title>
</head>
<body>

<div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Pagina di Ricerca Contribuente</h3>
	</div>

      	<form id="form" class="form-horizontal" action="ExecuteSearchContribuenteServlet" method="post">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId" name="nomeInput" >
			 	</div>
  			</div>
  			
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId" name="cognomeInput" >
			 	</div>
  			</div>
  			
			<div class="form-group">
      			<label class="control-label col-sm-2" for="etaInputId">Eta':</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="number" id="etaInputId" name="etaInput" >
			 	</div>
  			</div>  	
  					
			<div class="form-group">
      			<label class="control-label col-sm-2" for="residenzaInputId">Residenza:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="residenzaInputId" name="residenzaInput" >
			 	</div>
  			</div>
  			
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Effetua Ricerca</button>
		        <a href="PrepareInsertContribuenteServlet" class="btn btn-primary btn-md">Inserisci Nuovo Contribuente</a>
		      </div>
		    </div>
		</form>
		
    </div>

<script type="text/javascript">
 var frmvalidator  = new Validator("form");
 frmvalidator.addValidation("nomeInputId","alphabetic_space","Solo caratteri alfabetici!");
 frmvalidator.addValidation("cognomeInputId","alphabetic_space","Solo caratteri alfabetici!");
 frmvalidator.addValidation("etaInputId","numeric","Solo caratteri numerici!");
 frmvalidator.addValidation("etaInputId","gt=0","Inserisci un numero valido!");
 frmvalidator.addValidation("etaInputId","lt=120","Inserisci un numero valido!");
</script>

</body>
</html>