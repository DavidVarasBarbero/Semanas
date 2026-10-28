import es.usal.progiii.tools.Esdia;
import model.alumno;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int numAlumnos = Esdia.readInt("Introduce el número de alumnos del curso: ");
        if (numAlumnos <= 0) {
            System.out.println("El número de alumnos debe ser mayor que cero.");
            return;
        }

        alumno[] alumnos = new alumno[numAlumnos];

        for (int i = 0; i < alumnos.length; i++) {
            System.out.println("\n--- Datos del Alumno " + (i + 1) + " ---");
            String nombre = Esdia.readString("Introduce el nombre: ");
            float p1 = Esdia.readFloat("Nota Parcial 1: ");
            float p2 = Esdia.readFloat("Nota Parcial 2: ");
            float pFinal = Esdia.readFloat("Nota Examen Final: ");
            alumnos[i] = new alumno(nombre, p1, p2, pFinal);
        }

        System.out.println("\n=========================================================================");
        System.out.println("                        CALIFICACIONES DEL CURSO                         ");
        System.out.println("=========================================================================");
        System.out.printf("| %-20s | %-10s | %-10s | %-10s | %-10s |\n", "Nombre", "Parcial 1", "Parcial 2", "Ex. Final", "Nota Final");
        System.out.println("-------------------------------------------------------------------------");

        float sumaP1 = 0;
        float sumaP2 = 0;
        float sumaFinal = 0;
        float sumaNotaFinal = 0;

        for (int i = 0; i < alumnos.length; i++) {
            alumno a = alumnos[i];
            float notaFinal = a.calcularNotaFinal();
            
            System.out.printf("| %-20s | %-10.2f | %-10.2f | %-10.2f | %-10.2f |\n", 
                a.getNombre(), a.getParcial1(), a.getParcial2(), a.getFinalExamen(), notaFinal);
            
            sumaP1 += a.getParcial1();
            sumaP2 += a.getParcial2();
            sumaFinal += a.getFinalExamen();
            sumaNotaFinal += notaFinal;
        }
        System.out.println("=========================================================================");

        System.out.println("\n--- MEDIAS DE LA CLASE ---");
        System.out.printf("Media Parcial 1: %.2f\n", sumaP1 / numAlumnos);
        System.out.printf("Media Parcial 2: %.2f\n", sumaP2 / numAlumnos);
        System.out.printf("Media Examen Final: %.2f\n", sumaFinal / numAlumnos);
        System.out.printf("Media NOTA FINAL GLOBAL: %.2f\n", sumaNotaFinal / numAlumnos);
    }
}
