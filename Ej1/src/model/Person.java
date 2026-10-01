package model;
 public class Person {
     private String nombre;
     private int altura;
     private float peso;

     public String getNombre() {
         return nombre;
     }
     public void setNombre(String nombre) {
         this.nombre = nombre;
     }
     public int getAltura() {
         return altura;
     }
     publuc void setAltura(int altura) {
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

