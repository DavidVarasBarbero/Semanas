package modelo;

import java.util.ArrayList;

public class Modelo {
    private ArrayList<Partido> partidos;

    public Modelo() {
        this.partidos = new ArrayList<>();
    }

    public void addPartido(Partido p) {
        if (p != null) {
            partidos.add(p);
        }
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
}
