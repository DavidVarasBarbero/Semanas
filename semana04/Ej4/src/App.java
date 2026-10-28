import es.usal.progiii.tools.Esdia;
import model.Alumno;

public class App {
    public static void main(String[] args) throws Exception {
        // 1. Solicitar el número de alumnos
        int numAlumnos = Esdia.readInt("Introduce el número de alumnos del curso: ");

        // Verificar que el número sea válido
        if (numAlumnos <= 0) {
            System.out.println("El número de alumnos debe ser mayor que cero.");
            return;
        }

        // Crear el array de objetos Alumno
        Alumno[] alumnos = new Alumno[numAlumnos];

        // 2. Solicitar datos por cada alumno
        for (int i = 0; i < alumnos.length; i++) {
            System.out.println("\n--- Datos del Alumno " + (i + 1) + " ---");
            String nombre = Esdia.readString("Introduce el nombre: ");
            float p1 = Esdia.readFloat("Nota Parcial 1: ");
            float p2 = Esdia.readFloat("Nota Parcial 2: ");
            float pFinal = Esdia.readFloat("Nota Examen Final: ");

            // Instanciar el objeto y guardarlo en el array
            alumnos[i] = new Alumno(nombre, p1, p2, pFinal);
        }

        // 3. Mostrar la tabla de calificaciones
        System.out.println("\n=========================================================================");
        System.out.println("                        CALIFICACIONES DEL CURSO                         ");
        System.out.println("=========================================================================");
        System.out.printf("| %-20s | %-10s | %-10s | %-10s | %-10s |\n", "Nombre", "Parcial 1", "Parcial 2", "Ex. Final", "Nota Final");
        System.out.println("-------------------------------------------------------------------------");

        // Variables para calcular las medias de la clase
        float sumaP1 = 0;
        float sumaP2 = 0;
        float sumaFinal = 0;
        float sumaNotaFinal = 0;

        for (int i = 0; i < alumnos.length; i++) {
            Alumno a = alumnos[i];
            float notaFinal = a.calcularNotaFinal();
            
            // Imprimir la fila del alumno (formateada con 2 decimales)
            System.out.printf("| %-20s | %-10.2f | %-10.2f | %-10.2f | %-10.2f |\n", 
                a.getNombre(), a.getParcial1(), a.getParcial2(), a.getFinalExamen(), notaFinal);
            
            // Acumular para las medias
            sumaP1 += a.getParcial1();
            sumaP2 += a.getParcial2();
            sumaFinal += a.getFinalExamen();
            sumaNotaFinal += notaFinal;
        }
        System.out.println("=========================================================================");

        // 4. Calcular y mostrar las medias de la clase
        System.out.println("\n--- MEDIAS DE LA CLASE ---");
        System.out.printf("Media Parcial 1: %.2f\n", sumaP1 / numAlumnos);
        System.out.printf("Media Parcial 2: %.2f\n", sumaP2 / numAlumnos);
        System.out.printf("Media Examen Final: %.2f\n", sumaFinal / numAlumnos);
        System.out.printf("Media NOTA FINAL GLOBAL: %.2f\n", sumaNotaFinal / numAlumnos);
    }
}
