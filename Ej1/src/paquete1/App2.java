package paquete2;
//import paquete1.Clase2; no se puede importar fuera del paquete 1 pq no es public


public class App2 {
    public static void main(String[] args) throws Exception {
        Clase1 class1 = new Clase1();
        class1.atributoPublico = 1; //Se puede acceder al atributo publico desde otra clase
        class1.atributoProtegido = 2; //Se puede invocar al estar en el mismo paquete
        class1.atributoDefault = 3; //Se puede invocar al estar en el mismo paquete
        //class1.atributoPrivado = 4; //No es visible fuera de la clase1
        class1.metodoPublico(); //Se puede acceder al metodo publico desde otra clase
        class1.metodoProtegido(); //Se puede invocar al estar en el mismo paquete
        class1.metodoDefault(); //Se puede invocar al estar en el mismo paquete
        //class1.metodoPrivado(); //No es visible fuera de la clase1
    }
}
