import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.Semaphore;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Controller extends Thread {
    private static Semaphore bebederos = new Semaphore(2);
    //Numero de hilos que adquieren dicho recurso y se ejecutan paralelamente. 10 pacientes esperando
}
