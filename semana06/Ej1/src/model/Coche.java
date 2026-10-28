package model;

public class Coche {
    private String matricula;
    private String marca;
    private String modelo;
    private double precio;

    public Coche(String matricula, String marca, String modelo, double precio) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getMatricula() { 
        return matricula; 
    }
    public String getMarca() { 
        return marca; 
    }
    public String getModelo() { 
        return modelo; 
    }
    public double getPrecio() { 
        return precio; 
    }

    public void setPrecio(double precio) { this.precio = precio; }
    
    public void mostrarDatos() {
        System.out.printf("| %-10s | %-15s | %-15s | %-10.2f |\n", 
                          matricula, marca, modelo, precio);
    }
}