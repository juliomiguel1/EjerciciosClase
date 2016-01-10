/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pojos.Alumnos;

/**
 *
 * @author juliomiguel
 */
public class servletFormulario extends HttpServlet {

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
            HttpSession oSession = request.getSession();
            /* TODO output your page here. You may use following sample code. */
            if (oSession.getAttribute("alumnos") == null) { //comprobamos si no existe la session
                ArrayList<Alumnos> alAlumnos = new ArrayList(); //creamos u Arraylist para almacenar los productos

                String[] apellidos = {"Gutierrez", "Garcia", "Maza", "Rivera", "Meneses"};
                String[] nombres = {"Julio", "Miguel", "Luis", "Dylan", "Cesar"};

                for (int i = 0; i <= 9; i++) {

                    Alumnos alumno = new Alumnos();

                    Random diferente1 = new Random();
                    Random diferente2 = new Random();

                    int aleatorio = diferente1.nextInt(5);
                    int aleatorio2 = diferente2.nextInt(5);


                    alumno.setId(i+1);
                    alumno.setNombre(nombres[aleatorio]);
                    alumno.setApellido(apellidos[aleatorio2]);

                    alAlumnos.add(alumno);

                }
                oSession.setAttribute("alumnos", alAlumnos); // creo la session pasando el arrarList con los productos
            }
            
            if (request.getParameter("op").equals("get")) {
                if(Integer.parseInt(request.getParameter("id"))>0){
                    
                    ArrayList<Alumnos> alAlumnos = (ArrayList<Alumnos>) oSession.getAttribute("alumnos");
                    Iterator<Alumnos> iterador = alAlumnos.iterator();
                    while (iterador.hasNext()) {
                        Alumnos oAlumnos = iterador.next();
                        if (Integer.parseInt(request.getParameter("id")) == oAlumnos.getId()) {
                            Alumnos newAlumno = new Alumnos();
                            
                            newAlumno.setId(oAlumnos.getId());
                            newAlumno.setNombre(oAlumnos.getNombre());
                            newAlumno.setApellido(oAlumnos.getApellido());
                            
                            Gson oGson = new GsonBuilder().create();
                            out.print("{\"status\":200,\"message\":" + oGson.toJson(newAlumno) + "}");
                        }
                    }                  
                } 
            }
            
            if(request.getParameter("op").equals("getall")){
                    ArrayList<Alumnos> alAlumnos = (ArrayList<Alumnos>) oSession.getAttribute("alumnos");
                    Iterator<Alumnos> iterador = alAlumnos.iterator();
                          
                            Gson oGson = new GsonBuilder().create();
                            out.print("{\"status\":200,\"message\":" + oGson.toJson(alAlumnos) + "}");

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
