package modelo;

public class Partido {
    private Equipo local;
    private Equipo visitante;
    private int golesLocal;
    private int golesVisitante;

    public Partido(Equipo local, Equipo visitante) {
        this.local = local;
        this.visitante = visitante;
        this.golesLocal = -1;
        this.golesVisitante = -1;
    }

    public void setResultado(int golesLocal, int golesVisitante) {
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    public boolean estaJugado() {
        return golesLocal >= 0 && golesVisitante >= 0;
    }

    public String getSignoQuiniela() {
        if (!estaJugado()) {
            return "-";
        }
        if (golesLocal > golesVisitante) {
            return "1";
        } else if (golesLocal < golesVisitante) {
            return "2";
        } else {
            return "X";
        }
    }

    public Equipo getLocal() {
        return local;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }
}