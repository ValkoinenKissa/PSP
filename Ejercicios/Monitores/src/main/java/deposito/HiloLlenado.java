package deposito;

public class HiloLlenado extends Thread{

    private final Deposito deposito;
    private final int ciclos;

    public HiloLlenado(Deposito deposito, int ciclos) {
        super("Hilo-Llenado"); // Nombrar el hilo, util para depuración
        this.deposito = deposito;
        this.ciclos = ciclos;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < ciclos; i++) {
                deposito.llenar();
                Thread.sleep(300); // Simula 0,3 segundos entre pasos
            }
        } catch (InterruptedException e) {
            System.out.println("[LLENADO] Hilo interrumpido.");
            Thread.currentThread().interrupt();
        }
    }
}
