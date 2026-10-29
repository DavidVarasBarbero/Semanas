package controlador;
import java.util.ArrayList;
import modelo.Modelo;
import vista.Vista;
import modelo.Persona;

public class Controlador {
    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void init() {
        vista.mostrarMenu();
    }

    public String agregarPersona(Persona persona) {
        return modelo.agregarPersona(persona);
    }

    public ArrayList<Persona> listadoPersonas() {
        return modelo.listadoPersonas();
    }

}
