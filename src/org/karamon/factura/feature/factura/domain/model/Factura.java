package org.karamon.factura.feature.factura.domain.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
    private Integer idFactura;
    private String descripcion;
    private Date fecha;
    public static final int CANTIDAD_ELEMENTO = 12;
    private static int ultimoId;
    // Atributos de relación
    private Cliente cliente;
    private ItemFactura[] itmes;
    private int indiceItems;

    // Constructor
    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        // Cantidad máxima de líneas que puede contener esta factura.
        this.itmes = new ItemFactura[CANTIDAD_ELEMENTO];
        this.idFactura = ++ultimoId; // El ID se autogenera y se incrementa antes de asignarlo (preincremento).
        this.fecha = new Date(); // Fecha de emisión predeterminada de la factura.
    }

    // Getters y setters
    public Integer getIdFactura() {
        return idFactura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFactura[] getItmes() {
        return itmes;
    }

    // Método para añadir un único elemento a la factura.
    public void addItemFactura(ItemFactura item) {
        //Importante: Si el índice actual es menor que la cantidad máxima de elementos, se añade una nueva línea.
        if (indiceItems < CANTIDAD_ELEMENTO) {
            this.itmes[indiceItems++] = item;
        }
    }

    // Método para calcular el importe total de la factura.
    public Double calcularTotal() {
        double total = 0;
        for (ItemFactura item : itmes) {
            //Importante:  esta comprobación evita una NullPointerException si hay posiciones vacías en el array.
            if (item == null) {
                continue; // Si el elemento es nulo, se pasa al siguiente sin realizar la suma.
            }
            total += item.calcularImporte();
        }
        return total;
    }


    /**
     * IMPORTANTE: La pregunta del millón: ¿por qué usas StringBuilder?
     * NOTA: Uso StringBuilder porque estoy concatenando muchos datos.
     * REVISAR: Mantener código limpio y legible.
     * PENDIENTE: Subirlo a git.
     */
    // IMPORTANTE: Validar los valores nulos y las cadenas en blanco.
    public String verDetalle() {
        StringBuilder sb = new StringBuilder("Factura Nº: ");

        sb.append(idFactura)
                .append("\nCliente: ")
                .append(cliente.getNombre() != null ? cliente.getNombre() : "Sin nombre")
                .append("\nTeléfono: ")
                .append(cliente.getTelefono() != null ? cliente.getTelefono() : "Sin teléfono")
                .append("\nCorreo: ")
                .append(cliente.getEmail() != null ? cliente.getEmail() : "Sin correo")
                .append("\nDNI/NIE/NIF: ")
                .append(cliente.getNumIdentificacion() != null
                        ? cliente.getNumIdentificacion() : "Sin identificación")
                .append("\n=============== Detalle de la factura ===============: ")
                .append(descripcion != null ? descripcion : "Sin descripción");
        //Revisar: Formatear la fecha de emisión de la factura
        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        sb.append("\nFecha de emisión: ")
                .append(df.format(fecha))
                .append("\n\n#\tNombre\tPrecio\tCant.\tTotal\n");
        for (ItemFactura item : itmes) {
            //Importante: validar si el item es nulo, para evitar el problemas
            if (item == null) {
                continue;
            }
            sb.append(item.getProducto().getCodigo())
                    .append("\t")
                    .append(item.getProducto().getNombre())
                    .append("\t")
                    .append(item.getProducto().getPrecio())
                    .append("\t")
                    .append(item.getCantidad())
                    .append("\t")
                    .append(item.calcularImporte())
                    .append("\n");
        }
        sb.append("\nGran Total: ").append(calcularTotal());
        return sb.toString();
    }
}
