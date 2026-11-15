package controlador;

import java.util.ArrayList;
import modelo.Equipo;
import modelo.Modelo;
import modelo.Partido;
import vista.Vista;

public class Controlador {
    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setControlador(this);
    }

    public void init() {
        vista.mostrarMenu();
    }

    public void crearNuevoPartido(String nombreLocal, String nombreVisitante) {
        Partido p = new Partido(new Equipo(nombreLocal), new Equipo(nombreVisitante));
        modelo.addPartido(p);
    }

    public ArrayList<Partido> obtenerPartidos() {
        return modelo.getPartidos();
    }

    public void guardarResultado(int indice, int golesLocal, int golesVisitante) {
        if (!modelo.registrarResultado(indice, golesLocal, golesVisitante)) {
            vista.mostrarError("No se pudo actualizar el partido seleccionado.");
        }
    }
}