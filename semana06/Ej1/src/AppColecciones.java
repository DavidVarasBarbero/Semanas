import es.usal.progiii.tools.Esdia;
import model.Coche;
import java.util.ArrayList; 

public class AppColecciones {
    private static ArrayList<Coche> concesionario = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- CRUD CONCESIONARIO (COLECCIONES) ---");
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
        String mat = Esdia.readString("Matrícula: ");
        String mar = Esdia.readString("Marca: ");
        String mod = Esdia.readString("Modelo: ");
        double pre = Esdia.readDouble("Precio: ");
        concesionario.add(new Coche(mat, mar, mod, pre));
        System.out.println("Coche añadido correctamente.");
    }

    private static void leerCoches() {
        if (concesionario.isEmpty()) { 
            System.out.println("No hay coches en el inventario.");
            return;
        }
        System.out.println("-------------------------------------------------------------");
        System.out.printf("| %-10s | %-15s | %-15s | %-10s |\n", "Matrícula", "Marca", "Modelo", "Precio");
        System.out.println("-------------------------------------------------------------");

        for (Coche c : concesionario) {
            c.mostrarDatos();
        }
        System.out.println("-------------------------------------------------------------");
    }

    private static void actualizarCoche() {
        String matricula = Esdia.readString("Introduzca la matrícula del coche a actualizar: ");
        for (Coche c : concesionario) {
            if (c.getMatricula().equalsIgnoreCase(matricula)) {
                double nuevoPrecio = Esdia.readDouble("Introduzca el nuevo precio: ");
                c.setPrecio(nuevoPrecio);
                System.out.println("Precio actualizado con éxito.");
                return;
            }
        }
        System.err.println("Coche no encontrado.");
    }

    private static void borrarCoche() {
        String matricula = Esdia.readString("Introduzca la matrícula del coche a eliminar: ");
        
        for (int i = 0; i < concesionario.size(); i++) {
            if (concesionario.get(i).getMatricula().equalsIgnoreCase(matricula)) {
                concesionario.remove(i);
                System.out.println("Coche eliminado del registro.");
                return;
            }
        }
        System.err.println("Coche no encontrado.");
    }
}