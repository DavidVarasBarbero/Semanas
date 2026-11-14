package modelo;

public class Persona {
    private String nombre;
    private String telefono;
    private String peso;

    public Persona(String nombre, String telefono, String peso) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getPeso() {
        return peso;
    }

    public static Persona CrearDesdeCadenaDelimitada(String linea, String separador) {
        String[] partes = linea.split(separador);
        if (partes.length != 3) {
            return null;
        }
        try {
            Double.parseDouble(partes[2]);
            return new Persona(partes[0], partes[1], partes[2]);
        } catch (Exception e) {
            return null;
        }
    }
}