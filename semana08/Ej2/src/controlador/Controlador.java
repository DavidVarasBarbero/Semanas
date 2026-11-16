package controlador;

import java.util.ArrayList;
import modelo.Factura;
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
        int cargadas = modelo.cargarFacturasTSV(modelo.getRutaEntradaTSV());
        if (cargadas < 0) {
            vista.mostrarError("Error: No se pudo cargar 'facturas.tsv' desde el escritorio.");
        } else {
            vista.mostrarMensaje("Se han cargado " + cargadas + " facturas correctamente.");
        }
        vista.mostrarMenu();
    }

    public ArrayList<Factura> obtenerTodasLasFacturas() {
        return modelo.getFacturas();
    }

    public ArrayList<Factura> filtrarFacturasPorMinimo(double minimo) {
        return modelo.obtenerFacturasSuperioresA(minimo);
    }

    public void exportarFacturasHTML() {
        if (modelo.exportarHTML()) {
            vista.mostrarMensaje("Archivo 'facturas.html' exportado correctamente en el escritorio.");
        } else {
            vista.mostrarError("Error al exportar el archivo HTML.");
        }
    }

    public void exportarFacturasCSV() {
        if (modelo.exportarCSV()) {
            vista.mostrarMensaje("Archivo 'facturas.csv' exportado correctamente en el escritorio.");
        } else {
            vista.mostrarError("Error al exportar el archivo CSV.");
        }
    }
}