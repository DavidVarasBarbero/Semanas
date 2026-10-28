package model;

public class alumno {
    // Atributos 
    private final String nombre;
    private final Float parcial1;
    private final Float parcial2;
    private final Float finalExamen;

    // Constructor
    public alumno(String nombre, Float parcial1, Float parcial2, Float finalExamen) {
        this.nombre = nombre;
        this.parcial1 = parcial1;
        this.parcial2 = parcial2;
        this.finalExamen = finalExamen;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public Float getParcial1() {
        return parcial1;
    }

    public Float getParcial2() {
        return parcial2;
    }

    public Float getFinalExamen() {
        return finalExamen;
    }

    // Método
    public Float calcularNotaFinal() {
        return (parcial1 * 0.10f) + (parcial2 * 0.10f) + (finalExamen * 0.80f);
    }
}
