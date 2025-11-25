public class Pares extends Numero implements Runnable {
    public Pares(int valor) {
        super(valor);
    }


    @Override
    public void imprimirPares() {
        //Bloqueamos el System. Out para que nadie más escriba mientras el hilo trabaja
        //Asi la salida se formatea correctamente

        synchronized (Locks.IMPRESION) {
            //Cuando se termina de ejecutar la función se abre el candado
            //Mientras el candado está cerrado, ningún otro hilo puede entrar en un bloque sincronizado con el mismo
            //objeto lock
            System.out.println("Hilo " + Thread.currentThread().getName() + " imprimiendo pares:");
            int acum = 0;
            for (int i = 1; i <= getValor(); i++) {
                if (i % 2 == 0) {
                    System.out.println(i + " ");
                    acum += i;
                }
            }
            System.out.println();
            System.out.printf("Suma pares: %d \n", acum);
            System.out.println("-----------------------");
        }

    }

    @Override
    public void run() { //Implementamos la función run que nos obliga a sobreescribir la interfaz
        this.imprimirPares(); //Ese run() es lo que el hilo ejecutará cuando lo arranquemos a través de un Thread.
    }
}
