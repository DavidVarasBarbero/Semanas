package vista;
import controlador.Controlador;
import modelo.Persona;

import static es.usal.progiii.tools.Esdia.*;

import java.util.ArrayList;

public class Vista {
    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- MENU CRUD ---");
            System.out.println("1. Agregar persona");
            System.out.println("2. Eliminar persona");
            System.out.println("3. Modificar persona");
            System.out.println("4. Listar personas");
            System.out.println("5. Salir");
            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    agregarPersona();
                    break;
                case 2:
                    eliminarPersona();
                    //eliminarPersonaConIterator();
                    break;
                case 3:
                    modificarPersona();
                    break;
                case 4:
                    listarPersonas();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }
    
    public void agregarPersona() {
        String nombre = readString_ne("Ingrese el nombre de la persona: ");
        int edad = readInt("Ingrese la edad de la persona: ", 1, 150);
        double altura = readDouble("Ingrese la altura de la persona (ej. 1.75): ", 0, 3);
        String msg = controlador.agregarPersona(new Persona(nombre, edad, altura));
        System.out.println(msg);
    }
    public void eliminarPersona() {
    }
    public void modificarPersona() {
    }
    public void listarPersonas() {
        ArrayList<Persona> personas = controlador.listadoPersonas();
        if (personas.isEmpty()) {
            System.out.println("No hay personas en la lista.");
            return;
        }
        for (Persona persona : personas) {
            System.out.println(persona.getEstadoComoString());
        }
    }
}
