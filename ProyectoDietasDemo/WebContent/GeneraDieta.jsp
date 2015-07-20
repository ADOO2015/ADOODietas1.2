<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="pojos.Usuario" import="pojos.Dieta" import="pojos.AlimentoDieta" import="pojos.Regimen"%>
        <%
  //tipo 1 autorizar pacientes, tipo 2 pcientes del doctor
    HttpSession sesion = request.getSession();
    int tipo;
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <title>Dieta</title>
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
              <li><h3> <%
              		HttpSession s = session;
                   	Usuario user =(Usuario)s.getAttribute("Usuario");
                  	String nombre =user.getNombre();
  	                Dieta d = new Dieta();
                   	if(s.getAttribute("dieta")!= null){
                   		d = (Dieta)s.getAttribute("dieta");
                   	}
                   	Regimen r = new Regimen();
                   	
                  	r = (Regimen)s.getAttribute("regimen");
                   	out.println(nombre);
                    %></h3></li>
              <li><a href="CerrarSesion.jsp">Cerrar Sesion</a></li>

          </ul>
      </div>
  </div>
</nav>
        <div class="container">
            <div class="row">
                    <div class="col-lg-3">
            
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3> <%
                   	
                    out.println(nombre);
                    %></h3>
                    
                </div>
                <div class="panel-body">
                  <div class="list-group">
                   
                    <a href="#" class="list-group-item"><img src="img/iconos/Dieta.svg" id="icn"/> Dieta
                    </a>
                    <a href="MiProgreso" class="list-group-item"><img src="img/iconos/Progreso.svg" id="icn"/> Progreso
                    </a>
                    </a>
                    <a href="historialRegimen" class="list-group-item"><img src="img/iconos/historial.svg" id="icn"/> Historial
                    </a>
                    </a>
                    <a href="#" class="list-group-item"><img src="img/iconos/agenda.svg" id="icn"/> Agenda
                    </a>
                    </a>
                    <a href="#" class="list-group-item"><img src="img/iconos/mensajes.svg" id="icn"/> Mensajes
                    </a>
                    </a>
                    <a href="#" class="list-group-item"><img src="img/iconos/perfil.svg" id="icn"/> Perfil
                    </a>
                </div>
            </div>
           
      </div>
      
  </div>
