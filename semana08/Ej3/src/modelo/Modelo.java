package modelo;
import java.util.ArrayList;
import java.nio.file.Path;
import java.io.File;


public class Modelo {
    ArrayList<Persona> personas;
    public Modelo(){
        personas = new ArrayList<>();
    }
    public int CargadeDatosDelimitado(Path ruta){
        File file = ruta.toFile();
        if(file.exists() && file.isFile()){
           List<String> lineas = file.readAllLines(ruta,StandardCharsets.UTF_8);
           for(String linea : lineas){
               Persona persona = Persona.CrearDesdeCadenaDelimitada(linea, "\t");
               if(persona != null){
                   personas.add(persona);
               }
           }

        }else{
            return -1;
        }
    }

}
