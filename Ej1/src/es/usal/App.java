package es.usal;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.print("Hola, anio actual:");
        Scanner teclado = new Scanner(System.in);
        int anio = teclado.nextInt();
        System.out.print("Introduzaca su anio de nacimiento:"); 
        int añonaci = teclado.nextInt();
        int edad = anio - añonaci;
        teclado.nextLine();
        System.out.print("Introduzca su nombre: ");
        String nombre = teclado.nextLine();

        System.out.println("Su edad es: " + edad + " anios, señor/a " + nombre);
        teclado.close();
    }
}
