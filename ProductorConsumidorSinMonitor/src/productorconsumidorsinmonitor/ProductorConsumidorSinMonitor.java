
package productorconsumidorsinmonitor;

public class ProductorConsumidorSinMonitor {

    public static void main(String[] args) {
        CubbyHole b = new CubbyHole();
        Productor p = new Productor(b, 2000);
        Consumidor c = new Consumidor(b, 1000);
        p.start();
        c.start();
    }
}
