import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor
public class Perro extends Thread{
    protected int cantidadAguaConsumida = 0;
    private int id;


    public Perro(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        Random rd = new Random();
        //Iterar el arrayList de perros

            try {
                Bebedero.semaforoBebedero.acquire();
                System.out.println("El perro: " + this.id + " ha entrado en el bebedero");

                Thread.sleep(rd.nextInt(1000, 5000)); //Hibernar el hilo durante un tiempo aleatorio
                int cantidadAguaConsumidaPerro = rd.nextInt(20, 201); //Cantidad aleatoria de agua consumida

                this.cantidadAguaConsumida = cantidadAguaConsumidaPerro;
                System.out.println("El perro: " + this.id + " ha bebido "
                        + cantidadAguaConsumidaPerro + " ml de agua");

                Bebedero.cantidadTotalConsumida += cantidadAguaConsumidaPerro; //Acumular valor en variable estática
                System.out.println("El perro: " + this.id + " ha salido del bebedero");
                Bebedero.semaforoBebedero.release();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

