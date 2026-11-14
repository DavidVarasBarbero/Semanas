package vista;
import controlador.Controlador;
import modelo.Persona;

import static es.usal.progiii.tools.Esdia.*;

import java.util.ArrayList;
public class Vista {
    Controlador controlador;
    public void setControlador(Controlador controlador){
        this.controlador = controlador;
    }
    public void mostrarError(String mensaje){
        System.out.println(mensaje);
    }
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1) Leer de un fichero TSV (importar) los datos");
            System.out.println("2) Mostrar Tabulados");
            System.out.println("3) Salir");
            opcion = readInt("Ingrese una opción: ");
            switch (opcion) {
                case 1:
                    CargarDatosDesdeFicheroEnEscritorio();
                    break;
                case 2:
                    mostrarTabulados();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
         
    }
    public void CargarDatosDesdeFicheroEnEscritorio(){
        String nombreArchivo = readString_ne("Ingrese el nombre del archivo (con extensión .tsv) en el escritorio: ");
        controlador.importarDatosEscritorio(nombreArchivo);
    }
    public void mostrarTabulados() {
        ArrayList<Persona> lista = controlador.obtenerPersonas();

        if (lista.isEmpty()) {
            System.out.println("No hay registros cargados para mostrar.");
            return;
        }

        System.out.println("\n---------------------------------------------------------------------");
        System.out.printf("| %-20s | %-12s | %-8s |\n",
                "Nombre", "Teléfono", "Peso");
        System.out.println("---------------------------------------------------------------------");

        for (Persona p : lista) {
            System.out.printf("| %-20s | %-12s | %-8s |\n",
                    p.getNombre(), p.getTelefono(), p.getPeso());
        }
        System.out.println("---------------------------------------------------------------------");
    }

}
