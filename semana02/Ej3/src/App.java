import es.usal.progiii.tools.Esdia;
public class App {
    public static void main(String[] args) throws Exception {
        Esdia.siOno(null);
        int numVeces = Esdia.readInt("Ingrese el número de parametros que desea ingresar: ");

        if(numVeces <0) {
            System.err.println("El número de parametros debe ser mayor a 0.");
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
