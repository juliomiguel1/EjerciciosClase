/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import com.google.gson.annotations.Expose;

/**
 *
 * @author juliomiguel
 */
public class Compra {
    @Expose
    private int Numero;
    @Expose
    private String Descripcion;
    @Expose
    private int Cantidad;
    @Expose
    private int Precio;

    /**
     * @return the Numero
     */
    public int getNumero() {
        return Numero;
    }

    /**
     * @param Numero the Numero to set
     */
    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    /**
     * @return the Existencias
     */
    public int getCantidad() {
        return Cantidad;
    }

    /**
     * @param Cantidad the Existencias to set
     */
    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    /**
     * @return the Cantidad
     */
    public int getPrecio() {
        return Precio;
    }

    /**
     * @param Precio the Cantidad to set
     */
    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }
}
