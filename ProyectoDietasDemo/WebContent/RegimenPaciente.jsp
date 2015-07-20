<%@page import="modelo.RegimenDAO"%>
<%@page import="pojos.Regimen"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import = 
    "pojos.Usuario,
    modelo.AccessUsuarioDAO,
    modelo.UsuarioDAO,
    controlador.AccessUser,
    java.util.ArrayList"%>
    <%!
    	Usuario user, paciente;
    	String idpac,gen;
    %>
    <%
    user = (Usuario) session.getAttribute("Usuario");
    %>
    <%HttpSession sesion = request.getSession();
    	Usuario a = new Usuario();
    	a = (Usuario)sesion.getAttribute("Usuario");
    	String nombre = a.getNombre();
    	idpac = request.getParameter("idPac");
    	gen = request.getParameter("gen");
    	AccessUsuarioDAO pacientes = new AccessUsuarioDAO();
    	ArrayList<Usuario> usuarios = (ArrayList<Usuario>)pacientes.findByMedico(user.getId());   
    	for( Usuario u : usuarios ){
    		if(u.getId().equals(idpac)){
    			paciente = u;
    			break;
    		}
    	}
    	sesion.setAttribute("paciente", paciente);
    	Regimen regAn, regNw;
    	regNw = new Regimen();
    	RegimenDAO r = new RegimenDAO();
    	regAn = r.consultarUltimoRegimen(paciente);
    	if(gen.equals("A")){
    		regNw = r.generarNuevoRegimen(paciente);
    	}
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
        <title>Regimen del paciente</title>
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
                <div class="col-lg-3">
                    
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title"><%="#USUARIO"%></h3>
					</div>
					<div class="panel-body">
						<div class="list-group">
							<a href="pacientesDoctor.jsp" class="list-group-item acve"> <img
								src="img/iconos/pacientes.svg" id="icn" /> Pacientes
							</a> <a href="#" class="list-group-item"><img
								src="img/iconos/agenda.svg" id="icn" /> Agenda </a> <a
								href="confirmacionPacientes" class="list-group-item"><img
								src="img/iconos/registro.svg" id="icn" /> Registro de pacientes
							</a>
						</div>
					</div>
					<div class="panel-body">
						<form action="confirmacionPacientes" method="get">
							<div class="input-group">
								<input type="text" class="form-control" placeholder="Buscar..."
									name="q" id="q" value="${q}"> <span class="input-group-btn">
									<input class="btn btn-default" type="submit" value="Buscar">
								</span>
							</div>
						</form>
					</div>
				</div>
					<div class="panel panel-success">
                        <div class="panel-body">
                            <img src="img/iconos/imagenGenerica3.svg"  style="display: block;margin-left: auto; margin-right: auto; border:none;width: 70px;"/>
							<h5 align="center"><%out.print(paciente.getNombre() +" "+paciente.getApellidos()+"");%></h5>
                        </div>
                        <div class="panel-body">
                          <table>
						  <tr>
						  <td>
							<a href="#" class="list-group-item"><img src="img/iconos/Dieta.svg" id="icn"/> Regimen</a>
						  </td>
						  <td>
							<a href="#" class="list-group-item"><img src="img/iconos/mensajes.svg" id="icn"/>Mensajes</a>
						  </td>
						  </tr>
                          <tr>
						  <td>
							<a href="#" class="list-group-item"><img src="img/iconos/historial.svg" id="icn"/> Historial</a>
						  </td>
						  <td>
							<a href="#" class="list-group-item"><img src="img/iconos/Progreso.svg" id="icn"/> Progreso</a>
						  </td>
						  </tr>  
                          <tr>
						  <td>
							<a href="#" class="list-group-item"><img src="img/iconos/perfil.svg" id="icn"/> Perfil</a>
						  </td>
						  <td>
							<a href="#" class="list-group-item"><img src="img/iconos/agenda.svg" id="icn"/> Agenda</a>
						  </td>
						  </tr>  
                          </table>
                        </div>

                     </div>	
                </div>
			<form class="form-horizontal" method="get" action="RegistraRegimen">	
             <div class="col-md-8">
			        <h2>Régimen Actual</h2>

    <div class="row">
     <div class="col-md-6">
      <div class="jumbotron">
        
<table class="table table-striped table-hover ">

  <tbody>
    <tr class="info">
      <td>Calorias:</td>
      <td>


<div class="form-group">

  <input class="form-control input-sm" type="text" name="cal" id="cal" value=<%=regNw.getCalorias() %>>

</div>


</td>
    </tr>
    <tr class="info">
      <td>Proteínas:</td>
      <td>
<div class="form-group">

  <input class="form-control input-sm" type="text" id="inputSmall" value=<%=regNw.getProteinas() %>>
</div>


</td>
    </tr>
    <tr class="info">
      <td>Lípidos:</td>
      <td>

<div class="form-group">

  <input class="form-control input-sm" type="text" id="inputSmall" value=<%=regNw.getLipidos()%>>
</div>

</td>
    </tr>
    <tr class="info">
      <td>Carbohidratos:</td>
      <td>
<div class="form-group">

  <input class="form-control input-sm" type="text" id="inputSmall" value=<%=regNw.getCarbohidratos() %>>
</div>


</td>
    </tr>
    <tr class="info">
      <td>Fibra:</td>
      <td>

<div class="form-group">

  <input class="form-control input-sm" type="text" id="inputSmall" value=<%=regNw.getFibra() %>>
</div>

</td>
    </tr>

  </tbody>
</table> 

<center>
        <h3>Régimen por aprobar</h3>
</center>
</div>

</div>


<div class="col-md-6">
  <div class="jumbotron">





<table class="table table-striped table-hover ">

  <tbody>
    <tr class="success">
      <td>Calorias:</td>
      <td>


<div class="form-group">
  <input class="form-control input-sm" type="text" id="disabledInput" value=<%=regAn.getCalorias() %> disabled>
</div>


</td>
    </tr>
    <tr class="success">
      <td>Proteínas:</td>
      <td>
<div class="form-group">

  <input class="form-control input-sm" type="text" id="disabledInput" value=<%=regAn.getProteinas() %> disabled>
</div>


</td>
    </tr>
    <tr class="success">
      <td>Lípidos:</td>
      <td>

<div class="form-group">

  <input class="form-control input-sm" type="text" id="disabledInput" value=<%=regAn.getLipidos() %> disabled>
</div>

</td>
    </tr>
    <tr class="success">
      <td>Carbohidratos:</td>
      <td>
<div class="form-group">

  <input class="form-control input-sm" type="text" id="disabledInput" value=<%=regAn.getCarbohidratos() %> disabled>
</div>


</td>
    </tr>
    <tr class="success">
      <td>Fibra:</td>
      <td>

<div class="form-group">

  <input class="form-control input-sm" type="text"  id="disabledInput" value=<%=regAn.getFibra() %> disabled>
</div>

</td>
    </tr>

  </tbody>
</table> 

<center>
        <h3>Régimen anterior</h3>
</center>



  </div>
</div>
<center>
<a href="RegimenPaciente.jsp?idPac=<%=idpac%>&gen=A" class="btn btn-primary btn-lg">Generar Automáticamante</a>
</br></br>
	<button type="submit" class="btn btn-primary btn-lg">Aprobar Regimen</button>
	

</center>
</div>
</div>
</form>
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
				Conoceno
			</div>
			
		</div> <!-- /row -->

		

</div>   
    </body>
</html>