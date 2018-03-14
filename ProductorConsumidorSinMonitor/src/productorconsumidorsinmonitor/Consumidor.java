
package productorconsumidorsinmonitor;

public class Consumidor extends Thread {

    private final CubbyHole cubbyhole;
    private final int numero;

    public Consumidor(CubbyHole c, int numero) {
        cubbyhole = c;
        this.numero = numero;
    }
    @Override
    public void run() {
        int value = 0;
        for (int i = 0; i < 10; i++) {
            value = cubbyhole.get();
            System.out.println("Consumidor saca:" + value);
            try {
                sleep(numero);
            } catch (InterruptedException e) {}
        }
    }
}
