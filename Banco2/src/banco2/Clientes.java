package banco2;

/**
 *
 * @author Router1
 */
public class Clientes extends Thread {

    private boolean banco;
    private int dinero;
    private int nCuenta;
    private int titular;
    private Banco2 b = new Banco2();
    
    public Clientes(Banco2 b,int nCuenta) {
        this.b = b;
        this.nCuenta = nCuenta;    
    }

    @Override
    public void run() {
        while (!banco) {
         b.accion(nCuenta);
        
        }

    }
}
