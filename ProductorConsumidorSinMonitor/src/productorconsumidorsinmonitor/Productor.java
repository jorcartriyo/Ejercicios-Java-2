
package productorconsumidorsinmonitor;

public class Productor extends Thread {

    private final CubbyHole cubbyhole;
    private final int numero;

    public Productor(CubbyHole c, int numero) {
        cubbyhole = c;
        this.numero = numero; // retardo aplicado al productor
    }
    
    @Override
    public void run() {
        for (int i = 3; i < 10; i++) {
            cubbyhole.put(i);
            System.out.println("Productor pone: " + i);
            try {
                sleep(numero);
            } catch (InterruptedException e) {
            }
        }
    }
}
