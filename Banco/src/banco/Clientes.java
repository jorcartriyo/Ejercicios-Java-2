/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import javax.swing.*;

/**
 *
 * @author Router1
 */
public class Clientes extends Thread {

    private final Cuenta c;
    private final Banco b;
    private boolean salirBanco;
    private double ingreso;
    private double retirada;
    private double transferencia;
    private String titular;
    private int segundos;
    private Tiempo tiempo = new Tiempo();
    private int nCliente;
    private int nCuenta;

    public Clientes(Cuenta c, Banco b, String titular, int nCliente) {
        this.c = c;
        this.titular = titular;
        this.nCliente = nCliente;
        this.b = b;
    }

    @Override
    public void run() {
        while (!salirBanco) {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog("BIEN VENIDOS AL BANCO DE 1º DE DAM SR./SRA "
                    + titular.toUpperCase() + "\nPOR FAVOR SELECCIONE LA OPERACIÓN QUE VA A REALIZAR"
                    + "\n0. PAUSAR AL CLIENTE.\n1 CONSULTAR SALDO.\n2 SALIR\n3. HACER INGRESO.\n4. RETIRAR DINERO."
                    + "\n5. HACER TRANSFERENCIA.\n6. CUENTA DEPOSITO.\n7. CUENTA CLIENTE."
                    + "\n\n PODRÁ HACER CUALQUIER OPERACIÓN CON UNA CUENTA \n SIEMPRE QUE CONOZCA"
                    + " EL NÚMERO DE CUENTA Y EL CLIENTE"));
            switch (opcion) {

                case 0:
                    segundos = Integer.parseInt(JOptionPane.showInputDialog("¿CUANTOS SEGUNDOS VA A APARCAR LA OPERACIÓN?"));
                    tiempo.tiempo(segundos);
                    break;
                case 1:
                    b.consultarSaldo(titular);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "HASTA LA PRÓXIMA");
                    salirBanco = true;
                    break;
                case 3:
                    ingreso = Integer.parseInt(JOptionPane.showInputDialog("¿CUANTO VA A INGRESAR EN LA CUENTA?"));
                    b.ingreso(ingreso);
                    break;
                case 4:
                    retirada = Integer.parseInt(JOptionPane.showInputDialog("¿CUANTO VA A RETIRAR DE SU CUENTA?"));
//                    c.retirada(retirada);
                    break;
                case 5:
//                    nCliente = Integer.parseInt(JOptionPane.showInputDialog("¿A QUE CLIENTE VA A REALIZAR LA TRANSFERENCIA?"));
//                    transferencia = Integer.parseInt(JOptionPane.showInputDialog("¿VALOR DE LA TRANSFERENCIA LA TRANSFERENCIA?"));
//                    titular = JOptionPane.showInputDialog("¿A QUE CLIENTE VA A REALIZAR LA TRANSFERENCIA?");
//                    nCuenta = Integer.parseInt(JOptionPane.showInputDialog("¿A QUE CLIENTE VA A REALIZAR LA TRANSFERENCIA?"));
//                    c.transferencia(c, transferencia);
//                    banco.Cuenta;
                    nCuenta = Integer.parseInt(JOptionPane.showInputDialog("POR FAVOR INDIQUE EL NÚMERO DE LA CUENTA DESTINO "));

                    retirada = Float.parseFloat(JOptionPane.showInputDialog("POR FAVOR INDIQUE LA CANTIDAD A TRANSFERIR"));
                    b.transferencia(nCuenta, retirada);
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "EL CLIENTE " + titular + " HA  CREADO UNA CUENTA DEPÓSITO");
//                    c.deposito(titular);
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "EL CLIENTE " + titular + " HA CREADO UNA CUENTA CLIENTE");
//                    c.cuentaCliente(titular);
                    break;
            }
        }
    }
}
