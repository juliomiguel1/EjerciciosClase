/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pojos.Compra;
import pojos.Pedidos;
import pojos.Producto;
import pojos.ProductoCarrito;

/**
 *
 * @author juliomiguel
 */
public class compras extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Producto find(ArrayList<Producto> alProducto, int id) {
        Iterator<Producto> iterator = alProducto.iterator();
        while (iterator.hasNext()) {
            Producto oProducto = iterator.next();
            if (id == oProducto.getNumero()) {
                return oProducto;
            }
        }
        return null;
    }

    private ProductoCarrito findCarrito(ArrayList<ProductoCarrito> alProductoCarrito, int id) {
        Iterator<ProductoCarrito> iterator = alProductoCarrito.iterator();
        while (iterator.hasNext()) {
            ProductoCarrito oProducto = iterator.next();
            if (id == oProducto.getNumero()) {
                iterator.remove();
                return oProducto;
            }
        }
        return null;
    }

    private ProductoCarrito buscaCarrito(ArrayList<ProductoCarrito> alProductoCarrito, int id) {
        Iterator<ProductoCarrito> iterator = alProductoCarrito.iterator();
        while (iterator.hasNext()) {
            ProductoCarrito oProducto = iterator.next();
            if (id == oProducto.getNumero()) {
                return oProducto;
            }
        }
        return null;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession oSession = request.getSession(); // Creamos una variable para la session    

            if (oSession.getAttribute("almacen") == null) { //comprobamos si no existe la session
                ArrayList<Producto> alProducto = new ArrayList(); //creamos u Arraylist para almacenar los productos

                String[] nombreproducto = {"Maquinilla de", "Pasta", "Cepillo de "};
                String[] nombreproducto2 = {"Afeitar", "Dental", "Cortar"};

                for (int i = 0; i <= 9; i++) {

                    Producto producto = new Producto();

                    Random diferente1 = new Random();
                    Random diferente2 = new Random();
                    Random diferente3 = new Random();
                    Random diferente4 = new Random();
                    Random diferente5 = new Random();

                    int aleatorio = diferente1.nextInt(3);
                    int aleatorio2 = diferente2.nextInt(3);
                    int aleatorio3 = diferente3.nextInt(9);
                    int aleatorio4 = diferente4.nextInt(10);

                    String nombrepro = nombreproducto[aleatorio] + " " + nombreproducto2[aleatorio2];

                    producto.setNumero(i + 1);
                    producto.setDescripcion(nombrepro);
                    producto.setExistencias(aleatorio3 + 1);
                    producto.setPrecio(aleatorio4 + 1);

                    alProducto.add(producto);

                }
                oSession.setAttribute("almacen", alProducto); // creo la session pasando el arrarList con los productos
                ArrayList<ProductoCarrito> oCarrito = new ArrayList();
                oSession.setAttribute("carrito", oCarrito);
                ArrayList<Compra> oCompra = new ArrayList();
                oSession.setAttribute("compra", oCompra);
            }

            //listar los productos
            if (request.getParameter("ob").equals("product")) { //recibimos el valor ob del request
                if (request.getParameter("op").equals("list")) { // recibimos el valor op del list

                    ArrayList<Producto> alProducto = (ArrayList<Producto>) oSession.getAttribute("almacen");
                    Gson oGson = new GsonBuilder().setDateFormat("dd/MM/yyyy").excludeFieldsWithoutExposeAnnotation().create();
                    out.print("{\"status\":200,\"message\":" + oGson.toJson(alProducto) + "}");

                }
            }

            //añadir un articulo al carrito
            if (request.getParameter("ob").equals("cart")) {
                if (request.getParameter("op").equals("add")) {
                    if (Integer.parseInt(request.getParameter("id")) > 0 && Integer.parseInt(request.getParameter("id")) <= 10) {
                        if (Integer.parseInt(request.getParameter("amount")) > 0) {
                            ArrayList<ProductoCarrito> alPedidos = (ArrayList<ProductoCarrito>) oSession.getAttribute("carrito"); //recibimos si existe el carrito y lo almacenamos en un array
                            ArrayList<Producto> alProducto = (ArrayList<Producto>) oSession.getAttribute("almacen"); //recibimos el almacen y lo almacenamos en un array
                            ProductoCarrito oProductoCarrito = new ProductoCarrito(); //Creamos un objeto de carrito
                            Producto oProducto = this.find(alProducto, Integer.parseInt(request.getParameter("id")));
                            int existencias = oProducto.getExistencias();
                            if (existencias >= Integer.parseInt(request.getParameter("amount"))) {
                                 ProductoCarrito oProductoCarrito2 = this.buscaCarrito(alPedidos, Integer.parseInt(request.getParameter("id")));
                                int probar = 0;
                                 if (oProductoCarrito2 != null) {                                 
                                  probar = oProductoCarrito2.getCantidad();
                                 }
                                if( existencias >= probar + Integer.parseInt(request.getParameter("amount")) ){                                  
                                
                                if (oProductoCarrito2 != null) {
                                    int nuevo = oProductoCarrito2.getCantidad();
                                    oProductoCarrito2.setCantidad(nuevo + Integer.parseInt(request.getParameter("amount")));
                                } else {
                                    oProductoCarrito.setNumero(oProducto.getNumero());
                                    oProductoCarrito.setCantidad(Integer.parseInt(request.getParameter("amount")));
                                    alPedidos.add(oProductoCarrito);
                                }
                                Gson oGson = new Gson();

                                Map<String, String> data = new HashMap<>();
                                data.put("status", "200");
                                data.put("message", "Ok, producto añadido.");
                                String result = oGson.toJson(data);
                                out.print(result);
                                }else{
                                Gson oGson = new Gson();
                                Map<String, String> data = new HashMap<>();
                                data.put("status", "500");
                                data.put("message", "No hay cantidad suficiente de ese producto.");
                                String result = oGson.toJson(data);
                                out.print(result);
                                
                                }

                            } else {
                                Gson oGson = new Gson();
                                Map<String, String> data = new HashMap<>();
                                data.put("status", "500");
                                data.put("message", "No hay cantidad suficiente de ese producto.");
                                String result = oGson.toJson(data);
                                out.print(result);
                            }
                        }
                        } else {
                            Gson oGson = new Gson();
                            Map<String, String> data = new HashMap<>();
                            data.put("status", "500");
                            data.put("message", "No existe ese numero de producto.");
                            String result = oGson.toJson(data);
                            out.print(result);

                        }
                    
                }
            }
            //agregar varios articulo por medio de un json recibido
       /*     if (request.getParameter("ob").equals("cart")) {
             if (request.getParameter("op").equals("addblock")) {
             if (request.getParameter("json") != null) {

             try {
             String result = request.getParameter("json");
             JSONParser parser = new JSONParser();
             Object obj = parser.parse(result);
             JSONObject jsonObject = (JSONObject) obj;
             JSONArray msg = (JSONArray) jsonObject.get(obj);
             Iterator<String> iterator = msg.iterator();
             while (iterator.hasNext()) {
             System.out.println(iterator.next());
             }

             } catch (ParseException e) {
             e.printStackTrace();
             }
             }
             }

             }*/
            //listar carrito de la compra
            if (request.getParameter("ob").equals("cart")) {
                if (request.getParameter("op").equals("list")) {

                    ArrayList<Pedidos> alPedidos = new ArrayList<>();
                    ArrayList<ProductoCarrito> oCarrito = (ArrayList<ProductoCarrito>) oSession.getAttribute("carrito");
                    ArrayList<Producto> alProducto = (ArrayList<Producto>) oSession.getAttribute("almacen");
                    Iterator<ProductoCarrito> iterador = oCarrito.iterator();
                    while (iterador.hasNext()) {

                        ProductoCarrito oProductoCarrito = iterador.next();
                        Producto oProducto = this.find(alProducto, oProductoCarrito.getNumero());
                        Pedidos oPedidos = new Pedidos();
                        oPedidos.setNumero(oProductoCarrito.getNumero());
                        oPedidos.setCantidad(oProductoCarrito.getCantidad());
                        oPedidos.setDescripcion(oProducto.getDescripcion());
                        oPedidos.setPrecio(oProducto.getPrecio());
                        alPedidos.add(oPedidos);
                    }

                    Gson oGson = new GsonBuilder().create();
                    out.print("{\"status\":200,\"message\":" + oGson.toJson(alPedidos) + "}");

                }
            }

            //elimina un articulo
            if (request.getParameter("ob").equals("cart")) {
                if (request.getParameter("op").equals("drop")) {
                    if (Integer.parseInt(request.getParameter("id")) > 0 && Integer.parseInt(request.getParameter("id")) <= 10) {
                        ArrayList<ProductoCarrito> oCarrito = (ArrayList<ProductoCarrito>) oSession.getAttribute("carrito");
                        ProductoCarrito oProductoCarrito = this.findCarrito(oCarrito, Integer.parseInt(request.getParameter("id")));

                        Gson oGson = new Gson();

                        Map<String, String> data = new HashMap<>();
                        data.put("status", "200");
                        data.put("message", "Ok, producto Eliminado.");
                        String result = oGson.toJson(data);
                        out.print(result);
                    } else {
                        Gson oGson = new Gson();
                        Map<String, String> data = new HashMap<>();
                        data.put("status", "500");
                        data.put("message", "No existe ese numero de producto.");
                        String result = oGson.toJson(data);
                        out.print(result);

                    }
                }
            }

            //vaciar el carrito
            if (request.getParameter("ob").equals("cart")) {
                if (request.getParameter("op").equals("empty")) {

                    ArrayList<ProductoCarrito> oCarrito = (ArrayList<ProductoCarrito>) oSession.getAttribute("carrito");
                    Iterator<ProductoCarrito> iterator = oCarrito.iterator();
                    while (iterator.hasNext()) {
                        ProductoCarrito oProducto = iterator.next();
                        iterator.remove();
                    }

                    Gson oGson = new Gson();

                    Map<String, String> data = new HashMap<>();
                    data.put("status", "200");
                    data.put("message", "Ok, carro vacio.");
                    String result = oGson.toJson(data);
                    out.print(result);
                }
            }

            //Comprobamos las existencias y realizamos la compra
            if (request.getParameter("ob").equals("cart")) {
                if (request.getParameter("op").equals("checkout")) {

                    ArrayList<ProductoCarrito> alPedidos = (ArrayList<ProductoCarrito>) oSession.getAttribute("carrito"); //recibimos si existe el carrito y lo almacenamos en un array
                    ArrayList<Producto> alProducto = (ArrayList<Producto>) oSession.getAttribute("almacen"); //recibimos el almacen y lo almacenamos en un array
                    ArrayList<Compra> alCompra = (ArrayList<Compra>) oSession.getAttribute("compra");
                    Iterator<ProductoCarrito> iterator = alPedidos.iterator();

                    while (iterator.hasNext()) {
                        ProductoCarrito oProductoCarrito = iterator.next();
                        Iterator<Producto> iterator2 = alProducto.iterator();
                        while (iterator2.hasNext()) {
                            Producto oProducto = iterator2.next();
                            if (oProducto.getNumero() == oProductoCarrito.getNumero()) {
                                Compra oCompra = new Compra();
                                oProducto.setExistencias(oProducto.getExistencias() - oProductoCarrito.getCantidad());
                                oCompra.setNumero(oProducto.getNumero());
                                oCompra.setDescripcion(oProducto.getDescripcion());
                                oCompra.setCantidad(oProductoCarrito.getCantidad());
                                oCompra.setPrecio(oProducto.getPrecio());
                                alCompra.add(oCompra);
                                iterator.remove();
                            }
                        }

                    }

                    Gson oGson = new Gson();

                    Map<String, String> data = new HashMap<>();
                    data.put("status", "200");
                    data.put("message", "Ok, compra realizada.");
                    String result = oGson.toJson(data);
                    out.print(result);

                }
            }

            if (request.getParameter("ob").equals("purchases")) { //recibimos el valor ob del request
                if (request.getParameter("op").equals("list")) { // recibimos el valor op del list

                    ArrayList<Compra> alCompra = (ArrayList<Compra>) oSession.getAttribute("compra");
                    Gson oGson = new GsonBuilder().setDateFormat("dd/MM/yyyy").excludeFieldsWithoutExposeAnnotation().create();
                    out.print("{\"status\":200,\"message\":" + oGson.toJson(alCompra) + "}");

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
