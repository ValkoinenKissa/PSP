import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.Semaphore;

@Data
@NoArgsConstructor
public class Bebedero {
    protected static int cantidadTotalConsumida = 0;
    protected static Semaphore semaforoBebedero = new Semaphore(3);
    //Número de "bebederos" (hilos) que adquieren dicho recurso y se ejecutan paralelamente

}
