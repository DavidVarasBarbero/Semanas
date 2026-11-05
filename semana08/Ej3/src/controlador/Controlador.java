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
        int numRegistro = modelo.CargadeDatosDelimitado(modelo.getRutasArchivoDatos);
        if (numRegistro < 0){
            vista.mostrarError("Error al cargar los datos");
    }else{
        vista.mostrarMensaje("Se han cargado " + numRegistro + " registros");
    }
    vista.mostrarMenu();
    }
    public void importarDatosEscritorio(String nombreArchivo){
        int numRegistro = modelo.CargadeDatosDelimitado(modelo.getRutasArchivoDatos);
        if (numRegistro < 0){
            vista.mostrarError("Error al cargar los datos");
            }
    }
}
