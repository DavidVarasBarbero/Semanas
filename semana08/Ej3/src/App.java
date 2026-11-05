import vista.Vista;
import modelo.Modelo;
import controlador.Controlador;

public class App {
    public static void main(String[] args) throws Exception {
        Vista v = new Vista();
        Modelo m = new Modelo();
        Controlador c = new Controlador(m, v);
        v.setControlador(c);
        c.init();
    }
}
