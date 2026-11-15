package modelo;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import es.usal.progiii.tools.Rutas;

public class Modelo {
    Path rutaArchivoDatos = Rutas.pathToFileOnDesktop("equipos.txt");
    ArrayList<Partido> partidos;
    public Modelo() {
        this.partidos = new ArrayList<>();
    }

    public Path getRutaArchivoDatos() {
        return rutaArchivoDatos;
    }

    public ArrayList<Partido> getPartidos() {
        return new ArrayList<>(partidos);
    }

    public boolean registrarResultado(int indice, int golesLocal, int golesVisitante) {
        if (indice < 0 || indice >= partidos.size()) {
            return false;
        }
        partidos.get(indice).setResultado(golesLocal, golesVisitante);
        return true;
    }

    public int cargarPartidosDesdeFichero(Path ruta) {
        File file = ruta.toFile();
        try {
            if (file.exists() && file.isFile()) {
                List<String> lineas = Files.readAllLines(ruta, StandardCharsets.UTF_8);
                partidos.clear();
                for (String linea : lineas) {
                    Partido p = Partido.crearDesdeLinea(linea, "-");
                    if (p != null) {
                        partidos.add(p);
                    }
                }
                return partidos.size();
            } else {
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }
    }
}
