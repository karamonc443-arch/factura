package org.karamon.factura.feature.factura.domain.model;

public class ItemFactura {
    private Integer candidad;
    //Atributo de asociación
    private Producto producto;
    //Constructor

    public ItemFactura(Integer candidad, Producto producto) {
        this.candidad = candidad;
        this.producto = producto;
    }

    //Getter y Setter

    public Integer getCandidad() {
        return candidad;
    }

    public void setCandidad(Integer candidad) {
        this.candidad = candidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    //Calcular Importe
    public Double calcularImporte(){
        return this.candidad * this.producto.getPrecio();
    }
}
