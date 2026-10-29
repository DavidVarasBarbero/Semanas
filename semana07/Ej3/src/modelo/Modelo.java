package modelo;

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
}

