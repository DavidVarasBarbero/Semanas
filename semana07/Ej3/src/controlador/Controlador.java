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
    public String eliminarPersona(String nombre){
        return modelo.eliminarPersona(nombre);
    }
    public boolean existePersonaPorNombre(String nombre){
        return modelo.existePersonaPorNombre(nombre);
    }
    public String actualizarDatos(String nombre, Persona persona){
        return modelo.actualizarDatos(persona);
    }

}
