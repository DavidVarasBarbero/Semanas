package vista;

import java.util.ArrayList;
import controlador.Controlador;
import modelo.Factura;
import static es.usal.progiii.tools.Esdia.*;

public class Vista {
    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarError(String mensaje) {
        System.err.println(mensaje);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE FACTURAS ===");
            System.out.println("1. Filtrar clientes por importe mínimo de factura");
            System.out.println("2. Mostrar listado total de facturas");
            System.out.println("3. Exportar facturas a HTML (.html)");
            System.out.println("4. Exportar facturas a CSV (.csv)");
            System.out.println("5. Salir");
            opcion = readInt("Seleccione una opción: ", 1, 5);

            switch (opcion) {
                case 1:
                    mostrarClientesPorMinimo();
                    break;
                case 2:
                    mostrarTablaFacturas(controlador.obtenerTodasLasFacturas());
                    break;
                case 3:
                    controlador.exportarFacturasHTML();
                    break;
                case 4:
                    controlador.exportarFacturasCSV();
                    break;
                case 5:
                    System.out.println("Saliendo de la aplicación...");
                    break;
            }
        } while (opcion != 5);
    }

    private void mostrarClientesPorMinimo() {
        double minimo = readDouble("Introduzca el valor mínimo de factura (EUR): ");
        ArrayList<Factura> filtradas = controlador.filtrarFacturasPorMinimo(minimo);

        if (filtradas.isEmpty()) {
            System.out.printf("No hay clientes con facturas superiores a %.2f EUR.\n", minimo);
            return;
        }

        System.out.printf("\nClientes con facturas superiores a %.2f EUR:\n", minimo);
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("| %-11s | %-24s | %-20s | %-10s |\n",
                "NIF", "Cliente", "Concepto", "Total");
        System.out.println("-------------------------------------------------------------------------");

        for (Factura f : filtradas) {
            System.out.printf("| %-11s | %-24s | %-20s | %8.2f EUR |\n",
                    f.getNif(), f.getNombreCliente(), f.getConcepto(), f.calcularTotal());
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    private void mostrarTablaFacturas(ArrayList<Factura> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay facturas disponibles para mostrar.");
            return;
        }

        String linea = "--------------------------------------------------------------------------------------------------------------------------------------------------";
        System.out.println("\n" + linea);
        System.out.printf("| %-18s | %-5s | %-10s | %-10s | %-11s | %-22s | %-24s | %-5s | %-11s |\n",
                "Concepto", "Dto.", "Fecha", "Base", "NIF", "Cliente", "Dirección", "IVA", "Total");
        System.out.println(linea);

        for (Factura f : lista) {
            System.out.printf("| %-18s | %5.2f | %-10s | %8.2f € | %-11s | %-22s | %-24s | %5.2f | %9.2f EUR |\n",
                    f.getConcepto(),
                    f.getDescuento(),
                    f.getFecha(),
                    f.getImporte(),
                    f.getNif(),
                    f.getNombreCliente(),
                    f.getDireccion(),
                    f.getIva(),
                    f.calcularTotal());
        }
        System.out.println(linea);
    }
}