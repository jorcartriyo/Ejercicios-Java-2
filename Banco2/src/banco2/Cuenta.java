package banco2;

/**
 *
 * @author Router1
 */
public class Cuenta {

    private int titular;
    private double saldo;
    private int nCuenta;

    public Cuenta(int titular, int nCuenta, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
        this.nCuenta = nCuenta;
    }

    public Cuenta(int titular, int nCuenta) {
        this.titular = titular;
        this.nCuenta = nCuenta;
    }

    public void ingreso(double ingreso) {
        saldo += ingreso;
    }

    public void retirada(double retirada) {
        saldo -= retirada;
    }

    public int titular() {
        return titular;
    }

    public double saldo() {
        return saldo;
    }

    public int cuenta() {
        return nCuenta;
    }
}
