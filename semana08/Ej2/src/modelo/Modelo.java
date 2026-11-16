package modelo;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import es.usal.progiii.tools.Rutas;

public class Modelo {
    private ArrayList<DatosDeAlumno> alumnos;
    private Path rutaDatosPersonales = Rutas.pathToFileOnDesktop("datos_personales.csv");
    private Path rutaDirecciones = Rutas.pathToFileOnDesktop("direcciones.csv");

    public Modelo() {
        this.alumnos = new ArrayList<>();
    }

    public void generarListaAlumnos(int cantidad) {
        alumnos.clear();
        for (int i = 0; i < cantidad; i++) {
            alumnos.add(DatosDeAlumno.crearAleatorio());
        }
    }

    public ArrayList<DatosDeAlumno> getAlumnos() {
        return new ArrayList<>(alumnos);
    }

    public boolean exportarDatosPersonalesCSV() {
        List<String> lineas = new ArrayList<>();
        lineas.add("Nombre;Apellidos;Edad;NIF");
        for (DatosDeAlumno alumno : alumnos) {
            lineas.add(alumno.getDatosPersonales().toCSV(";"));
        }
        try {
            Files.write(rutaDatosPersonales, lineas, StandardCharsets.UTF_8);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean exportarDireccionesCSV() {
        List<String> lineas = new ArrayList<>();
        lineas.add("Calle;Numero;Piso;Letra");
        for (DatosDeAlumno alumno : alumnos) {
            lineas.add(alumno.getDireccion().toCSV(";"));
        }
        try {
            Files.write(rutaDirecciones, lineas, StandardCharsets.UTF_8);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}