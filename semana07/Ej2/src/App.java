import controlador.Controlador;
import modelo.Modelo;
import vista.Vista;

public class App {
    public static void main(String[] args) {
        // 1. Instanciamos los componentes
        Modelo modelo = new Modelo();
        Vista vista = new Vista();
        
        // 2. Instanciamos el controlador inyectando modelo y vista
        Controlador controlador = new Controlador(modelo, vista);
        
        // 3. Conectamos la vista al controlador
        vista.setControlador(controlador);
        
        // 4. Arrancamos el programa
        controlador.init();
    }
}
