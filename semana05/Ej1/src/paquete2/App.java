package paquete2;
import paquete1.Clase1;


public class App {
    public static void main(String[] args) throws Exception {
        Clase1 class1 = new Clase1();
        class1.atributoPublico = 1; //Se puede acceder al atributo publico desde otra clase
        //class1.atributoProtegido = 2; //No se puede acceder al atributo protegido desde otra clase
        //class1.atributoDefault = 3; //No se puede acceder al atributo default desde otra clase
        //class1.atributoPrivado = 4; //No es visible fuera de la clase1
        class1.metodoPublico(); //Se puede acceder al metodo publico desde otra clase
        //class1.metodoProtegido(); //No se puede acceder al metodo protegido desde otra clase
        //class1.metodoDefault(); //No se puede acceder al metodo default desde otra clase
        //class1.metodoPrivado(); //No es visible fuera de la clase1
    }
}
