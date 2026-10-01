import es.usal.progiii.tools.Esdia;
import model.Person;

public class App {
    public static void main(String[] args) throws Exception {
        Person persona1 = new Person();
        persona1.setNombre(Esdia.readString(prompt: "Introduce nombre"));
        persona1.setAltura(Esdia.readInt(prompt: "Introduce altura"));
        persona1.setPeso(Esdia.readFloat(prompt: "Introduce peso", min: 0, max: 150));

        Person persona2 = new Person();
        persona2.setNombre(Esdia.readString(prompt: "Introduce nombre"));
        persona2.setAltura(Esdia.readInt(prompt: "Introduce altura"));
        persona2.setPeso(Esdia.readFloat(prompt: "Introduce peso", min: 0, max: 150));


        Person persona3 = new Person();
        persona3.setNombre(Esdia.readString(prompt: "Introduce nombre"));
        persona3.setAltura(Esdia.readInt(prompt: "Introduce altura"));
        persona3.setPeso(Esdia.readFloat(prompt: "Introduce peso", min: 0, max: 150));


        Person personaMasAlta = persona1;
        if (personaMasAlta.getAltura() < persona2.getAltura()) {
            personaMasAlta = persona2;
        }
        if (personaMasAlta.getAltura() < persona3.getAltura()) {
            personaMasAlta = persona3;
        }

        
           System.out.println(
            persona1.getNombre() + " "+
            persona1.getPeso() + " "+
            persona1.getAltura());
    }
    }
}

