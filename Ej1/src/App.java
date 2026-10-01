import model.Person;

public class App {
    public static void main(String[] args) throws Exception {
        Person persona1 = new Person();
        persona1.nombre = "Paquito";
        persona1.altura = 170;
        persona1.peso = 78.0f;

        System.out.println("Nombre: " + persona1.nombre);
        System.out.println("Altura: " + persona1.altura);
        System.out.println("Peso: " + persona1.peso);
    }
}

