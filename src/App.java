import java.util.Scanner;
//import es.usal.progiii.tools.Esdia;
public class App {    
    public static void main(String[] args) {
        System.out.print("Hola, año actual:");
        Scanner teclado = new Scanner(System.in);
        int año = teclado.nextInt();
        System.out.print("Introduzaca su año de nacimiento:"); 
        int añonaci = teclado.nextInt();
        int edad = año - añonaci;
        teclado.nextLine();
        System.out.print("Introduzaca su nombre: ");
        String nombre = teclado.next();
        System.out.println("Su edad es: "+ edad + " señor/a " + nombre);
        teclado.close();
    }
}
