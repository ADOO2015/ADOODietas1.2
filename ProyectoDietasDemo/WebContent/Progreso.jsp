<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="pojos.Usuario"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
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
<%HttpSession sesion = request.getSession();
    	Usuario a = new Usuario();
    	a = (Usuario)sesion.getAttribute("Usuario");
    	String nombre = a.getNombre();%>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
      <ul class="nav navbar-nav">
       
      </ul>
      <ul class="nav navbar-nav navbar-right">
              <li><h3><%=nombre%></h3></li>
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
							<div class="col-md-12">			
								<h1>Historial de Progreso</h1>
				<div style="width:50%" class="center-block">
					
						<canvas id="canvas" height="450" width="600"></canvas>
					
				</div>				
			</div>			
			<br/><br/>			
			<div class="col-md-12">			
			<h1>Actualiza tu progreso</h1>
			
				<form class="form-horizontal" action="MiProgreso" method="post">
				  <fieldset>
					<div class="form-group">
					  <div class="col-lg-10">
						<input class="form-control" id="altura" placeholder="Altura" type="text" name="altura" required>
						 <input class="form-control" id="peso" placeholder="Peso" type="text" name="peso" required>
						  <input class="form-control" id="cadera" placeholder="Cadera" type="text" name="cadera" required>
						   <input class="form-control" id="cintura" placeholder="Cintura" type="text" name="cintura" required>
					  </div>
					</div>
					<div class="form-group">
					  <div class="col-lg-10 col-lg-offset-2">
						<button type="submit" class="btn btn-primary">Actualizar Progreso</button>
					  </div>
					</div>
				  </fieldset>
				</form>
				</div>		
             
			</div>

		</div>
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

		

</div>	<!-- /container -->


</body>
<% 
String x[]=(String[])sesion.getAttribute("x");
String y[]=(String[])sesion.getAttribute("y");
%>

<script type="text/javascript">
	
		var lineChartData = {
			labels : [<% for (int i=0; i< x.length; i++) { out.print("\""+x[i]+"\"");if(i<x.length-1)out.print(", "); } %>],
			
			datasets : [
				{
					label: "My First dataset",
					fillColor : "rgba(220,220,220,0.2)",
					strokeColor : "#0B6BB0",
					pointColor : "rgba(220,220,220,1)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(220,220,220,1)",
					data :[<% for (int i=0; i< y.length; i++) {out.print("\""+y[i]+"\"");if(i<y.length-1)out.print(", "); } %>]
				}
			]

		}

	window.onload = function(){
		var ctx = document.getElementById("canvas").getContext("2d");
		window.myLine = new Chart(ctx).Line(lineChartData, {
			responsive: true
		});
	}


	</script>


</html>

