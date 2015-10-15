/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author juliomiguel
 */
public class subidadeimagenes extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("application/json;charset=UTF-8");
       try (PrintWriter out = response.getWriter()) {
           String name = "";
           String strMessage = "";
           HashMap<String, String> hash = new HashMap<>();
           if (ServletFileUpload.isMultipartContent(request)) {
               try {
                   List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                   for (FileItem item : multiparts) {
                       if (!item.isFormField()) {
                           name = new File(item.getName()).getName();
                           item.write(new File(".//..//webapps//images//" + name));
                       } else {
                           hash.put(item.getFieldName(), item.getString());
                       }
                   }
                   Gson oGson = new Gson();
                   Map<String, String> data = new HashMap<>();
                   Iterator it = hash.entrySet().iterator();
                   while (it.hasNext()) {
                       Map.Entry e = (Map.Entry) it.next();
                       data.put(e.getKey().toString(), e.getValue().toString());
                   }
                   data.put("imglink", "http://" + request.getServerName() + ":" + request.getServerPort() + "/images/" + name);
                   out.print("{\"status\":200,\"message\":" + oGson.toJson(data) + "}");
               } catch (Exception ex) {
                   strMessage += "File Upload Failed: " + ex;
                   out.print("{\"status\":500,\"message\":\"" + strMessage + "\"}");
               }
           } else {
               strMessage += "Only serve file upload requests";
               out.print("{\"status\":500,\"message\":\"" + strMessage + "\"}");
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
