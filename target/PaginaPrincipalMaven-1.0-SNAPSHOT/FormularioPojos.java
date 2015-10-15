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
public class FormularioPojos {

    @Expose
    // @Expose(serialize = false)
    private String Nombre;
    @Expose
    private String Apellido1;
    @Expose
    private String Apellido2;
    @Expose
    private String FechadeNacimiento;
    @Expose
    private String Email;
    @Expose
    private String Telefono;

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Apellido
     */
    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * @return the Apellido1
     */
    public String getApellido1() {
        return Apellido1;
    }

    /**
     * @param Apellido1 the Apellido1 to set
     */
    public void setApellido1(String Apellido1) {
        this.Apellido1 = Apellido1;
    }

    /**
     * @return the Apellido2
     */
    public String getApellido2() {
        return Apellido2;
    }

    /**
     * @param Apellido2 the Apellido2 to set
     */
    public void setApellido2(String Apellido2) {
        this.Apellido2 = Apellido2;
    }

    /**
     * @return the FechadeNacimiento
     */
    public String getFechadeNacimiento() {
        return FechadeNacimiento;
    }

    /**
     * @param FechadeNacimiento the FechadeNacimiento to set
     */
    public void setFechadeNacimiento(String FechadeNacimiento) {
        this.FechadeNacimiento = FechadeNacimiento;
    }

}
