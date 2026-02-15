package deposito;

public class HiloVaciado extends Thread{
    private final Deposito deposito;
    private final int ciclos;

    public HiloVaciado(Deposito deposito, int ciclos) {
        super("Hilo-Vaciado"); // Nombrar el hilo, util para depuración
        this.deposito = deposito;
        this.ciclos = ciclos;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < ciclos; i++) {
                deposito.vaciar();
                Thread.sleep(300); // Simula 0,3 segundos entre pasos
            }
        } catch (InterruptedException e) {
            System.out.println("[VACIADO] Hilo interrumpido.");
            Thread.currentThread().interrupt();
        }
    }
}
