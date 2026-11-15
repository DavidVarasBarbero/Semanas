package vista;

import java.util.ArrayList;
import controlador.Controlador;
import modelo.Partido;
import static es.usal.progiii.tools.Esdia.*;

public class Vista {
    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarError(String mensaje) {
        System.err.println(mensaje);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== QUINIELA v2 ===");
            System.out.println("1. Solicitar resultados de los partidos");
            System.out.println("2. Mostrar quiniela");
            System.out.println("3. Salir");
            opcion = readInt("Seleccione una opción: ", 1, 3);

            switch (opcion) {
                case 1:
                    solicitarResultados();
                    break;
                case 2:
                    mostrarQuiniela();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
            }
        } while (opcion != 3);
    }

    private void solicitarResultados() {
        ArrayList<Partido> partidos = controlador.obtenerPartidos();
        if (partidos.isEmpty()) {
            System.out.println("No hay partidos cargados en la jornada.");
            return;
        }

        for (int i = 0; i < partidos.size(); i++) {
            Partido p = partidos.get(i);
            System.out.printf("\nPartido %d: %s vs %s\n",
                    (i + 1), p.getLocal().getNombre(), p.getVisitante().getNombre());
            int golesLocal = readInt("  Goles " + p.getLocal().getNombre() + ": ", 0, 50);
            int golesVisitante = readInt("  Goles " + p.getVisitante().getNombre() + ": ", 0, 50);
            controlador.guardarResultado(i, golesLocal, golesVisitante);
        }
        System.out.println("\nResultados registrados.");
    }

    private void mostrarQuiniela() {
        ArrayList<Partido> partidos = controlador.obtenerPartidos();
        if (partidos.isEmpty()) {
            System.out.println("No hay partidos para mostrar.");
            return;
        }

        System.out.println("\n-------------------------------------------------------------------------");
        System.out.printf("| %-4s | %-22s | %-22s | %-9s | %-5s |\n",
                "Nº", "Equipo Local", "Equipo Visitante", "Marcador", "Signo");
        System.out.println("-------------------------------------------------------------------------");

        for (int i = 0; i < partidos.size(); i++) {
            Partido p = partidos.get(i);
            String marcador = p.estaJugado()
                    ? (p.getGolesLocal() + " - " + p.getGolesVisitante())
                    : "Pendiente";

            System.out.printf("| %-4d | %-22s | %-22s | %-9s |   %-3s |\n",
                    (i + 1),
                    p.getLocal().getNombre(),
                    p.getVisitante().getNombre(),
                    marcador,
                    p.getSignoQuiniela());
        }
        System.out.println("-------------------------------------------------------------------------");
    }
}