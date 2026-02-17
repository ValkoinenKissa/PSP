package deposito;

/*
Un depósito de agua es llenado a un ritmo de 10 litros por segundo.
Cuando ese depósito llega a los 900 litros, se activa un proceso de vaciado a un ritmo de 5 litros por segundo, mientras se sigue llenando.
Cuando el depósito llega a los 1000 litros, el proceso de llenado se para y se aumenta el de vaciado a 10 litros por segundo.
Cuando el depósito llega a los 100 litros de vaciado, se activa un proceso de llenado a un ritmo de 5 litros por segundo, mientras se sigue vaciando.
Cuando el depósito llega a los 0 litros, el proceso de vaciado se para y se aumenta el de llenado a 10 litros por segundo.
Simula con monitores dichos procesos y ve representando en pantalla las acciones que se van tomando.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Deposito deposito = new Deposito();

        // Ciclos suficientes para completar ~2 ciclos enteros del depósito
        // Ciclo completo: 90(0→900) + 20(900→1000) + 90(1000→100) + 20(100→0) = 220 pasos aprox.
        int ciclos = 500;

        System.out.println("══════════════════════════════════════════════════");
        System.out.println("   SIMULACIÓN DE DEPÓSITO DE AGUA CON MONITORES");
        System.out.println("══════════════════════════════════════════════════");
        System.out.println("  Capacidad máxima: 1000 litros");
        System.out.println("  Estado inicial:   0 litros, llenado a 10 L/s");
        System.out.println("══════════════════════════════════════════════════\n");

        HiloLlenado hiloLlenado = new HiloLlenado(deposito, ciclos);
        HiloVaciado hiloVaciado = new HiloVaciado(deposito, ciclos);

        hiloLlenado.start();
        hiloVaciado.start();

        hiloLlenado.join();
        hiloVaciado.join();

        System.out.println("══════════════════════════════════════════════════");
        System.out.println("   SIMULACIÓN FINALIZADA");
        System.out.printf("   Litros finales: %d%n", deposito.getLitros());
        System.out.println("══════════════════════════════════════════════════");

    }
}
