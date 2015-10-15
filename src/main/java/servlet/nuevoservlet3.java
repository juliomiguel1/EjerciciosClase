/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author a020864288e
 */
public class nuevoservlet3 extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Prueba de servlet</title>");

            out.println("</head>");

            out.println("<body>");
            out.println("<div>Parametros del sistema</div>" + "</br>");
            out.println("<div>Protolo : " + request.getProtocol() + "</div>");
            out.println("<div>Metodo : " + request.getMethod() + "</div>");
            out.println("<div>URI : " + request.getRequestURI() + "</div>");
            out.println("<div>URL : " + request.getRequestURL() + "</div>");
            out.println("<div>Metodo : " + request.getContextPath() + "</div>");
            out.println("<div>Codificación : " + request.getCharacterEncoding() + "</div>");
            out.println("<div>Tipo mime : " + request.getContentType() + "</div>");
            out.println("<div>IP recepción: " + request.getLocalAddr() + "</div>");
            out.println("<div>Nombre i.faz recepcion : " + request.getLocalName() + "</div>");
            out.println("<div>Metodo : " + request.getMethod() + "</div>");
            out.println("<div>Path : " + request.getPathInfo() + "</div>");
            out.println("<div>PrePath : " + request.getPathTranslated() + "</div>");
            out.println("<div>IP remota : " + request.getRemoteAddr() + "</div>");
            out.println("<div>Host remoto : " + request.getRemoteHost() + "</div>");
            //   out.println("<div>Nombre del host remoto : " + request.get + "</div>");
            out.println("<div>Puerto : " + request.getLocalPort() + "</div>");
            out.println("</br>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td> Cabecera </td>");
            out.println("<td> Valor </td>");
            out.println("</tr>");
            Enumeration headersName = request.getHeaderNames();
            while (headersName.hasMoreElements()) {
                String key = (String) headersName.nextElement();
                String value = request.getHeader(key);
                out.println("<tr>");
                out.println("<td>" + key + "</td>");
                out.println("<td>" + value + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</br>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td> Parametro </td>");
            out.println("<td> Valor </td>");
            out.println("</tr>");
            Enumeration headName = request.getParameterNames();
            while (headName.hasMoreElements()) {
                String key1 = (String) headName.nextElement();
                String[] value1 = request.getParameterValues(key1);
                out.println("<tr>");
                out.println("<td>" + key1 + "</td>");
                out.println("<td>");
                if(value1.length ==1){
                    String paramValue = value1[0];
                    if(paramValue.length()==0)
                        out.println("Vacio");
                    else
                        out.println(paramValue);
                }else{
                    for(int i =0; i<value1.length;i++){
                        out.println(value1[i]);
                    }
                }
                out.println("</td>");
                out.println("</tr>");
            }  
                out.println("</table>");
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
