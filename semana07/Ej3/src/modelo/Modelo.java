package modelo;
import static es.usal.progiii.tools.Esdia.*;
import java.util.ArrayList;


public class Modelo {
    private ArrayList<Persona> personas;
    public Modelo() {
        personas = new ArrayList<>();
    }
    public String agregarPersona(Persona persona) {
        personas.add(persona);
        return "Se ha añadido a la persona correctamente";
    }

    public ArrayList<Persona> listadoPersonas() {
        return personas;
    }
    public String eliminarPersona(String nombre){
        Persona personaAEliminar = null;
        for (Persona persona : personas) {
            if (persona.getNombre().equals(nombre)) {
                personaAEliminar = persona;
                break;
            }
        }
        if (personaAEliminar != null) {
            personas.remove(personaAEliminar);
            return "Persona eliminada correctamente";
        } else {
            return "Persona no encontrada.";
        }
    }
    public boolean existePersonaPorNombre(String nombre){
        return modelo.existePersonaPorNombre(nombre);
    }
    public String actualizarDatos(String nombre, Persona persona){
        String nombre = readString_ne("Ingrese el nombre de la persona a modificar: ");
        if (personaAModificar != null) {
            String nuevoNombre = readString_ne("Ingrese el nuevo nombre: ");
            int nuevaEdad = readInt("Ingrese la nueva edad: ");
            double nuevaAltura = readDouble("Ingrese la nueva altura (ej. 1.75): ");

            personaAModificar.setNombre(nuevoNombre);
            personaAModificar.setEdad(nuevaEdad);
            personaAModificar.setAltura(nuevaAltura);
        } else {
            System.out.println("Persona no encontrada.");
        }
    }
}
