/*
Crear una aplicación que permita controlar el bebedero de una perrera.
Dicho bebedero solo pueden beber a la vez tres perros.

Debéis controlar que solo accedan tres perros a la vez, indicar cuánta agua bebe cada perro,
dependiendo del tiempo que esté en el bebedero (tiempo aleatorio sacado con un Random)
y cuánta agua beben todos los perros de la perrera.

Debe de mostrar el resultado cuando terminan de ejecutarse todos los hilos.
 */
public class Main extends Thread {

    public static void main(String[] args) throws InterruptedException {
        var perros = Controller.generarPerros(); //Inferir tipo de variable automaticamente

        for (Perro p : perros) {
            p.start();
        }

        for (Perro p : perros) {
            p.join(); //Asegurar la finalización de todos los hilos
        }

        System.out.println("El total de agua que han consumido los perros de la perrera es de: "
                + Bebedero.cantidadTotalConsumida + " ml");


    }
}
