package org.karamon.factura.feature.factura.domain.model;

public class ItemFactura {
    private Integer cantidad;
    //Atributo de asociación
    private Producto producto;
    //Constructor

    public ItemFactura(Integer cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    //Getter y Setter

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    //Calcular Importe
    public Double calcularImporte(){
        return this.cantidad * this.producto.getPrecio();
    }
}
