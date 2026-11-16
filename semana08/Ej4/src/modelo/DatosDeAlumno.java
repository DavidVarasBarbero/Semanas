package modelo;

public class DatosDeAlumno {
    private DatosPersonales datosPersonales;
    private Direccion direccion;

    public DatosDeAlumno(DatosPersonales datosPersonales, Direccion direccion) {
        this.datosPersonales = datosPersonales;
        this.direccion = direccion;
    }

    public static DatosDeAlumno crearAleatorio() {
        return new DatosDeAlumno(
            DatosPersonales.crearAleatorio(),
            Direccion.crearAleatoria()
        );
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
