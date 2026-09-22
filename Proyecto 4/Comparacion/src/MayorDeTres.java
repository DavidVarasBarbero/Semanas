import java.util.Scanner;

public class MayorDeTres {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el 1er número: ");
        double num1 = scanner.nextDouble();

        System.out.print("Introduce el 2º número: ");
        double num2 = scanner.nextDouble();

        System.out.print("Introduce el 3er número: ");
        double num3 = scanner.nextDouble();

        System.out.println("\n--- RESULTADO ---");

        if (num1 == num2 && num2 == num3) {
            System.out.println("Los tres números son iguales y su valor es: " + num1);
        } 
        else if (num1 == num2 && num1 > num3) {
            System.out.println("El 1º y el 2º número son iguales y los mayores, con valor: " + num1);
        } 
        else if (num1 == num3 && num1 > num2) {
            System.out.println("El 1º y el 3er número son iguales y los mayores, con valor: " + num1);
        } 
        else if (num2 == num3 && num2 > num1) {
            System.out.println("El 2º y el 3er número son iguales y los mayores, con valor: " + num2);
        } 
        else if (num1 > num2 && num1 > num3) {
            System.out.println("El mayor es el 1er número con un valor de: " + num1);
        } 
        else if (num2 > num1 && num2 > num3) {
            System.out.println("El mayor es el 2º número con un valor de: " + num2);
        } 
        else {
            System.out.println("El mayor es el 3er número con un valor de: " + num3);
        }
        scanner.close();
    }
}