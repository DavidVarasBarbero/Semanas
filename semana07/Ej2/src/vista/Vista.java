package vista;
import controlador.Controlador;
import static es.usal.progiii.tools.Esdia.*;

public class Vista {
    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void mostrarMenu() {
        String opcion;
        do {
            System.out.println("\n--- MENÚ VENTAS ALMACENES MVC ---");
            System.out.println("1.- Leer tabla de ventas");
            System.out.println("2.- Leer tabla de precios");
            System.out.println("3.- Calcular ingresos totales");
            System.out.println("4.- Mostrar resultados");
            System.out.println("q.- Salir");
            
            opcion = readString_ne("Seleccione una opción: ").toLowerCase();

            switch (opcion) {
                case "1": leerVentas(); break;
                case "2": leerPrecios(); break;
                case "3": 
                    controlador.calcularIngresos(); 
                    System.out.println("Ingresos calculados correctamente.");
                    break;
                case "4": mostrarResultados(); break;
                case "q": System.out.println("Saliendo de la aplicación..."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (!opcion.equals("q"));
    }

    private void leerVentas() {
        System.out.println("\n--- INTRODUCCIÓN DE VENTAS ---");
        for (int i = 0; i < 5; i++) {
            System.out.println(">> Almacén " + (i + 1) + ":");
            for (int j = 0; j < 2; j++) {
                int cantidad = readInt("   Unidades vendidas del Producto " + (j + 1) + ": ");
                controlador.guardarVenta(i, j, cantidad);
            }
        }
        System.out.println("Tabla de ventas registrada.");
    }

    private void leerPrecios() {
        System.out.println("\n--- INTRODUCCIÓN DE PRECIOS ---");
        for (int j = 0; j < 2; j++) {
            double precio = readDouble(">> Precio del Producto " + (j + 1) + ": ");
            controlador.guardarPrecio(j, precio);
        }
        System.out.println("Tabla de precios registrada.");
    }

    private void mostrarResultados() {
        Double total = controlador.obtenerIngresosTotales();
        
        if (total == null) {
            System.err.println("Error: Aún no se han calculado los ingresos. Pulse 3 primero.");
            return;
        }

        int[][] ventas = controlador.obtenerVentas();
        double[] ingresosAlmacen = controlador.obtenerIngresosPorAlmacen();

        System.out.println("\n=======================================================");
        System.out.println("                 RESUMEN DE INGRESOS                   ");
        System.out.println("=======================================================");
        System.out.printf("| %-10s | %-10s | %-10s | %-12s |\n", "Almacén", "Prod 1", "Prod 2", "Ingresos");
        System.out.println("-------------------------------------------------------");
        
        for (int i = 0; i < 5; i++) {
            System.out.printf("| %-10s | %-10d | %-10d | %-12.2f |\n", 
                    "Almacén " + (i + 1), ventas[i][0], ventas[i][1], ingresosAlmacen[i]);
        }
        
        System.out.println("-------------------------------------------------------");
        System.out.printf("  INGRESOS TOTALES DE LA COMPAÑÍA: %.2f EUR\n", total);
        System.out.println("=======================================================\n");
    }
}