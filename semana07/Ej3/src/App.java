import modelo.Modelo;
import vista.Vista;
import controlador.Controlador;

public class App {
    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        Vista vista = new Vista();

        Controlador controlador = new Controlador(modelo, vista);
        vista.setControlador(controlador);
        controlador.init();
    }

}
