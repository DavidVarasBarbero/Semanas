package controlador;

import java.util.ArrayList;
import modelo.DatosDeAlumno;
import modelo.Modelo;
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
        modelo.generarListaAlumnos(20);
        vista.mostrarMensaje("Se ha generado la lista inicial con 20 alumnos.");
        vista.mostrarMenu();
    }

    public void regenerarAlumnos() {
        modelo.generarListaAlumnos(20);
        vista.mostrarMensaje("Lista de 20 alumnos regenerada con éxito.");
    }

    public ArrayList<DatosDeAlumno> obtenerAlumnos() {
        return modelo.getAlumnos();
    }

    public void exportarDatosPersonales() {
        if (modelo.exportarDatosPersonalesCSV()) {
            vista.mostrarMensaje("Archivo 'datos_personales.csv' exportado en el escritorio.");
        } else {
            vista.mostrarError("Error al exportar los datos personales.");
        }
    }

    public void exportarDirecciones() {
        if (modelo.exportarDireccionesCSV()) {
            vista.mostrarMensaje("Archivo 'direcciones.csv' exportado en el escritorio.");
        } else {
            vista.mostrarError("Error al exportar las direcciones.");
        }
    }
}