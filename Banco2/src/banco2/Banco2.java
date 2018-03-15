package banco2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Router1
 */
public class Banco2 {

    private int nCuenta;
    private int nCuenta1;
    private boolean banco = false;
    private int titular;
    private double saldo;
    private double ingreso;
    private double debito;
    private double transferencia;
    private Cuenta[] cuenta = new Cuenta[100];
    private Tiempo tiempo = new Tiempo();

    public Banco2() {
        for (nCuenta = 0; nCuenta < 100; nCuenta++) {
            titular = (int) (Math.random() * 100);
            saldo = Math.round(Math.random() * 10000);
            cuenta[nCuenta] = new Cuenta(titular, nCuenta, saldo);
        }
    }
//Método para crear un aleatorio que hace todas las operaciones del banco al que acceden los hilos

    public void accion(int nCuenta) {
        int accion = (int) (Math.random() * 7);
        switch (accion) {
            case 0://Salir
                banco = true;
                break;
            case 1://Depósito
                if (cuenta[nCuenta].saldo() > 3000) {
                    escribeBanco(deposito(nCuenta, saldo));
                } else {
                    escribeBanco("No se ha podido abrir la cuenta cliente, necesita tener 3000€ de saldo y tiene " + saldo(nCuenta));
                }
                break;
            case 2://Cuenta Cliente
                if (cuenta[nCuenta].saldo() > 3000) {
                    cuentaCliente(nCuenta, saldo);
                    escribeBanco(cuentaCliente(nCuenta, saldo));
                } else {
                    escribeBanco("No se ha podido abrir la cuenta cliente, necesita tener 3000€ de saldo y tiene " + saldo(nCuenta));
                }
                break;
            case 3://Ingreso
                ingreso = Math.round((Math.random() * 100));
                escribeBanco(ingreso(nCuenta, ingreso));
                break;
            case 4://Débito
                debito = Math.round((Math.random() * 100));
                escribeBanco(debito(nCuenta, debito));
                break;
            case 5:
                escribeBanco(saldo(nCuenta));
                break;
            case 6://Transferencia
                nCuenta1 = (int) (Math.random() * 100);
                transferencia = Math.round((Math.random() * 100));
                escribeBanco(transferencia(nCuenta, nCuenta1, transferencia));
                break;
        }
    }

//Método para leer los datos y escribirlos en el fichero "Made in Silvestre"
    public void escribeBanco(String mensaje) {
        // Leer fichero
        String rutaFichero = "src/fichero/fichero.txt";
        String mensajeExcepcion = "Ruta incorrecta, introduzca ruta correcta: ";

        // Crear y escribir en fichero nuevo
        FileWriter fw = null;
        PrintWriter pw = null;
        rutaFichero = "src/fichero/fichero.txt";
        while (fw == null || pw == null) {
            try {
                // Creamos fichero de caracteres
                fw = new FileWriter("src/fichero/fichero.txt");
                // Creamos flujo de texto
                pw = new PrintWriter(fw);
                // Imprimimos lo leído en el flujo de texto
                pw.write(mensaje = mensaje + "\n");
            } catch (IOException io) {
                System.out.println(io.getMessage());
            }
        }

        // Cerrar flujos utilizados para el fichero de copia
        try {
            fw.close();
        } catch (IOException io) {
            System.out.println("Problemas al cerrar fichero.");
            System.out.println(io.getMessage());
        }
        pw.close();
        System.out.println(mensaje);
    }

    public String deposito(int nCuenta, double saldo) {
        String j = "La cuenta " + nCuenta + " Ha creado una cuenta depósito";
        tiempo.tDeposito();
        saldo = cuenta[nCuenta].saldo() * 1.01;
        return "Han pasado 12 meses y el depósito de la cuenta " + nCuenta + " tiene un saldo de " + saldo;
    }

    public synchronized String cuentaCliente(int nCuenta, double saldo) {
        System.out.println("La cuenta  " + nCuenta + " Ha creado una cuenta Cliente");
        tiempo.tCliente();
        saldo = cuenta[nCuenta].saldo() * 1.25;
        return "Ha pasado un mes y la cuenta de ahorro de la cuenta " + nCuenta + " tiene un saldo de " + saldo;
    }

    public synchronized String ingreso(int nCuenta, double din) {
        System.out.println("Ingresando " + din + "€ en la cuenta " + nCuenta + "........");
        tiempo.operacion();
        cuenta[nCuenta].ingreso(din);
        ingreso = cuenta[nCuenta].saldo();
        return "Se han ingresado " + din + "€ de la cuenta  " + nCuenta
                + ". El saldo de la cuenta " + nCuenta + " después del ingreso es de " + ingreso;
    }

    public synchronized String debito(int nCuenta, double din) {
        System.out.println("Retirando " + din + "€ en la cuenta " + nCuenta + "........");
        tiempo.operacion();
        double dineroCargado;
        cuenta[nCuenta].retirada(cuenta[nCuenta].saldo());
        dineroCargado = cuenta[nCuenta].saldo();//   
        return "Se han retirado " + din + "€ de la cuenta " + nCuenta + ". El saldo de la cuenta "
                + nCuenta + " después de la retirada es de " + dineroCargado;
    }

    public String saldo(int nCuenta) {
        System.out.println("Comprobando el saldo de la cuenta " + nCuenta + "........");
        tiempo.operacion();
        return "El saldo de la cuenta " + nCuenta + " es " + cuenta[nCuenta].saldo();
    }

    public synchronized String transferencia(int num1, int num2, double transferencia) {
        System.out.println("Realizando una transferencia de  " + transferencia
                + "€ de la cuenta " + num1 + " a la cuenta " + num2 + "........");
        tiempo.operacion();
        this.debito(num1, transferencia);
        this.ingreso(num2, transferencia);
        return "Se han transferido " + transferencia + "€ " + " de la cuenta " + num1 + " a la cuenta "
                + num2 + ". El saldo de la cuenta " + num1 + " es de " + cuenta[num1].saldo()
                + " y el de la cuenta " + num2 + " es de " + cuenta[num2].saldo();
    }

}
