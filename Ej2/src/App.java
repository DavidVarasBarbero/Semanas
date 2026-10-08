import model.Person;

public class App {
    public static void main(String[] args) throws Exception {
        Person personita = Person.creardesdeArray(args);
        System.out.printf("%12s | %8s | %8s | %8s|\n", 
        "Nombre", "Peso", "Altura", "IMC");

        System.out.printf("%12s | %8.2f | %8d | %8.2f|\n", 
        personita.getNombre(), 
        personita.getPeso(), 
        personita.getAltura(), 
        personita.calcularIMC());
    }

}
