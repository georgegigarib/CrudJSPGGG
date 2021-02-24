<%-- 
    Document   : listar
    Created on : Feb 22, 2021, 2:11:08 PM
    Author     : George
--%>

<%@page import="ModeloDAO.PersonaDAO"%>
 <%@page import="java.util.Iterator"%>
<%@page import="Modelo.Persona"%>
<%@page import="java.util.List"%>
 <%@page import="ModeloDAO.PersonaDAO"%>
<%@page  contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            
            <h1>Clientes</h1>
            <a class ="btn btn-success" href="Controlador?action=add">
                Agregar Cliente
            </a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">Cedula</th>
                        <th class="text-center">Profesion</th>
                        <th class="text-center">Ediciones</th>
                    </tr>
                </thead>
              
                <tbody>
                          <%
                    PersonaDAO dao = new PersonaDAO();
                    List<Persona>list = dao.listar();
                    Iterator<Persona>iter=list.iterator();
                    Persona per = null;
                    while(iter.hasNext()){
                        per = iter.next();
                    %>
                    <tr>
                        <td><%= per.getId()%></td>
                        <td><%= per.getNombre()%></td>
                        <td><%= per.getCedula()%></td>
                        <td><%= per.getMarcaCarro()%></td>
                       
                        <td>
                            <a class="btn btn-warning btn-m" href="Controlador?action=editar&id=<%= per.getId()%>">Editar</a>
                            <a class="btn btn-danger btn-m" href="Controlador?action=eliminar&id=<%=  per.getId()%>">Eliminar</a>
                        </td>
                    </tr>
                     <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
