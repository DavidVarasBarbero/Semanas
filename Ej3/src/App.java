import java.util.Arrays;

import es.usal.progiii.tools.Esdia;
import model.Fruta;

public class App {
    public static void main(String[] args) throws Exception {
        Fruta[] frutas = new Fruta[2];
        frutas[0] = new Fruta("Manzanas", 
        Esdia.readFloat("Introduce el precio de las manzanas"));
        frutas[1] = new Fruta("Peras", 
        Esdia.readFloat("Introduce el precio de las peras"));

        do{
           float[] cantidades=new float[frutas.length];
           for(int i=0;i<frutas.length;i++){
            cantidades[i]=Esdia.readFloat("Introduce la cantidad de "
            +frutas[i].getNombre());
           }
           float total=0;
           for(int i=0;i<frutas.length;i++){
            System.out.printf(" %-10s | %8.2f kg | precio con IVA: %3.2f | precio total: %3.2f \n",
            frutas[i].getNombre(),
            cantidades[i],
            frutas[i].getPrecioConIVA(),
            frutas[i].precio(cantidades[i])

            );
            total+=frutas[i].precio(cantidades[i]);
           }
           System.out.printf("Total: %3.2f\n", total);

        }while(Esdia.siOno("¿Quieres hacer otro ticket?"));
        
        System.out.println(Arrays.toString(args));

    }
}
