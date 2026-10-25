import java.io.Console;

public class App{

    public static void main(String[] args) throws Exception {
        Console console = System.console();
        System.out.println("Introduzca el anio actual:");
        int anio = Integer.parseInt(console.readLine());
       
        System.out.println("Introduce un peso cualquiera:");
        float peso = Float.parseFloat(console.readLine());
        char[] pass = console.readPassword();
        System.out.println("La contraseña es " + String.valueOf(pass));
    }
}