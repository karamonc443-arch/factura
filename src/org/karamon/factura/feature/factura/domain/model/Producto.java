package org.karamon.factura.feature.factura.domain.model;

public class Producto {
    private Integer codigo;
    private String nombre;
    private Double precio;
    private static int ultimoCodigo = 0;

    //Constructor

    public Producto() {
        this.codigo = ++ultimoCodigo;
    }

    //Getter y setter
    public Integer getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    //Metodos

}
