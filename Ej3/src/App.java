public class App {
    public static void main(String[] args) throws Exception {
        Esdia.siOno(null);
        int numVeces = Esdia.readInt("Ingrese el número de veces que desea ejecutar el programa: ");

        if(numVeces <0) {
            System.err.println("El número de veces debe ser mayor que cero.");
            return;
        }
   
    float suma = 0;
    for (int i = 0; i < numVeces; i++) {
    suma+= Esdia.readFloat("Ingrese un número: ");
    }
float media = suma/numVeces;
    System.out.println("La media de los números ingresados es: " + media);
}
}
