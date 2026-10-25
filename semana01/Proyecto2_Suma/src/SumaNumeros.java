import java.util.Scanner;

public class SumaNumeros {
    public static void main(String[] args) {
        
        Scanner teclas = new Scanner(System.in);
       
        System.out.print("Introduce el primer número: ");
        double numero1 = teclas.nextDouble();
        
        System.out.print("Introduce el segundo número: ");
        double numero2 = teclas.nextDouble();
        
        double suma = numero1 + numero2;

        System.out.println("\nEl resultado de la suma es: " + suma);

        teclas.close();
    }
}
