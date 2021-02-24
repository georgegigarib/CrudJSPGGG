<%-- 
    Document   : add
    Created on : Feb 22, 2021, 6:04:25 PM
    Author     : George
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
       <br>
    <div class="container">
        <div class="col-md-1"><a  class="btn btn-danger btn-m"href="Controlador?action=listar">Volver</a></div>
          
            <div class="col-md-6">
        <h1>
            Agregar Cliente
        </h1>
       
        <form action="Controlador">
            Nombre: <br>
            <input class="form-control" type="text" name="txtnombre"><br>
            Cedula:<br>
            <input class="form-control" type="text" name="txtcedula"><br>
            Profesion:<br>
            <input class="form-control" type="text" name="txtmarcacarro"><br>
            <input class="btn btn-success" type="submit" name="action" value="Agregar">
        </form> 
    </div>
        </div>
    </body>
</html>
