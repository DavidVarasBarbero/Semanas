package Modelo;

public class modelo {
    private int numero1;
    private int numero2;
    private Integer resultadoSuma; 

    public void setNumeros(int num1, int num2) {
        this.numero1 = num1;
        this.numero2 = num2;
        this.resultadoSuma = null; 
    }

    public void calcularSuma() {
        this.resultadoSuma = this.numero1 + this.numero2;
    }

    public Integer getResultadoSuma() {
        return this.resultadoSuma;
    }
}
