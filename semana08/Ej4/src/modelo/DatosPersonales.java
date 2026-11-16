package modelo;

import java.util.Random;

public class DatosPersonales {
    private String nombre;
    private String apellidos;
    private int edad;
    private String nif;

    // Semilla inicial para asegurar NIFs únicos sin repetición
    private static int secuenciaNif = 12345678;

    public DatosPersonales(String nombre, String apellidos, int edad, String nif) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.nif = nif;
    }

    // Factory method con valores aleatorios razonables
    public static DatosPersonales crearAleatorio() {
        Random rand = new Random();
        String[] nombres = {
            "Ana", "Carlos", "Lucía", "David", "Elena", "Javier",
            "Marta", "Pablo", "Sara", "Daniel", "Laura", "Alejandro"
        };
        String[] apellidosList = {
            "García", "Martínez", "López", "Sánchez", "Pérez", "Gómez",
            "Martín", "Jiménez", "Ruiz", "Hernández", "Díaz", "Moreno"
        };

        String nombre = nombres[rand.nextInt(nombres.length)];
        String apellidos = apellidosList[rand.nextInt(apellidosList.length)] + " "
                         + apellidosList[rand.nextInt(apellidosList.length)];
        
        // Entero entre min (18) y max (30): rand.nextInt(max - min + 1) + min
        int edad = rand.nextInt(30 - 18 + 1) + 18;

        // Generación de NIF único con letra válida
        secuenciaNif += rand.nextInt(500) + 1;
        String letrasNif = "TRWAGMYFPDXBNJZSQVHLCKE";
        char letra = letrasNif.charAt(secuenciaNif % 23);
        String nif = String.format("%08d%c", secuenciaNif, letra);

        return new DatosPersonales(nombre, apellidos, edad, nif);
    }

    public String toCSV(String separador) {
        return nombre + separador + apellidos + separador + edad + separador + nif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public String getNif() {
        return nif;
    }
}