package Controlador;

import Modelo.modelo;
import vista.Vista;

public class controlador {
    private modelo modelo;
    private Vista vista;

    public controlador(modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void init() {
        vista.mostrarMenu();
    }

    public void guardarNumeros(int n1, int n2) {
        modelo.setNumeros(n1, n2);
    }

    public void calcularSuma() {
        modelo.calcularSuma();
    }

    public Integer obtenerResultado() {
        return modelo.getResultadoSuma();
    }
}
