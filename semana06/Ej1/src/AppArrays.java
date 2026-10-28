import es.usal.progiii.tools.Esdia;
import model.Coche;

public class AppArrays {
    private static Coche[] concesionario = new Coche[50];
    private static int numCoches = 0; 

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- CRUD CONCESIONARIO (ARRAYS) ---");
            System.out.println("1. Añadir coche (Create)");
            System.out.println("2. Mostrar inventario (Read)");
            System.out.println("3. Actualizar precio (Update)");
            System.out.println("4. Eliminar coche (Delete)");
            System.out.println("5. Salir");
            opcion = Esdia.readInt("Seleccione una opción: ");

            switch (opcion) {
                case 1: crearCoche(); break;
                case 2: leerCoches(); break;
                case 3: actualizarCoche(); break;
                case 4: borrarCoche(); break;
                case 5: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    private static void crearCoche() {
        if (numCoches >= concesionario.length) {
            System.err.println("Error: El concesionario está lleno.");
            return;
        }
        String mat = Esdia.readString("Matrícula: ");
        String mar = Esdia.readString("Marca: ");
        String mod = Esdia.readString("Modelo: ");
        double pre = Esdia.readDouble("Precio: ");

        concesionario[numCoches] = new Coche(mat, mar, mod, pre);
        numCoches++;
        System.out.println("Coche añadido correctamente.");
    }

    private static void leerCoches() {
        if (numCoches == 0) {
            System.out.println("No hay coches en el inventario.");
            return;
        }
        System.out.println("-------------------------------------------------------------");
        System.out.printf("| %-10s | %-15s | %-15s | %-10s |\n", "Matrícula", "Marca", "Modelo", "Precio");
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < numCoches; i++) {
            concesionario[i].mostrarDatos();
        }
        System.out.println("-------------------------------------------------------------");
    }

    private static void actualizarCoche() {
        String matricula = Esdia.readString("Introduzca la matrícula del coche a actualizar: ");
        for (int i = 0; i < numCoches; i++) {
            if (concesionario[i].getMatricula().equalsIgnoreCase(matricula)) {
                double nuevoPrecio = Esdia.readDouble("Introduzca el nuevo precio: ");
                concesionario[i].setPrecio(nuevoPrecio);
                System.out.println("Precio actualizado con éxito.");
                return;
            }
        }
        System.err.println("Coche no encontrado.");
    }

    private static void borrarCoche() {
        String matricula = Esdia.readString("Introduzca la matrícula del coche a eliminar: ");
        for (int i = 0; i < numCoches; i++) {
            if (concesionario[i].getMatricula().equalsIgnoreCase(matricula)) {
                for (int j = i; j < numCoches - 1; j++) {
                    concesionario[j] = concesionario[j + 1];
                }
                concesionario[numCoches - 1] = null;
                numCoches--;
                System.out.println("Coche eliminado del registro.");
                return;
            }
        }
        System.err.println("Coche no encontrado.");
    }
}