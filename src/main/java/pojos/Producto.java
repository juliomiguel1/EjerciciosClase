/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import com.google.gson.annotations.Expose;

/**
 *
 * @author a020864288e
 */
public class Producto {
   @Expose
    private int Numero;
   @Expose
    private String Descripcion;
   @Expose
    private int Existencias;
   @Expose
    private int Precio;

    /**
     * @return the numero
     */
    public int getNumero() {
        return Numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.Numero = numero;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }

    /**
     * @return the existencias
     */
    public int getExistencias() {
        return Existencias;
    }

    /**
     * @param existencias the existencias to set
     */
    public void setExistencias(int existencias) {
        this.Existencias = existencias;
    }

    /**
     * @return the precio
     */
    public int getPrecio() {
        return Precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(int precio) {
        this.Precio = precio;
    }
}
