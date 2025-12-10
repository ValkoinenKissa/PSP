import lombok.AllArgsConstructor;
/*
Crear una aplicación que permita controlar el bebedero de una perrera.
Dicho bebedero solo pueden beber a la vez tres perros.

Debéis controlar que solo accedan tres perros a la vez, indicar cuánta agua bebe cada perro,
dependiendo del tiempo que esté en el bebedero (tiempo aleatorio sacado con un Random)
y cuánta agua beben todos los perros de la perrera.

Debe de mostrar el resultado cuando terminan de ejecutarse todos los hilos.
 */

import java.util.ArrayList;
import java.util.Scanner;

@AllArgsConstructor
public class Controller {

    public static ArrayList<Perro> generarPerros() {
        Scanner sc = new Scanner(System.in);
        int numPerros;
        boolean entradaValida;

        do {
            System.out.println("Introduce el numero de perros que entraran en el bebedero: ");
            numPerros = sc.nextInt();
            if (numPerros < 0 || numPerros > 200) {
                System.out.println("Error: Introduce un numero de bebederos validos (Min 0 y Max 200");
                entradaValida = false;
            } else {
                entradaValida = true;
            }

        } while (!entradaValida);

        ArrayList<Perro> listaPerros = new ArrayList<>();


        for (int i = 0; i < numPerros; i++) {
           listaPerros.add(new Perro(i));
        }
        return listaPerros;
    }
}
