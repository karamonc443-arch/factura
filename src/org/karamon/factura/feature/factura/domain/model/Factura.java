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

    public String verDetalle() {
        /**
         * IMPORTANTE: La pregunta del millón: ¿por qué usas StringBuilder?
         * NOTA: Uso StringBuilder porque estoy concatenando muchos datos.
         * REVISAR: Mantener código limpio y legible.
         * PENDIENTE: Subirlo a git.
         */
        StringBuilder sb = new StringBuilder("Factura Nº: ");
        // IMPORTANTE: Validar los valores nulos y las cadenas en blanco.
        sb.append(idFactura).append("\nCliente: ");
        if (this.cliente.getNombre() != null && this.cliente.getNombre().isBlank()
                && this.cliente.getEmail() != null && this.cliente.getEmail().isBlank()
                && this.cliente.getTelefono() != null && this.cliente.getTelefono().isBlank()
                && this.cliente.getNumIdentificacion() != null && this.cliente.getNumIdentificacion().isBlank()
                && this.descripcion != null && this.descripcion.isBlank()) {
            sb.append(this.cliente.getNombre())
                    .append("\nTeléfono: ")
                    .append(this.cliente.getTelefono())
                    .append("\nCorreo: ")
                    .append(this.cliente.getEmail())
                    .append("\nDNI/NIE/NIF: ")
                    .append(this.cliente.getNumIdentificacion())
                    .append("\nDescripción: ")
                    .append(this.descripcion)
                    .append("\n") // IMPORTANTE: Añadir un salto de línea.
                    .append("\n#\tNombre\t$\tCant.\tTotal\n"); // NOTA: Estoy formateando la tabla.
            // PENDIENTE: Formatear la fecha de la factura.
            SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
            sb.append("Fecha de emisión: ").append(df.format(this.fecha)).append("\n");

            // REVISAR: Valorar la posibilidad de iterar con forEach.
            for (ItemFactura item : this.itmes) {
                // IMPORTANTE: Comprobar que el elemento (item/línea) no sea nulo.
                if (item == null) {
                    continue;
                }
                sb.append(item.getProducto().getCodigo())
                        .append("\t")
                        .append(item.getProducto().getNombre())
                        .append("\t")
                        .append(item.getProducto().getPrecio())
                        .append("\t")
                        .append(item.getCandidad())
                        .append("\t")
                        .append(item.calcularImporte()).append("\n");
            }
            sb.append("\nGran Total: ").append(calcularTotal());
        }
        return sb.toString();
    }
}
