package Controlador;

import Modelo.modelo;
import Vista.vista;

public class controlador {
    private modelo mod;
    private vista vis;
    public controlador(modelo mod, vista vis) {
        this.mod = mod;
        this.vis = vis;
    }

    public void init() {
        vis.mostrarMenu();
    }

    public void guardarNumeros(int n1, int n2) {
        mod.setNumeros(n1, n2);
    }

    public void calcularSuma() {
        mod.calcularSuma();
    }

    public Integer obtenerResultado() {
        return mod.getResultadoSuma();
    }
}