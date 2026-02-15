package deposito;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Deposito {

    private int litros = 0;
    private int ritmoLlenado = 10;   // L/s
    private int ritmoVaciado = 0;    // L/s
    private boolean llenadoActivo = true;
    private boolean vaciadoActivo = false;

    /**
     * Función sincronizada que ejecuta un paso de llenado.
     * El hilo de llenado espera si no está activo.
     */
    public synchronized void llenar() throws InterruptedException {
        // Esperar mientras el llenado no esté activo
        while (!llenadoActivo) {
            wait();
        }

        litros += ritmoLlenado;
        System.out.printf("[LLENADO]  +%2d L/s → Depósito: %4d litros%n", ritmoLlenado, litros);

        // Transición: al llegar a 900L, se activa el vaciado a 5 L/s
        if (litros >= 900 && !vaciadoActivo) {
            vaciadoActivo = true;
            ritmoVaciado = 5;
            System.out.println("──────────────────────────────────────────────────");
            System.out.println("  900L alcanzados: VACIADO activado a 5 L/s");
            System.out.println("──────────────────────────────────────────────────");
            notifyAll();
        }

        // Transición: al llegar a 1000L, se para el llenado y vaciado sube a 10 L/s
        if (litros >= 1000) {
            llenadoActivo = false;
            ritmoLlenado = 0;
            ritmoVaciado = 10;
            System.out.println("══════════════════════════════════════════════════");
            System.out.println("     1000L alcanzados: LLENADO parado");
            System.out.println("     VACIADO aumentado a 10 L/s");
            System.out.println("══════════════════════════════════════════════════");
            notifyAll();
        }
    }

    /**
     * Función sincronizada que ejecuta un paso de vaciado.
     * El hilo de vaciado espera si no está activo.
     */
    public synchronized void vaciar() throws InterruptedException {
        // Esperar mientras el vaciado no esté activo
        while (!vaciadoActivo) {
            wait();
        }

        litros -= ritmoVaciado;
        if (litros < 0) litros = 0;
        System.out.printf("[VACIADO]  -%2d L/s → Depósito: %4d litros%n", ritmoVaciado, litros);

        // Transición: al llegar a 100L vaciando, se activa llenado a 5 L/s
        if (litros <= 100 && !llenadoActivo) {
            llenadoActivo = true;
            ritmoLlenado = 5;
            System.out.println("──────────────────────────────────────────────────");
            System.out.println("    100L alcanzados: LLENADO activado a 5 L/s");
            System.out.println("──────────────────────────────────────────────────");
            notifyAll();
        }

        // Transición: al llegar a 0L, se para el vaciado y llenado sube a 10 L/s
        if (litros <= 0) {
            vaciadoActivo = false;
            ritmoVaciado = 0;
            ritmoLlenado = 10;
            System.out.println("══════════════════════════════════════════════════");
            System.out.println("     0L alcanzados: VACIADO parado");
            System.out.println("     LLENADO aumentado a 10 L/s");
            System.out.println("══════════════════════════════════════════════════");
            notifyAll();
        }
    }

    public synchronized int getLitros() {
        return litros;
    }

}
