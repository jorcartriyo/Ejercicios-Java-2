/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author Router1
 */
public class Cuenta {

    private double saldo;
    private double ingreso;
    private double retirada;
    private final String titular;
    private double transferencia;
//    private final boolean termina = true;
    private final Tiempo tiempo = new Tiempo();
    private boolean ocupadoI = false;
    private boolean ocupadoR = false;
    private boolean ocupadoT = false;
    private int nCliente;
    private int nCuenta;
    private int cuenta;

    public Cuenta(String titular, int nCliente, int nCuenta) {
        this.saldo = saldo;
        this.titular = titular;
        this.nCliente = nCliente;
        this.nCuenta = nCuenta;
        saldo = 1;
    }

    public String deposito(String titular) {
        System.out.println("El Cliente " + titular + " Ha creado una cuenta depósito");
        tiempo.tDeposito();
        saldo = saldo * 1.01;
        return "Han pasado 12 meses y el depósito del cliente " + titular + " tiene un saldo de " + saldo;
    }

    public void cuentaCliente(String titular) {
        System.out.println("El Cliente " + titular + " Ha creado una cuenta Cliente");
        tiempo.tCliente();
        saldo = saldo * 1.25;
        System.out.println("Ha pasado un mes y la cuenta de ahorro del titular " + titular + " tiene un saldo de " + saldo);
    }

    public void consultarSaldo(String titular) {

        System.out.println("Consulta de saldo en curso...............");
        tiempo.operacion();
        System.out.println("El saldo del cliente " + nCliente + ", titular " + titular + " de la cuenta " + nCuenta + " es de " + saldo);
    }

    public synchronized void ingreso(double ingreso) {
        while (ocupadoI) {
            tiempo.operacion();
        }
        ocupadoI = true;
        try {
            System.out.println("Ingreso en curso...............");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        saldo = saldo + ingreso;
        System.out.println("Acaba de Ingresar " + ingreso + "€ El saldo del titular " + titular + " despues del ingreso es de  " + saldo);
        notify();
        ocupadoI = false;
    }

    public synchronized void retirada(double retirada) {
        while (ocupadoR) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        ocupadoR = true;
        tiempo.operacion();
        saldo = saldo - retirada;
        System.out.println("Acaba de Retirar " + retirada + "€ El saldo del titular " + titular + " despues del ingreso es de  " + saldo);
        notify();
        ocupadoR = false;
    }

    public void transferencia(Cuenta cuenta, double transferencia) {

        while (ocupadoT) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        ocupadoT = true;
        retirada(transferencia);
        cuenta.ingreso(ingreso);
        ocupadoT = false;

    }

    public String titular() {
        return titular;
    }

    public double saldo() {
        return saldo;
    }

    public int cuenta() {
        return cuenta;
    }
}
