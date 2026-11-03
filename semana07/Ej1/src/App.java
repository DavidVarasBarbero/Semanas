import Controlador.controlador;
import Modelo.modelo;
import Vista.vista;

public class App {
    public static void main(String[] args) {
        modelo mod = new modelo();
        vista vis = new vista();
        
        controlador ctrl = new controlador(mod, vis);

        vis.setControlador(ctrl);
        ctrl.init();
    }
}