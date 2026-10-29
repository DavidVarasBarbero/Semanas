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
}
