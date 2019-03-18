<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica Utente</title>
<script>
function campiPieni(){
 var nome = document.getElementById('nomeInputId').value.trim();
 var cognome = document.getElementById('cognomeInputId').value.trim();
 var username = document.getElementById('usernameInputId').value.trim();
 if(nome == "" || cognome == "" || username == ""){
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
	  <h3>Pagina di Modifica Utente</h3>
	</div>
	
	<c:forEach var="messaggioItem" items="${messaggiErrore}">
		<div class="alert alert-danger" role="alert">
		  ${messaggioItem}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
	</c:forEach>
	
		<form class="form-horizontal" onsubmit="return campiPieni()" action="ExecuteModificaUtenteServlet" method="post">
		
	      	<div class="form-group">
      			<label class="control-label col-sm-2" for="idInputId"></label>
	    		<div class="col-sm-4">
					<input class="form-control"  type="hidden" id="idInputId" name="idInput" value="${utenteAttributeName.id}${utenteDto.id}">
			 	</div>
  			</div>

      		<div class="form-group">
      			<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId" name="nomeInput" value="${utenteAttributeName.nome}${utenteDto.nome}">
			 	</div>
  			</div>
  			
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId" name="cognomeInput" value="${utenteAttributeName.cognome}${utenteDto.cognome}">
			 	</div>
  			</div>
  			
			<div class="form-group">
      			<label class="control-label col-sm-2" for="usernameInputId">Username:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="usernameInputId" name="usernameInput" value="${utenteAttributeName.username}${utenteDto.username}">
			 	</div>
  			</div>  	
  					
			<div class="form-group">
      			<label class="control-label col-sm-2" for="passwordInputId">Passsword:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="passwordInputId" name="passwordInput" value="${utenteAttributeName.password}${utenteDto.password}">
			 	</div>
  			</div>

			<div class="form-group">
				<div class="col-sm-4">
				    <label for="ruoliInputID">Seleziona ruoli:</label>
				    <select multiple class="form-control" id="ruoliInputID" name="ruoliInput" >    
						<c:forEach items="${utenteAttributeName.ruoli}" var="ruolo">
		      					<option value="1" ${ruolo.id==1?"selected='selected'":"" }>Admin</option>
		      					<option value="2" ${ruolo.id==2?"selected='selected'":"" }>User</option>
		      					<option value="3" ${ruolo.id==3?"selected='selected'":"" }>Guest</option>
						</c:forEach>
				    </select>
				  </div>
			</div>
			
	
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Modifica</button>
		      </div>
		    </div>
		</form>
		
    </div><!-- /.container -->

</body>
</html>