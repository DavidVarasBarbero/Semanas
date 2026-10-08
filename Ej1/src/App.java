public class App {
    public static void main(String[] args) {
        // Verificar que se reciban exactamente 2 argumentos
        if (args.length != 2) {
            System.out.println("Error: Debes introducir exactamente 2 argumentos.");
            System.out.println("Uso correcto: java SumaArgumentos <numero1> <numero2>");
            return;
        }

        try {
            // Intentar convertir los argumentos a números decimales (o enteros)
            double num1 = Double.parseDouble(args[0]);
            double num2 = Double.parseDouble(args[1]);
            
            double suma = num1 + num2;
            System.out.println("El resultado de la suma es: " + suma);
            
        } catch (NumberFormatException e) {
            System.out.println("Error: Uno o ambos argumentos no son números válidos.");
        }
    }
}
