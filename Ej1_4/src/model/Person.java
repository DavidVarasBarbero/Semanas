package model;
 public class Person {
    //Atributos
     private String nombre;
     private int altura;
     private float peso;
     //Constructores
        public Person() {
            nombre="Desconocido";
            altura=165;
            peso=70;
        }
        public Person(String nombre, int altura, float peso) {
            this.nombre=nombre;
            this.altura=altura;
            this.peso=peso;
        }
        public Person(String nombre) {
            this();
            this.nombre=nombre;
        }
    //metodos
    public float IMC(){
        float alturaenMetros=altura/100;
        return peso/(alturaenMetros*alturaenMetros);
    }
    public String toString() {
        return "Nombre: " + nombre + ", Altura: " + altura + ", Peso: " + peso;
    }
    //Getters y Setters
     public String getNombre() {
         return nombre;
     }
     public void setNombre(String nombre) {
         this.nombre = nombre;
     }
     public int getAltura() {
         return altura;
     }
     public void setAltura(int altura) {
         if (altura < 0) {
             altura = 0;
         }
         if (altura > 240) {
             altura = 200;
             
         }
         this.altura = altura;
     }
    public float getPeso() {
            return peso;
    }
    public void setPeso(float peso) {
            this.peso = peso;
    }

 }

