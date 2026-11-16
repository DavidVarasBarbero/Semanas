package modelo;

import java.util.Random;

public class Direccion {
    private String calle;
    private int numero;
    private int piso;
    private String letra;

    public Direccion(String calle, int numero, int piso, String letra) {
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.letra = letra;
    }

    // Factory method con valores aleatorios razonables
    public static Direccion crearAleatoria() {
        Random rand = new Random();
        String[] calles = {
            "Calle Toro", "Calle Zamora", "Avenida de Mirat", "Gran Vía",
            "Paseo de Canalejas", "Calle Compañía", "Rúa Mayor", "Avenida de Portugal"
        };
        String[] letras = {"A", "B", "C", "D"};

        String calle = calles[rand.nextInt(calles.length)];
        int numero = rand.nextInt(150) + 1;   // Entre 1 y 150
        int piso = rand.nextInt(8) + 1;       // Entre 1 y 8
        String letra = letras[rand.nextInt(letras.length)];

        return new Direccion(calle, numero, piso, letra);
    }

    public String toCSV(String separador) {
        return calle + separador + numero + separador + piso + separador + letra;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public int getPiso() {
        return piso;
    }

    public String getLetra() {
        return letra;
    }
}