<div class="row">	
             <div class="col-lg-8">
						<h1>Dieta</h1>
							<%
								if(request.getParameter("aprobada")!= null){
									%>
									<h3>La dieta ha sido aprobada.</h3>
									<%
								}
							%>
                            <div class="jumbotron">
							<table class="table">
							<tr>
							<td>
							<div class="col-md-10">
								<h3><span class="label label-default">Desayuno</span></h3>
							   <div class="panel panel-default">
								<table class="table">
								<%for(AlimentoDieta ad : d.getDesayuno()){ %>
								<tr>
									<td>
										<a href="javascript:nuevoAlimento(<%=ad.getIdAlimento()%>)"><img src="img/iconos/izqui.svg"  style="transform: rotate(90deg);width: 20;"/></a>
									</td>	
									<td><%out.write(ad.getNombre());%></td>
									<td>
										<a href="javascript:nuevoAlimento(<%=ad.getIdAlimento()%>)"><img src="img/iconos/derecha.svg"  style="transform: rotate(-90deg);width: 20;"/></a>
									</td>
								<tr>
								<%} %>
								</table>							  
								</div>
							<h3><span class="label label-default">Refrigerio matutino</span></h3>
							   <div class="panel panel-default">
								<table class="table">
								<%for(AlimentoDieta ad : d.getColacionMatutina()){ %>
								<tr>
									<td>
										<a href="javascript:nuevoAlimento(<%=ad.getIdAlimento()%>)"><img src="img/iconos/izqui.svg"  style="transform: rotate(90deg);width: 20;"/></a>
									</td>
									<td><%out.write(ad.getNombre());%></td>
									<td>
										<a href="javascript:nuevoAlimento(<%=ad.getIdAlimento()%>)"><img src="img/iconos/derecha.svg"  style="transform: rotate(-90deg);width: 20;"/></a>
									</td>
								<tr>
								<%} %>
								</table>							  
								</div>
							<h3><span class="label label-default">Comida</span></h3>
							   <div class="panel panel-default">
								<table class="table">
								<%for(AlimentoDieta ad : d.getComida()){ %>
								<tr>
									<td>
										<a
														href="javascript:nuevoAlimento(<%=ad.getIdAlimento()%>)"><img
															src="img/iconos/izqui.svg"
															style="transform: rotate(90deg); width: 20;" /></a>
													</td>	
									
									<td><%out.write(ad.getNombre());%></td>
									<td>
										<a href="javascript:nuevoAlimento(<%=ad.getIdAlimento()%>)"><img src="img/iconos/derecha.svg"  style="transform: rotate(-90deg);width: 20;"/></a>
									</td>
								<tr>
								<%} %>
								</table>							  
								</div>
							<h3><span class="label label-default">Refrigerio vespertino</span></h3>
							   <div class="panel panel-default">
								<table class="table">
								<%for(AlimentoDieta ad : d.getColacionVespertina()){ %>
								<tr>
									<td>
										<a href="javascript:nuevoAlimento(<%=ad.getIdAlimento()%>)"><img src="img/iconos/izqui.svg"  style="transform: rotate(90deg);width: 20;"/></a>
									</td>	
									
									<td><%out.write(ad.getNombre());%></td>
									<td>
										<a href="javascript:nuevoAlimento(<%=ad.getIdAlimento()%>)"><img src="img/iconos/derecha.svg"  style="transform: rotate(-90deg);width: 20;"/></a>
									</td>
								<tr>
								<%} %>
								</table>							  
								</div>
							<h3><span class="label label-default">Cena</span></h3>
							   <div class="panel panel-default">
								<table class="table">
								<%for(AlimentoDieta ad : d.getCena()){ %>
								<tr>
									<td>
										<a href="javascript:nuevoAlimento(<%=ad.getIdAlimento()%>)"><img src="img/iconos/izqui.svg"  style="transform: rotate(90deg);width: 20;"/></a>
									</td>	
									<td><%out.write(ad.getNombre());%></td>
									<td>
										<a href="javascript:nuevoAlimento(<%=ad.getIdAlimento()%>)"><img src="img/iconos/derecha.svg"  style="transform: rotate(-90deg);width: 20;"/></a>
									</td>
								<tr>
								<%} %>
								</table>							  
								</div>
							</div>
							</td>
							<td>
							<div class="col-lg-9">
							<div class="panel panel-default">
							  <div class="panel-body">
								<h3>Regimen aprobado:</h3>
								<div>
								  <label>Energía:<%=r.getCalorias()%></label>
								  <br>
								  <label>Proteínas:<%=r.getProteinas()%></label>
								  <br>
								  <label>Carbohidratos:<%=r.getCarbohidratos()%></label>
								  <br>
								  <label>Lípidos<%=r.getLipidos()%>:</label>
								  <br>
								  <label>Fibra:<%=r.getFibra()%></label>
								  <br>
								</div>
								<div class="form-group">
					
									<p class="bs-component"><button onclick="javascript:nuevaDieta();" class="btn btn-sucess btn-xs">Generar otra dieta</a></p>
									<p class="bs-component"><button onclick="javascript:aceptarDieta();" class="btn btn-sucess btn-xs">Aceptar dieta</button></p>
									<p class="bs-component"><button type="submit" class="btn btn-sucess btn-xs">Imprimir dieta</button></p>
								
								</div>


							  </div>
							</div>
							</div>
							</td>
							</tr>
							</table>						
                            </div>							
                        </div>

				</div>
				<div class="col-lg-8" style="display:none" id="divConfirmacion">
					<h3>¿Seguro que desea aprobar esta dieta para el día de hoy? </h3>
					<br/>
					<button onclick="javascript:aprobarDieta();" class="btn btn-sucess btn-xs">Si</button>
					<br/>
					<button onclick="javascript:rechazarDieta();" class="btn btn-sucess btn-xs">No</button>
				</div>
				<script>
				function aprobarDieta(){
					$.get("ControladorDieta?operacion=3",function(data){
						location.reload();
					});
				}
				function rechazarDieta(){	
					$("#divConfirmacion").hide();
				}
				</script>
</div>
            
        </div>
     <div class="container" style="margin-top:100px;background:#213029;color:#FFF;width:100%;">

		<div class="row">
			<div class="col-md-12">
			<p style="text-align:center;">Empresa</p>	
			
			</div>
			
		
			
			
		</div> <!-- /row -->
		<hr>
		<div class="row">
			<div class="col-md-4">
					Mas información
			
			</div>
			
		
			<div class="col-md-4">
				Datos legales
			</div>
			
			<div class="col-md-4">
				Conocenos
			</div>
			
		</div> <!-- /row -->

		

</div>   
	<script>
		function nuevoAlimento(id){
			$.get("ControladorDieta?operacion=2&idAlimento="+id,function(data){
				location.reload();
			});
			
		}	
		function nuevaDieta(){
			$.get("ControladorDieta?operacion=1",function(data){
				location.reload();
			});
		}
		function aceptarDieta(){
			$("#divConfirmacion").show();
		}
	</script>
    </body>
</html>