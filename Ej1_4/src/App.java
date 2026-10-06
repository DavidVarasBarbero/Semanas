import es.usal.progiii.tools.Esdia;
import model.Person;

public class App {
    public static void main(String[] args) throws Exception {
        Person persona1 = new Person();
        System.out.println(persona1.toString());
        System.out.println("El IMC de " + persona1.getNombre() + " es: " + persona1.IMC());
        Person persona4 = new Person("Manolo", 180, 80);
        System.out.println(persona4.getNombre() + " "+
            persona4.getPeso() + " "+
            persona4.getAltura());

        persona1.setNombre(Esdia.readString( "Introduce nombre "));
        persona1.setAltura(Esdia.readInt( "Introduce altura "));
        persona1.setPeso(Esdia.readFloat("Introduce peso ",  0,  150));

        Person persona2 = new Person();
        persona2.setNombre(Esdia.readString("Introduce nombre "));
        persona2.setAltura(Esdia.readInt("Introduce altura "));
        persona2.setPeso(Esdia.readFloat("Introduce peso ", 0, 150));


        Person persona3 = new Person();
        persona3.setNombre(Esdia.readString( "Introduce nombre "));
        persona3.setAltura(Esdia.readInt( "Introduce altura "));
        persona3.setPeso(Esdia.readFloat( "Introduce peso ",  0,  150));


        Person personaMasAlta = persona1;
        if (personaMasAlta.getAltura() < persona2.getAltura()) {
            personaMasAlta = persona2;
        }
        if (personaMasAlta.getAltura() < persona3.getAltura()) {
            personaMasAlta = persona3;
        }
        Person personaMaspesada = persona1;
        if (personaMaspesada.getPeso() < persona2.getPeso()) {
            personaMaspesada = persona2;
        }
        if (personaMaspesada.getPeso() < persona3.getPeso()) {
            personaMaspesada = persona3;
        }

           System.out.println( "la persona mas alta es: "+
            personaMasAlta.getNombre() + " "+
            personaMasAlta.getPeso() + " "+
            personaMasAlta.getAltura());

           System.out.println( "la persona mas pesada es: "+
            personaMaspesada.getNombre() + " "+
            personaMaspesada.getPeso() + " "+
            personaMaspesada.getAltura());
    }
}


