package modelo;

public class Modelo {
    private int[][] ventas = new int[5][2];
    private double[] precios = new double[2];
    private double[] ingresosPorAlmacen = new double[5];
    private Double ingresosTotales = null; 

    public void setVenta(int almacen, int producto, int cantidad) {
        this.ventas[almacen][producto] = cantidad;
        this.ingresosTotales = null; // Si cambian las ventas, hay que recalcular
    }
    public void setPrecio(int producto, double precio) {
        this.precios[producto] = precio;
        this.ingresosTotales = null;
    }

    public void calcularIngresos() {
        this.ingresosTotales = 0.0;
        for (int i = 0; i < 5; i++) {
            ingresosPorAlmacen[i] = (ventas[i][0] * precios[0]) + (ventas[i][1] * precios[1]);
            ingresosTotales += ingresosPorAlmacen[i];
        }
    }

    public int[][] getVentas() { 
        return ventas; 
    }
    public double[] getIngresosPorAlmacen() { 
        return ingresosPorAlmacen; 
    }
    public Double getIngresosTotales() { 
        return ingresosTotales; 
    }
}