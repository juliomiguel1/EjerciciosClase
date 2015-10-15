/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojos.Pruebapojos;

/**
 *
 * @author juliomiguel
 */
public class ejerciciopojos extends HttpServlet {

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
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {

           int operador1 = Integer.parseInt(request.getParameter("datos"));

            ArrayList opersonas = new ArrayList();

            String[] nombres = {"Julio", "Luis", "Xavier", "Mirko", "Rafa", "Gunther", "Alvaro", "Santiago", "Alex", "Paco"};
            // nombre= Arrays.asList(miArrayDeNombre);
            String[] apellidos = {"Gutierrez", "Millet", "Figueroa", "Pietro", "THE BEST", "Pinedo", "Medina", "Alvarez", "Soto", "Moreno"};
            //   apellidos = Arrays.asList(miArrayDeApellidos);
            String[] telefonos = {"962038880", "962038881", "962038882", "962038883", "962038884", "962038885", "962038886", "962038887", "962038888", "962038889",};
            //   telefono = Arrays.asList(miArrayDeTelefonos);

            for (int j = 0; j <= operador1; j++) {

                Random diferente = new Random();
                Random diferente2 = new Random();
                Random diferente3 = new Random();
                Random diferente4 = new Random();
                Random diferente5 = new Random();
                
                
                Pruebapojos personas = new Pruebapojos();
                
                
                int aleatorio = diferente.nextInt(10);
                int aleatorio2 = diferente2.nextInt(10);
                int aleatorio3 = diferente3.nextInt(10);
                int aleatorio4 = diferente4.nextInt(10);
                int ranaleatorio = 0;
                if (opersonas.size() >=1) {
                    ranaleatorio = diferente5.nextInt(opersonas.size());
                }
                personas.setNombre(nombres[aleatorio]);
                personas.setApellido1(apellidos[aleatorio2]);
                personas.setApellido2(apellidos[aleatorio3]);
                personas.setEmail(nombres[aleatorio] + "" + apellidos[aleatorio2] + "@gmail.com");
                personas.setTelefono(telefonos[aleatorio4]);
                
               if (opersonas.size() == 0) {
                    personas.setAmigo(personas);
                } else {
                   personas.setAmigo((Pruebapojos) opersonas.get(ranaleatorio));
               }
                opersonas.add(personas);
            }
            Gson oGson = new Gson();
            String misnombres= oGson.toJson(opersonas);
            out.print(misnombres);
            
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
