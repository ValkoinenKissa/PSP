package deposito;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/*
Un depósito de agua es llenado a un ritmo de 10 litros por segundo.
Cuando ese depósito llega a los 900 litros,
se activa un proceso de vaciado a un ritmo de 5 litros por segundo, mientras se sigue llenando.
Cuando el depósito llega a los 1000 litros,
el proceso de llenado se para y se aumenta el de vaciado a 10 litros por segundo.
Cuando el depósito llega a los 100 litros de vaciado, se activa un proceso de llenado a un ritmo de 5 litros por segundo,
mientras se sigue vaciando.
Cuando el depósito llega a los 0 litros, el proceso de vaciado se para y se aumenta el de llenado a 10 litros por segundo.
Simula con monitores dichos procesos y ve representando en pantalla las acciones que se van tomando.
 */
@AllArgsConstructor
@NoArgsConstructor
public class Deposito {
    //Atributos del depósito
    private int nivelActual = 0;
    private static final int CAPACIDAD_MAX = 1000;


    public synchronized void llenarDeposito() throws InterruptedException {
       while (nivelActual >= CAPACIDAD_MAX){
           wait();
       }

        int incremento;

        if (nivelActual <= 100){
            incremento = 5;
           System.out.println("Llenando a 5 L/s → nivel: " + nivelActual);
       } else{
           incremento = 10;
           System.out.println("Llenando a 10 L/s → nivel: " + nivelActual);
       }

        nivelActual += incremento;

       if (nivelActual > CAPACIDAD_MAX){
           nivelActual = CAPACIDAD_MAX;
       }

        Thread.sleep(1000); // Simular 1 segundo

        notifyAll();


    }


    public synchronized void vaciarDeposito() throws InterruptedException {
        while (nivelActual < 900){
            wait();
        }

        int decremento;

        if (nivelActual >= CAPACIDAD_MAX){
            decremento = 10;
            System.out.println("Vaciando a 10 L/s nivel: " + nivelActual);
        } else {
            decremento = 5;
            System.out.println("Vaciando a 5 L/s → nivel: " + nivelActual);
        }

        nivelActual += decremento;

        if (nivelActual < 0){
            nivelActual = 0;
        }

        Thread.sleep(1000);

        notifyAll();
    }


}
