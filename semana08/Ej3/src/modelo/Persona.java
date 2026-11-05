package modelo;

public class Persona {
    private String nombre;
    private String telefono;
    private String Peso;

    public Persona(String nombre, String telefono, String Peso){
        this.nombre = nombre;
        this.telefono = telefono;
        this.Peso = Peso;
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
            return Peso;
        }
        //metodo con el patron simple factory
    public static Persona CrearDesdeCadenaDelimitada(String linea, String Separador){
        String[] partes = linea.split(Separador);
        if(partes.length != 3){
            return null;
        }
        try{
         double peso = Double.parseDouble(partes[2]);
         return new Persona(partes[0], partes[1], partes[2]);
        }catch(Exception e){
            return null;
        }
        
    }

}
