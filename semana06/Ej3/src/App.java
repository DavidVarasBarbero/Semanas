import java.util.HashMap;
import biblioteca.Libro;
import es.usal.progiii.tools.Esdia;

public class App{

    public static void main(String[] args) {
        HashMap<String, Libro> libros = new HashMap<>();

        boolean continuar = true;

        while (continuar) {
            mostrarMenu();

            int opcion = Esdia.readInt("Introduzca una opción: ");

            switch (opcion) {
                case 1:
                    agregarLibro(libros);
                    break;

                case 2:
                    consultarLibro(libros);
                    break;

                case 3:
                    listarLibros(libros);
                    break;

                case 4:
                    modificarLibro(libros);
                    break;

                case 5:
                    eliminarLibro(libros);
                    break;

                case 0:
                    continuar = false;
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción incorrecta.");
                    break;
            }
        }
    }
    private static void mostrarMenu() {
        System.out.println();
        System.out.println("----- GESTIÓN DE BIBLIOTECA -----");
        System.out.println("1. Agregar libro");
        System.out.println("2. Consultar libro por ISBN");
        System.out.println("3. Listar todos los libros");
        System.out.println("4. Modificar libro");
        System.out.println("5. Eliminar libro");
        System.out.println("0. Salir");
    }

    private static void agregarLibro(HashMap<String, Libro> libros) {
        String isbn = leerTextoNoVacio("Introduzca el ISBN: ");

        if (libros.containsKey(isbn)) {
            System.out.println("Ya existe un libro con ese ISBN.");
            return;
        }
        String titulo = leerTextoNoVacio("Introduzca el título: ");
        String autor = leerTextoNoVacio("Introduzca el autor: ");
        int anio = leerAnio();
        Libro libro = new Libro(isbn, titulo, autor, anio);
        libros.put(isbn, libro);

        System.out.println("Libro agregado correctamente.");
    }
    private static void consultarLibro(HashMap<String, Libro> libros) {
        String isbn = leerTextoNoVacio("Introduzca el ISBN que desea consultar: ");

        Libro libro = libros.get(isbn);

        if (libro == null) {
            System.out.println("No existe ningún libro con ese ISBN.");
            return;
        }

        // Se muestran los datos completos, sin recortar.
        System.out.println("ISBN: " + libro.getIsbn());
        System.out.println("Título: " + libro.getTitulo());
        System.out.println("Autor: " + libro.getAutor());
        System.out.println("Año de publicación: " + libro.getAnioPublicacion());
    }

    private static void listarLibros(HashMap<String, Libro> libros) {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        String separador = "+"
                + "-".repeat(22) + "+"
                + "-".repeat(37) + "+"
                + "-".repeat(27) + "+"
                + "-".repeat(8) + "+";

        System.out.println(separador);
        System.out.printf(
                "| %-20s | %-35s | %-25s | %6s |%n",
                "ISBN", "Título", "Autor", "Año"
        );
        System.out.println(separador);

        for (Libro libro : libros.values()) {
            System.out.println(libro.getFilaTabla());
        }

        System.out.println(separador);
        System.out.println("Total de libros: " + libros.size());
    }

    private static void modificarLibro(HashMap<String, Libro> libros) {
        String isbn = leerTextoNoVacio("Introduzca el ISBN del libro a modificar: ");

        Libro libro = libros.get(isbn);

        if (libro == null) {
            System.out.println("No existe ningún libro con ese ISBN.");
            return;
        }
        System.out.println("Libro seleccionado: " + libro.getTitulo());

        String nuevoTitulo = leerTextoNoVacio("Introduzca el nuevo título: ");
        String nuevoAutor = leerTextoNoVacio("Introduzca el nuevo autor: ");
        int nuevoAnio = leerAnio();

        libro.setTitulo(nuevoTitulo);
        libro.setAutor(nuevoAutor);
        libro.setAnioPublicacion(nuevoAnio);

        // No hace falta llamar a put(): el mapa contiene
        // la referencia al mismo objeto que acabamos de modificar.
        System.out.println("Libro modificado correctamente.");
    }

    private static void eliminarLibro(HashMap<String, Libro> libros) {
        String isbn = leerTextoNoVacio("Introduzca el ISBN del libro a eliminar: ");

        Libro libro = libros.get(isbn);

        if (libro == null) {
            System.out.println("No existe ningún libro con ese ISBN.");
            return;
        }

        System.out.println("Libro seleccionado: " + libro.getTitulo());

        if (Esdia.siOno("¿Desea eliminar este libro? (s/n): ")) {
            libros.remove(isbn);
            System.out.println("Libro eliminado correctamente.");
        } else {
            System.out.println("Eliminación cancelada.");
        }
    }

    // Evita registrar textos vacíos.
    private static String leerTextoNoVacio(String mensaje) {
        String texto;

        do {
            texto = Esdia.readString(mensaje).trim();

            if (texto.isEmpty()) {
                System.out.println("El texto no puede estar vacío.");
            }
        } while (texto.isEmpty());

        return texto;
    }

    private static int leerAnio() {
        int anio;

        do {
            anio = Esdia.readInt("Introduzca el año de publicación: ");
            if (anio <= 0) {
                System.out.println("El año debe ser mayor que cero.");
            }
        } while (anio <= 0);

        return anio;
    }
}
