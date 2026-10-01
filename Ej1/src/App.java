import model.Person;

public class App {
    public static void main(String[] args) throws Exception {
        Person persona1 = new Person();
        persona1.setNombre("Paquito");
        persona1.setAltura(170);
        persona1.setPeso(70.0f);

           System.out.println(
            persona1.getNombre() + " "+
            persona1.getPeso() + " "+
            persona1.getAltura());
    }
    }
}

