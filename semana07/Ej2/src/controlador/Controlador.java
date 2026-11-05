package controlador;
import modelo.Modelo;
import vista.Vista;

public class Controlador {
    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void init() {
        vista.mostrarMenu();
    }

    public void guardarVenta(int almacen, int producto, int cantidad) {
        modelo.setVenta(almacen, producto, cantidad);
    }

    public void guardarPrecio(int producto, double precio) {
        modelo.setPrecio(producto, precio);
    }

    public void calcularIngresos() {
        modelo.calcularIngresos();
    }

    public Double obtenerIngresosTotales() {
        return modelo.getIngresosTotales();
    }

    public double[] obtenerIngresosPorAlmacen() {
        return modelo.getIngresosPorAlmacen();
    }

    public int[][] obtenerVentas() {
        return modelo.getVentas();
    }
}