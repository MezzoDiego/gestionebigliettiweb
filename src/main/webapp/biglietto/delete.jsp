<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Eliminazione biglietto</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  <br><br>
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Sicuro di voler eliminare questo biglietto?</h5>
					    </div>
					
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Provenienza:</dt>
							  <dd class="col-sm-9">${bigliettoDaEliminare.provenienza}</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Destinazione:</dt>
							  <dd class="col-sm-9">${bigliettoDaEliminare.destinazione}</dd>
					    	</dl>
					    	<fmt:formatDate value="${bigliettoDaEliminare.data}" pattern="dd-MM-yyyy" var="dataFormatted"/>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data:</dt>
							  <dd class="col-sm-9">${dataFormatted}</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Prezzo:</dt>
							  <dd class="col-sm-9">${bigliettoDaEliminare.prezzo}</dd>
					    	</dl>
					    	
					    </div>
					    <form action="${pageContext.request.contextPath }/admin/ExecuteDeleteBigliettoServlet" method="post">
					    <div class='card-footer'>
					        <a href="${pageContext.request.contextPath }/ListBigliettiServlet" class='btn btn-outline-secondary' style='width:80px'>
					            <i class='fa fa-chevron-left'></i> Back
					        </a>
					         
					         		<input type="submit" class="btn btn-danger" value="Rimuovi">
					         		<input type="hidden" name="idDaInviareComeParametro" value="${bigliettoDaEliminare.id}">
					         </form>
					    </div>
					<!-- end card -->
					</div>	
			  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />
	  </body>
</html>