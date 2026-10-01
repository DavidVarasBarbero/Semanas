import model.Person;

public class App {
    public static void main(String[] args) throws Exception {
        Person persona1 = new Person();
        persona1.setNombre("Paquito");
        persona1.setAltura(170);
        persona1.setPeso(70.0f);

        System.out.println("Nombre: " + persona1.getNombre());
        System.out.println("Altura: " + persona1.getAltura());
        System.out.println("Peso: " + persona1.getPeso());
    }
}

