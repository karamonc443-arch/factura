package org.karamon.factura.feature.factura.domain.model;

public class Cliente {
    private String nombre,telefono,email,numIdentificacion;

    public Cliente(String nombre, String telefono, String email, String numIdentificacion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.numIdentificacion = numIdentificacion;
    }

    // Getter y Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }
}
