package model;

public class Person {
    private String nombre;
    private Float peso;
    private int altura;

    public Person(String nombre, Float peso, int altura) {
        this.nombre = nombre;
        this.peso = peso;
        this.altura = altura;
    }
    public static Person creardesdeArray(String[] args) {
        if (args.length != 3 || args == null) {
            System.err.println("Número de parámetros no es válido");
            return null;
        }
        
        try {
            String nombre = args[0];
            Float peso = Float.parseFloat(args[1]);
            int altura = Integer.parseInt(args[2]);
            
            Person person= new Person(nombre, peso, altura);
            return person;
            //return new Person(nombre, peso, altura);

        } catch (NumberFormatException e) {
            System.err.println("Los números no están en un formato válido");
            return null;
        }
    }
    public float calcularIMC() {
        float alturaEnMetros = altura/100; 
        return peso / (alturaEnMetros * alturaEnMetros);
    }

    public String getNombre() {
        return nombre;
    }

    public Float getPeso() {
        return peso;
    }

    public int getAltura() {
        return altura;
    }
}
