package modelo;
import java.util.ArrayList;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.File;
import es.usal.progiii.tools.*;


public class Modelo {
    Path RutaArchivoDatos = Rutas.pathToFileOnDesktop();
    ArrayList<Persona> personas;
    public Modelo(){
        personas = new ArrayList<>();
    }
    //negativo si es error, positivo el numero de registro importados
    public int CargadeDatosDelimitado(Path ruta){
        File file = ruta.toFile();
        try{
            if(file.exists() && file.isFile()){
                List<String> lineas = Files.readAllLines(ruta, StandardCharsets.UTF_8);
                for(String linea : lineas){
                    Persona persona = Persona.CrearDesdeCadenaDelimitada(linea, "\t");
                    if(persona != null){
                        personas.add(persona);
                    }
                }
                return personas.size();
            } else {
                return -1;
            }
        } catch(Exception e){
            return -1;
        }
    }
}
