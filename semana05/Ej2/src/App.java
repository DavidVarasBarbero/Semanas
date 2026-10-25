import java.util.Arrays;
import es.usal.progiii.tools.Esdia;

public class App {
    public static void main(String[] args) throws Exception {
        String[] arrayStrings = new String[5];
        for (int i = 0; i < arrayStrings.length; i++) {
            arrayStrings[i] = Esdia.readString_ne("Introduce la cadena: ");
        }
        Arrays.sort(arrayStrings);
        for (String cadena : arrayStrings) {
            System.out.println(cadena);
        }
    }
}
