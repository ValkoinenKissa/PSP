import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
Crear una aplicación que permita controlar el bebedero de una perrera.
Dicho bebedero sólo pueden beber a la vez tres perros.

Debéis controlar que sólo accedan tres perros a la vez, indicar cuánta agua bebe cada perro,
dependiendo del tiempo que esté en el bebedero (tiempo aleatorio sacado con un Random)
y cuánta agua beben todos los perros de la perrera.

Debe de mostrar el resultado cuando terminan de ejecutarse todos los hilos.
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Bebedero {
    int cantidadAguaConsumida = 0;

}
