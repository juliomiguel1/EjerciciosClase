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
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pojos.Pedidos;
import pojos.Producto;

/**
 *
 * @author a020864288e
 */
public class carritodecompra extends HttpServlet {

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

            //Nombre de la operacion que vamos a recibir por medio del ajax
            String operation = request.getParameter("op"); //la operacion
           
            ArrayList opedidos = new ArrayList(); //Arraylis de pedidos
            ArrayList oproducto = new ArrayList();
            Pedidos pedidos = new Pedidos();
            //Generamos los productos y los guardamos en la clase productos y se lo devolvemos a el ajax
            if (operation.equals("productos")) {

                String[] nombreproducto = {"Maquinilla de", "Pasta", "Cepillo de "};
                String[] nombreproducto2 = {"Afeitar", "Dental", "Cortar"};

                

                for (int i = 0; i <= 9; i++) {

                    Random diferente1 = new Random();
                    Random diferente2 = new Random();
                    Random diferente3 = new Random();
                    Random diferente4 = new Random();
                    Random diferente5 = new Random();

                    Producto producto = new Producto();

                    int aleatorio = diferente1.nextInt(3);
                    int aleatorio2 = diferente2.nextInt(3);
                    int aleatorio3 = diferente3.nextInt(9);
                    int aleatorio4 = diferente4.nextInt(10);

                    String nombrepro = nombreproducto[aleatorio] + " " + nombreproducto2[aleatorio2];

                    producto.setNumero(i + 1);
                    producto.setDescripcion(nombrepro);
                    producto.setExistencias(aleatorio3 + 1);
                    producto.setPrecio(aleatorio4 + 1);

                    oproducto.add(producto);
                }

                Gson oGsonproductos = new Gson();
                String misproductos = oGsonproductos.toJson(oproducto);
                out.print(misproductos);
                /*Aqui termina de llenar los productos */

            } else if (operation.equals("pedir")) {
                
            int numero = Integer.parseInt(request.getParameter("numero")); //el numero de producto
            String descripcion = request.getParameter("descripcion"); //el nombre del producto
            int existencia = Integer.parseInt(request.getParameter("existencia"));//la existencia que existe en ese momento
            int precio = Integer.parseInt(request.getParameter("precio")); //el precio de cada producto
            int cantidad = Integer.parseInt(request.getParameter("cantidad")); //la cantidad de ese producto


                pedidos.setNumero(numero);
                pedidos.setDescripcion(descripcion);
                pedidos.setPrecio(precio);
                pedidos.setCantidad(cantidad);

                opedidos.add(pedidos);

                Gson oGsonpedidos = new Gson();
                String mispedidos = oGsonpedidos.toJson(opedidos);
                out.print(mispedidos);
                
                /*Aqui termina de llenar los pedidos */
            }else if (operation.equals("eliminar")) {
                
            int numero = Integer.parseInt(request.getParameter("numero1")); //el numero de producto
            String descripcion = request.getParameter("descripcion1"); //el nombre del producto
            int existencia = Integer.parseInt(request.getParameter("existencia1"));//la existencia que existe en ese momento
            int precio = Integer.parseInt(request.getParameter("precio1")); //el precio de cada producto
            int cantidad = Integer.parseInt(request.getParameter("cantidad1")); //la cantidad de ese producto


                pedidos.setNumero(numero);
                pedidos.setDescripcion(descripcion);
                pedidos.setPrecio(precio);
                pedidos.setCantidad(cantidad);
                
                opedidos.remove(pedidos);
                opedidos.add(pedidos);

                Gson oGsonpedidos = new Gson();
                String mispedidos = oGsonpedidos.toJson(opedidos);
                out.print(mispedidos);
                /*Aqui termina de llenar los pedidos */
            }else if (operation.equals("vaciar")) {
                
            int numero = Integer.parseInt(request.getParameter("numero1")); //el numero de producto
            String descripcion = request.getParameter("descripcion1"); //el nombre del producto
            int existencia = Integer.parseInt(request.getParameter("existencia1"));//la existencia que existe en ese momento
            int precio = Integer.parseInt(request.getParameter("precio1")); //el precio de cada producto
            int cantidad = Integer.parseInt(request.getParameter("cantidad1")); //la cantidad de ese producto


                pedidos.setNumero(numero);
                pedidos.setDescripcion(descripcion);
                pedidos.setPrecio(precio);
                pedidos.setCantidad(cantidad);
                
                opedidos.remove(pedidos);
                opedidos.add(pedidos);

                Gson oGsonpedidos = new Gson();
                String mispedidos = oGsonpedidos.toJson(opedidos);
                out.print(mispedidos);
                /*Aqui termina de llenar los pedidos */
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
