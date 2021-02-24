<%-- 
    Document   : editar
    Created on : Feb 22, 2021, 6:04:44 PM
    Author     : George
--%>

<%@page import="Modelo.Persona"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <br>
    <div class="container">
        <div class="col-md-1"><a  class="btn btn-danger btn-m"href="Controlador?action=listar">Volver</a></div>
         
        <div class="col-md-6">
            
        <%
        PersonaDAO dao = new PersonaDAO();
        int id = Integer.parseInt((String)request.getAttribute("idcliente"));
        Persona p=(Persona)dao.list(id);
        %>
        <h1>Modificar Cliente</h1>
        <form action="Controlador">
            Nombre: <br>
            <input class="form-control" type="text" name="txtnombre" value="<%= p.getNombre() %>"><br>
            Cedula:<br>
            <input class="form-control" type="number" maxlength="99999999999" name="txtcedula" value="<%=p.getCedula()%>"><br>
            Profesion:<br>
            <input class="form-control" type="text" maxlenght="50" name="txtmarcacarro" value="<%=p.getMarcaCarro()%>"><br>
            <input type="hidden" name="txtid" value="<%=p.getId()%>"><br>
            <input class="btn btn-success btn-m" type="submit" name="action" value="Actualizar">
    </div>  </div>
    </body>
</html>
