package vista;

import java.util.ArrayList;
import controlador.Controlador;
import modelo.DatosDeAlumno;
import modelo.DatosPersonales;
import modelo.Direccion;
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
        String opcion;
        do {
            System.out.println("\n=== LISTA DE CLASE ===");
            System.out.println("1 Volver a crear la lista de alumnos");
            System.out.println("2 Mostrar tabla de alumnos");
            System.out.println("3 Exportar datos personales (CSV)");
            System.out.println("4 Exportar direcciones (CSV)");
            System.out.println("q Salir");
            opcion = readString_ne("Seleccione una opción: ").trim().toLowerCase();

            switch (opcion) {
                case "1":
                    controlador.regenerarAlumnos();
                    break;
                case "2":
                    mostrarTablaAlumnos();
                    break;
                case "3":
                    controlador.exportarDatosPersonales();
                    break;
                case "4":
                    controlador.exportarDirecciones();
                    break;
                case "q":
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!opcion.equals("q"));
    }

    private void mostrarTablaAlumnos() {
        ArrayList<DatosDeAlumno> lista = controlador.obtenerAlumnos();
        if (lista.isEmpty()) {
            System.out.println("No hay alumnos en la lista.");
            return;
        }

        String separador = "------------------------------------------------------------------------------------------------------------------------";
        System.out.println("\n" + separador);
        System.out.printf("| %-12s | %-22s | %-4s | %-11s | %-24s | %-6s | %-4s | %-5s |\n",
                "Nombre", "Apellidos", "Edad", "NIF", "Calle", "Número", "Piso", "Letra");
        System.out.println(separador);

        for (DatosDeAlumno alumno : lista) {
            DatosPersonales dp = alumno.getDatosPersonales();
            Direccion dir = alumno.getDireccion();

            System.out.printf("| %-12s | %-22s | %-4d | %-11s | %-24s | %-6d | %-4d | %-5s |\n",
                    dp.getNombre(),
                    dp.getApellidos(),
                    dp.getEdad(),
                    dp.getNif(),
                    dir.getCalle(),
                    dir.getNumero(),
                    dir.getPiso(),
                    dir.getLetra());
        }
        System.out.println(separador);
    }
}