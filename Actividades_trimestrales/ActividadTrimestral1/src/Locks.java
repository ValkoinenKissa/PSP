public class Locks {
    // Lock global compartido para sincronizar la impresión en consola.
    // Todos los hilos que impriman (pares o impares) usarán este candado,
    // asegurando que solo un hilo pueda imprimir a la vez y evitando
    // que las salidas se mezclen.
    protected static final Object IMPRESION = new Object();

}
