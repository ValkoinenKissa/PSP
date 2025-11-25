//Clase común para número
public abstract class Numero {
    private final int valor;

    public Numero(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void imprimirPares() {}

    public void imprimirImpares() {}
}
