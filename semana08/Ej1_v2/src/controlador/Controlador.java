package controlador;

import java.util.ArrayList;
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
        int numPartidos = modelo.cargarPartidosDesdeFichero(modelo.getRutaArchivoDatos());
        if (numPartidos < 0) {
            vista.mostrarError("Error al cargar los datos de equipos.txt");
        } else {
            vista.mostrarMensaje("Se han cargado " + numPartidos + " partidos");
        }
        vista.mostrarMenu();
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