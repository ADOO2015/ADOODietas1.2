<%@page import = 
    "pojos.Cita,
    pojos.Usuario,
    modelo.AccessUsuarioDAO,
    modelo.UsuarioDAO,
    controlador.AccessUser,
    java.util.ArrayList,
    modelo.CitaNutriologoDAO"%>
    <%!
    	Usuario user;
    %>
    <%
    user = (Usuario) session.getAttribute("Usuario");
    %>
    <%HttpSession sesion = request.getSession();
    	Usuario a = new Usuario();
    	a = (Usuario)sesion.getAttribute("Usuario");
    	String nombre = a.getNombre();
    	
    	String idPac=String.valueOf(request.getParameter("idPac"));
    	
    	CitaNutriologoDAO citaNutDAO = new CitaNutriologoDAO();
    	ArrayList<Cita> citas = citaNutDAO.obtenerCitas(Integer.parseInt(a.getId()), Integer.parseInt(idPac),true);
    	ArrayList<Cita> citasAll = citaNutDAO.obtenerCitas(Integer.parseInt(a.getId()), Integer.parseInt(idPac),false);
    %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="js/Chart.js"></script>
	
	
</head>
<body>
<nav class="navbar navbar-inverse">
          <div class="container-fluid">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Logo</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
          <ul class="nav navbar-nav navbar-right">
              <li><h3><%=nombre%></h3></li>
              <li><a href="CerrarSesion.jsp">Cerrar Sesion</a></li>

          </ul>
      </div>
  </div>
</nav>

<div class="container">
		<div class="row">
			<div class="col-md-12">
			<center>	
				<h1>Citas del Paciente</h1>
				<div></div>
				<div style="width:50%">
				<h3>Hitorial</h3>
					<div>
						<table class = "table table-striped">
							<thead>
								<tr>
									<th>Fecha</th>
									<th>Hora</th>
									<th>Observaciones</th>
								</tr>
							</thead>
								<tbody>
									<%
								        if(citasAll != null){
								        	for(int i = 0; i < citasAll.size(); i++){ 
										%>
										<tr>
								            <td><%=citasAll.get(i).getFecha() %></td>
								            <td><%=citasAll.get(i).getHora() %></td>
								            <td><%=citasAll.get(i).getObservaciones() %></td>
								       	</tr>          		
								        <%
								        	}//End for
								        } else{%>
								        	<tr><td>No tiene citas registradas</td></tr>
								        <%} %>
								</tbody>
						</table>
					</div>
				</div>
				</center>
			</div>
			</div>
			<center>
			<h3>Proximas Citas Agendadas</h3>
				<div>
				<div style="width:50%">
						<table class = "table table-striped">
							<thead>
								<tr>
									
									<th>Fecha</th>
									<th>Hora</th>
									<th>Observaciones</th>
									<th>Eliminar</th>
								</tr>
							</thead>
								<tbody>
									<%
								        if(citas != null){
								        	for(int i = 0; i < citas.size(); i++){ 
										%>
										<tr>
								            <td><%=citas.get(i).getFecha() %></td>
								            <td><%=citas.get(i).getHora() %></td>
								            <td><%=citas.get(i).getObservaciones() %></td>
								            <td><button type="submit" class="btn btn-primary">X</button></td>
								       	</tr>          		
								        <%
								        	}//End for
								        } else{%>
								        	<tr><td>No tiene citas registradas</td></tr>
								        <%} %>
								</tbody>
						</table>
				</div>			
				<h3>AgendarCita</h3>
				</center>
				<div>
						<form class = "form-horizontal" action="/registrarCita" method="post">
							<fieldset>
								<div class="col-lg-1">
								<input class="form-control" id="dia" placeholder="DÌa" type="text" name="dia" required>
								<input class="form-control" id="mes" placeholder="Mes" type="text" name="mes" required>
								<input class="form-control" id="ano" placeholder="AÒo" type="text" name="ano" required>
								<input class="form-control" id="hora" placeholder="Hora (hh:mm)" type="text" name="hora" width="50px" required>
								<textarea id="obs" placeholder="Observaciones de la cita" type="text" name="obs" rows="4" cols="34" required></textarea>
								<input type="hidden" id="idMed" name="idMed" value="<%out.println(a.getId());%>"">
								<input type="hidden" id="idPac" name="idPac" value="<%out.println(idPac);%>">
								</div>
								<div class="form-group">
								<div class="col-lg-10 col-lg-offset-2">
									<button type="submit" class="btn btn-primary">Agendar Cita</button>
								</div>
								</div>
							</fieldset>
						</form>
				</div>

				
		</div> <!-- /row -->

		

</div>	<!-- /container -->



<div class="container" style="margin-top:100px;background:#213029;color:#FFF;width:100%;">

		<div class="row">
			<div class="col-md-12">
			<p style="text-align:center;">Empresa</p>	
			
			</div>
			
		
			
			
		</div> <!-- /row -->
		<hr>
		<div class="row">
			<div class="col-md-4">
					Mas informaci√≥n
			
			</div>
			
		
			<div class="col-md-4">
				Datos legales
			</div>
			
			<div class="col-md-4">
				Conocenos
			</div>
			
		</div> <!-- /row -->

		

</div>	<!-- /container -->



</html>

