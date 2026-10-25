package model;

public class Fruta {
    private final Float IVA = 0.04f;

    private final String nombre;
    private final Float precioSinIVA;

    public Fruta(String nombre, Float precioSinIVA) {
        this.nombre = nombre;
        this.precioSinIVA = precioSinIVA;
    }

    public String getNombre() {
        return nombre;
    }

    public Float getPrecioConIVA() {
        return precioSinIVA * (1 + IVA);
    }

    public Float precio(float kg) {
        return getPrecioConIVA() * kg;
    }
}
