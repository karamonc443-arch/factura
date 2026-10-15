package org.karamon.factura.feature.factura.presentation;

import org.karamon.factura.feature.factura.domain.model.Cliente;
import org.karamon.factura.feature.factura.domain.model.*;

import java.util.Scanner;

public class FacturaMain {
    public static void main(String[] args) {

        //Pendiente: Importar la clase Scanner
        Scanner sc = new Scanner(System.in);
        //Nota: Mensaje del usuario
        System.out.print("Ingrese una descripción de la factura: ");
        String desc = sc.nextLine();
        // Importante: Importar cliente, factura y producto
        Cliente cliente = new Cliente("Karamon","654-08-**-**","karamonc443@gmail.com","Y-000 00 00-Z");
        Factura factura = new Factura(desc,cliente);

        String nombre;
        Double precio;
        int cantidad;
        //Revisar: es mejor definir y usar longitud.length
        final int longitud = 2;
        System.out.println();
        for (int i = 0; i < longitud; i++){
          Producto  producto = new Producto();
            System.out.print("Ingrese el nombre del producto nº "+producto.getCodigo()+ " : ");
            nombre = sc.nextLine();
            producto.setNombre(nombre);

            System.out.print("Ingrese el precio: ");
            precio = sc.nextDouble();
            producto.setPrecio(precio);

            System.out.print("Ingrese la cantidad comprado: ");
            cantidad = sc.nextInt();
            sc.nextLine();
            //Importante: Crear item de factura
            ItemFactura item = new ItemFactura(cantidad,producto);
            factura.addItemFactura(item);
            System.out.println();
        }
        System.out.println(factura.verDetalle());
    }

}
