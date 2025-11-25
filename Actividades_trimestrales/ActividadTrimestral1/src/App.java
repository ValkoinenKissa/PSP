/*
Realiza un programa en java que use hilos independientes, en clases diferentes.
Un hilo imprime números pares del 1 al 10 y la suma de dichos números,
y otro hilo que imprime números impares del 1 al 10 y la suma de dichos números.
Cree dos instancias (hilos) de cada uno y muestre la salida
 */


public class App {
    public static void main(String[]args){
        // Se definen dos instancias de Runnable (la lógica a ejecutar).
        // Estas dos instancias serán REUTILIZADAS por múltiples hilos.
        Pares par = new Pares(10);
        Impares impar = new Impares(10);

        // Reutilizamos la instancia 'par' para crear DOS hilos independientes.
        // Se asigna un nombre único a cada Thread ("Par-1", "Par-2")
        // para facilitar la identificación y la depuración de la salida concurrente.

        Thread hiloPar1 = new Thread(par, "Par-1");
        Thread hiloImpar1 = new Thread(impar, "Impar-1");


        //Y ahora inicializamos cada hilo con el metodo start
        hiloPar1.start();
        hiloImpar1.start();


    }
}
