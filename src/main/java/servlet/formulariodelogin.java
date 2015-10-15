/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author a020864288e
 */
public class formulariodelogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
          HttpSession Session = request.getSession();
         // String operation = request.getParameter("json");
          String operation = request.getParameter("op");
          String password = request.getParameter("password");
          String nombre = request.getParameter("name");
          String crear = nombre+""+password;
          
          
            if (operation.equals("login")) {
               // result = request.getParameter("json");
                
                
                if (nombre != "" && nombre != null) {
                    Session.setAttribute("name", crear);
                     Gson oGson = new Gson();
                     Map<String, String> data = new HashMap<>();
                     data.put("status", "200");
                     data.put("message", "La sesión ha sido creada para el usuario " + nombre);
                     data.put("password", password);
                     data.put("operacion", operation);
                     String resu = oGson.toJson(data);
                     out.print(resu);                   
                }
            }else if (operation.equals("logout")) {
                
                Session.invalidate();
                 Gson oGson = new Gson();
                     Map<String, String> data = new HashMap<>();
                     data.put("status", "200");
                     data.put("message", "La sesión ha finalizado");
                     data.put("operacion", operation);
                     String resu = oGson.toJson(data);
                     out.print(resu);   
            }else if (operation.equals("who")) {
                Gson oGson = new Gson();
                Map<String, String> data = new HashMap<>();
                if (Session.getAttribute("name") != null && Session.getAttribute("name").equals(crear)) {
                    String username = (String) Session.getAttribute(crear);
                    data.put("status", "200");
                     data.put("message", "Ya existe la sesion del usuario" + nombre);
                     data.put("operacion", operation);
                     String resu = oGson.toJson(data);
                     out.print(resu);   
                   
                } else {
                    data.put("status", "200");
                     data.put("message", "No hay sesion" );
                     data.put("operacion", operation);
                     String resu = oGson.toJson(data);
                     out.print(resu);
                }
 
            } 
          
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
