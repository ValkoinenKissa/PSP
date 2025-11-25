//Clase común para número
public abstract class Numero {
    private final int valor;

    public Numero(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    //Funciones comunes para heredar en las clases hijas

    public void imprimirPares() {}

    public void imprimirImpares() {}
}
