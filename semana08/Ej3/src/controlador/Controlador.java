package controlador;
import modelo.Modelo;
import vista.Vista;

public class Controlador {
    Vista vista;
    Modelo modelo;

    public Controlador(Modelo modelo, Vista vista){
        this.modelo = modelo;
        this.vista = vista;
    }

    public void init(){
        
    }



}
