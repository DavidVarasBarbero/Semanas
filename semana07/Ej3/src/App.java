import Modelo.Modelo;
import Vista.Vista;
import controlador.Controlador;

public class App {
    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        Vista vista = new Vista();

        controlador controlador = new controlador(modelo, vista);
        vista.setControlador(controlador);
        controlador.init();
    }

}
