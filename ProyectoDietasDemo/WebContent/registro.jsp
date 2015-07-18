<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	
	
</head>
<body>
		<%@ page import= "modelo.AccessUsuarioDAO" %>
		<%@ page import= "modelo.UsuarioDAO" %>
		<%@ page import= "pojos.Usuario" %>
		<%
		String valCorreo="";
		String valContrasena="";
		String valConfirmarContrasena="";
		String valAltura="";
		String valPeso="";
		String valCintura="";
		String valCadera="";
		String valNombre="";
		String valApellido="";
		String valDomicilio="";
		String valCiudad="";
		String valNumero="";
		String correo="";
		int idPaciente;
		String idDireccion;
		AccessUsuarioDAO gestor=new AccessUsuarioDAO();
		%>
		<%
		if(request.getParameter("e")!=null){
			String aux="";
			correo=request.getParameter("e");
			aux=gestor.getIdUsuario(correo);
			
			idPaciente=Integer.parseInt(aux);
			valCorreo=correo;
			valNombre=gestor.getNombre(correo);
			valApellido=gestor.getApellido(correo);
			idDireccion=gestor.getIdDireccion(""+idPaciente);
		}
		%>
		
	
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
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Inicio <span class="sr-only">(current)</span></a></li>
		<li ><a href="#">Contacto</a></li>
        <li><a href="#">Mas de nosotros</a></li>
        
      </ul>
      
     
    </div>
  </div>
</nav>


<div class="container">

		

		<div class="jumbotron">
<form class="form-horizontal" action="ControladorRegistro">
  <fieldset>
    <legend>Formulario - Registro</legend>
    <div class="form-group">
      <label for="inputEmail" class="col-lg-2 control-label">Correo</label>
      <div class="col-lg-10">
      
       <input type="text" class="form-control" name="correo" value="<% out.println(valCorreo);%>" id="inputEmail" placeholder="Correo" required>
      
    		  </div>
    </div>
    







<table class="table table-striped table-hover ">
  <thead>

  </thead>
  <tbody>
   
    <tr class="info">
      <td>Ingresa tu altura (m):</td>
      <td>

<div class="form-group">
  <input class="form-control input-sm" name="altura" type="text" id="inputSmall" required>
</div>

</td>

    </tr>
    <tr class="success">
      <td>Ingresa tu peso (kg):</td>

      <td>


<div class="form-group">
  <input class="form-control input-sm" name="peso" type="text" id="inputSmall" required>
</div>


</td>

    </tr>
    <tr class="danger">
      <td>Ingresa el perímetro de tu cintura (cm):</td>

      <td>

<div class="form-group">
  <input class="form-control input-sm" name="cintura" type="text" id="inputSmall" required>
</div>


</td>
  
    </tr>
    <tr class="warning">
      <td>Ingresa el perímetro de tu cadera(cm):</td>
      <td>

<div class="form-group">
  <input class="form-control input-sm" name="cadera" type="text" id="inputSmall" required>
</div>


</td>


    </tr>
   
  </tbody>
</table> 

		<div class="jumbotron">

  <fieldset>
    <legend>Ingresa tus datos personales:</legend>
    <div class="form-group">
      <label for="inputEmail" class="col-lg-2 control-label">Nombre</label>
      <div class="col-lg-10">
        <input type="text" value="<% out.println(valNombre);%>" name="nombre" class="form-control" id="Nombre" placeholder="" required>
      </div>
    </div>
    <div class="form-group">
      <label for="Apellido" class="col-lg-2 control-label">Apellidos</label>
      <div class="col-lg-10">
        <input type="text"name="apellido" value="<% out.println(valApellido);%>" class="form-control" id="Apellido" placeholder="" required>
      </div>


    </div>
    <div class="form-group">
      <label for="Domicilio" class="col-lg-2 control-label">Calle</label>
      <div class="col-lg-10">
        <input type="text" class="form-control" id="calle" name="calle" placeholder="" required>
      </div>
    </div>

    <div class="form-group">
      <label for="inputPassword" class="col-lg-2 control-label">Ciudad</label>
      <div class="col-lg-10">
        <input type="text" class="form-control" id="ciudad" name="ciudad" placeholder="" required>
      </div>
    </div>



    <div class="form-group">
      <label for="inputPassword" class="col-lg-2 control-label">Número</label>
      <div class="col-lg-10">
        <input type="text" class="form-control" name="numero" id="numero" placeholder="" required>
      </div>



</br>
</br></br></br></br>
    <div class="form-group">
      <div class="col-lg-10 col-lg-offset-2">
        <button type="reset" class="btn btn-default">Cancelar</button>
        <button type="submit" class="btn btn-primary">Aceptar y Guardar</button>
      </div>
    </div>
  </fieldset>
</form>
</div>

		

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

</html>