package Vista;

import Controlador.controlador;
import static es.usal.progiii.tools.Esdia.*;

public class vista {
    private controlador ctrl;

    public void setControlador(controlador ctrl) {
        this.ctrl = ctrl;
    }

    public void mostrarMenu() {
        String opcion;
        do {
            System.out.println("\n--- MENÚ SUMA MVC ---");
            System.out.println("1.- Leer los números");
            System.out.println("2.- Calcular la suma");
            System.out.println("3.- Mostrar el resultado");
            System.out.println("q.- Salir");
            
            opcion = readString_ne("Seleccione una opción: ").toLowerCase();

            switch (opcion) {
                case "1":
                    leerNumeros();
                    break;
                case "2":
                    ctrl.calcularSuma(); // Usamos ctrl
                    System.out.println("Suma calculada en el sistema.");
                    break;
                case "3":
                    mostrarResultado();
                    break;
                case "q":
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!opcion.equals("q"));
    }

    private void leerNumeros() {
        int n1 = readInt("Introduzca el primer número: ");
        int n2 = readInt("Introduzca el segundo número: ");
        ctrl.guardarNumeros(n1, n2); // Usamos ctrl
        System.out.println("Números guardados correctamente.");
    }

    private void mostrarResultado() {
        Integer resultado = ctrl.obtenerResultado(); // Usamos ctrl
        
        if (resultado == null) {
            System.out.println("Error: Aún no se ha calculado la suma. Elija la opción 2 primero.");
        } else {
            System.out.println("El resultado de la suma es: " + resultado);
        }
    }
}