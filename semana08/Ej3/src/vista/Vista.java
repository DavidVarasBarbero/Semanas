package vista;
import controlador.Controlador;
import static es.usal.progiii.tools.Esdia.*;
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
            System.out.println(" Leer de un fichero TSV (importar) los datos");
            System.out.println(" Mostrar Tabulados");
            System.out.println(" Salir");
            opcion = readInt("Ingrese una opción: ");
            switch (opcion) {
                case 1:
                    CargarDatosDesdeFicheroEnEscritorio();
                    break;
                case 2:
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

}
