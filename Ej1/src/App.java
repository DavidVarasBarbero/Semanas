import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
     if (args.length==2 ){
        System.err.println("Número de parametros no es valido");
        return;
     }
    
    float num1 = Float.parseFloat(args[0]);
    float num2 = Float.parseFloat(args[1]);
    System.out.println("Suma: " + (num1 + num2));
    }
}
