/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Persona;
import ModeloDAO.PersonaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author George
 */
public class Controlador extends HttpServlet {
   String listar="vistas/listar.jsp";
    String add="vistas/add.jsp";
    String edit="vistas/editar.jsp";
    Persona p = new Persona();
    PersonaDAO dao = new PersonaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador3</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador3 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String acceso = "";
    String action = request.getParameter("action");
    if(action.equalsIgnoreCase("listar")){
        acceso=listar;
    }else if (action.equalsIgnoreCase("add")){
        acceso = add;
    } 
    else if (action.equalsIgnoreCase("Agregar")){
        String nombre = request.getParameter("txtnombre");
        String cedula = request.getParameter("txtcedula");
        String marcaCarro = request.getParameter("txtmarcacarro"); 
        p.setNombre(nombre);
        p.setCedula(cedula); 
        p.setMarcaCarro(marcaCarro);
        dao.add(p);
        acceso=listar;
    }else if (action.equalsIgnoreCase("editar")){
        request.setAttribute("idcliente", request.getParameter("id"));
        acceso=edit;
    }
    else if(action.equalsIgnoreCase("Actualizar")){
        int id=Integer.parseInt(request.getParameter("txtid"));
        String nombre = request.getParameter("txtnombre");
        String cedula = request.getParameter("txtcedula");
        String marcaCarro = request.getParameter("txtmarcacarro");
        p.setId(id);
        p.setNombre(nombre);
        p.setCedula(cedula); 
        p.setMarcaCarro(marcaCarro);
        dao.editar(p);
        acceso=listar;
    }
    else if (action.equalsIgnoreCase("eliminar")){
       int id=Integer.parseInt(request.getParameter("id"));
        p.setId(id);
        dao.eliminars(id);
        acceso=listar;
    }
    
    RequestDispatcher vista=request.getRequestDispatcher(acceso);
    vista.forward(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
