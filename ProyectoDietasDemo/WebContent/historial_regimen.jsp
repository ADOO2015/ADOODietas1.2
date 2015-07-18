<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="boots.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	
	
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
<h2>Historial de Régimenes</h2>

<table class="table table-striped table-hover ">
  <tbody>
    <tr>
      <td>Inicio</td>
      <td>23/2/2015</td>
      <td>Energía</td>
      <td>

<div class="form-group">

  <input class="form-control input-sm" type="text" id="inputSmall">
</div>

</td>
    </tr>
    <tr>

      <td>Fin</td>
      <td>20/3/2015</td>
      <td>Proteínas</td>
<td>
<div class="form-group">

  <input class="form-control input-sm" type="text" id="inputSmall">
</div>
</td>
    </tr>

    <tr class="form-group">

      <td></td>
      <td></td>
      <td>Carbohidratos</td>
      <td>
<div class="form-group">

  <input class="form-control input-sm" type="text" id="inputSmall">
</div>

</td>
    </tr>
    <tr class="form-group">
      <td></td>
      <td></td>
      <td>Lípidos</td>
      <td>
<div class="form-group">

  <input class="form-control input-sm" type="text" id="inputSmall">
</div>

</td>
    </tr>
    <tr class="form-group">
      <td></td>
      <td></td>
      <td>Colesterol</td>
      <td>
<div class="form-group">

  <input class="form-control input-sm" type="text" id="inputSmall">
</div>
</td>
    </tr>
    <tr class="form-group">
      <td></td>
      <td></td>
      <td>Fibra</td>
      <td>
<div class="form-group">

  <input class="form-control input-sm" type="text" id="inputSmall">
</div>
</td>
    </tr>
  </tbody>
</table> 



<table class="table table-striped table-hover ">
  <tbody>
    <tr>
      <td>Inicio</td>
      <td>23/2/2015</td>
      <td>Energía</td>
      <td>

<div class="form-group">

  <input class="form-control input-sm" type="text" id="inputSmall">
</div>

</td>
    </tr>
    <tr>

      <td>Fin</td>
      <td>15/3/2015</td>
      <td>Proteínas</td>
<td>
<div class="form-group">

  <input class="form-control input-sm" type="text" id="inputSmall">
</div>
</td>
    </tr>

    <tr class="form-group">

      <td></td>
      <td></td>
      <td>Carbohidratos</td>
      <td>
<div class="form-group">

  <input class="form-control input-sm" type="text" id="inputSmall">
</div>

</td>
    </tr>
    <tr class="form-group">
      <td></td>
      <td></td>
      <td>Lípidos</td>
      <td>
<div class="form-group">

  <input class="form-control input-sm" type="text" id="inputSmall">
</div>

</td>
    </tr>
    <tr class="form-group">
      <td></td>
      <td></td>
      <td>Colesterol</td>
      <td>
<div class="form-group">

  <input class="form-control input-sm" type="text" id="inputSmall">
</div>
</td>
    </tr>
    <tr class="form-group">
      <td></td>
      <td></td>
      <td>Fibra</td>
      <td>
<div class="form-group">

  <input class="form-control input-sm" type="text" id="inputSmall">
</div>
</td>
    </tr>
  </tbody>
</table> 

<table class="table table-striped table-hover ">
  <tbody>
    <tr>
      <td>Activo desde</td>
      <td>15/5/2015</td>
      <td>Energía</td>
      <td>

<div class="form-group">

  <input class="form-control input-sm" type="text" id="inputSmall">
</div>

</td>
    </tr>
    <tr>

      <td></td>
      <td></td>
      <td>Proteínas</td>
<td>
<div class="form-group">

  <input class="form-control input-sm" type="text" id="inputSmall">
</div>
</td>
    </tr>

    <tr class="form-group">

      <td></td>
      <td></td>
      <td>Carbohidratos</td>
      <td>
<div class="form-group">

  <input class="form-control input-sm" type="text" id="inputSmall">
</div>

</td>
    </tr>
    <tr class="form-group">
      <td></td>
      <td></td>
      <td>Lípidos</td>
      <td>
<div class="form-group">

  <input class="form-control input-sm" type="text" id="inputSmall">
</div>

</td>
    </tr>
    <tr class="form-group">
      <td></td>
      <td></td>
      <td>Colesterol</td>
      <td>
<div class="form-group">

  <input class="form-control input-sm" type="text" id="inputSmall">
</div>
</td>
    </tr>
    <tr class="form-group">
      <td></td>
      <td></td>
      <td>Fibra</td>
      <td>
<div class="form-group">

  <input class="form-control input-sm" type="text" id="inputSmall">
</div>
</td>
    </tr>
  </tbody>
</table> 

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

