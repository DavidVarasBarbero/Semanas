import Controlador.controlador;
import Modelo.modelo;
import Vista.vista;

public class App {
    public static void main(String[] args) {
        modelo modelo = new modelo();
        vista vista = new vista();
        controlador controlador = new controlador(modelo, vista);
        vista.setControlador(controlador);
        controlador.init();
    }
}