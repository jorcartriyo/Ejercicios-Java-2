/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import javax.swing.*;

public class Banco {

    private double saldo = 0;
    private int nCuenta = 0;
    private String titular;
    private int nCliente;
    private boolean salirBanco = false;
    private boolean ingreso = false;
    private int segundos = 0;
    private Tiempo tiempo = new Tiempo();
    private Cuenta[] cuenta = new Cuenta[100];
    private Clientes[] cliente = new Clientes[100];
    Banco b;

    public Banco(String titular, int nCliente, int nCuenta) {
  
         this.nCliente=nCliente;
          this.nCuenta=nCuenta;
           this.titular=titular;
        while (!salirBanco) {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog("BIEN VENIDOS AL BANCO DE 1º DE DAM"
                    + "\nPOR FAVOR SELECCIONE LA OPERACIÓN QUE VA A REALIZAR"
                    + "\n\n0. APARCAR OPERACIÓN. \n1. CREAR CUENTA.\n2. CAMBIAR DE CLIENTE.\n3. SALIR."));

            switch (opcion) {
                case 1:                
                    saldo = Float.parseFloat(JOptionPane.showInputDialog("POR FAVOR INDIQUE EL SALDO INICIAL DE LA CUENTA A CREAR"));
                    cuenta[nCuenta] = new Cuenta(titular, nCliente, nCuenta);

                    JOptionPane.showMessageDialog(null, "!!ENHORABUENA!! \n ES USTED EL CLIENTE Nº " + nCliente
                            + "\n HA CREADO LA CUENTA Nº " + nCuenta
                            + "\n PARA EL TITULAR " + titular.toUpperCase() + "\n CON UN SALDO INICIAL DE " + saldo + " €");
                    cliente[nCliente] = new Clientes(cuenta[nCuenta],b,titular, nCliente);
                    cliente[nCliente].start();
                    break;
                case 0:
                    segundos = Integer.parseInt(JOptionPane.showInputDialog("¿CUANTO TIEMPO QUIERES TENER LA OPERACIÓN APARCADA?"));
                    tiempo.tiempo(segundos);

                    break;

                case 2:
                    nCliente = Integer.parseInt(JOptionPane.showInputDialog("Cliente a recuperar"));
                    cliente[nCliente].run();
                    
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "HASTA LA PRÓXIMA");
                    salirBanco = true;
                    break;
                case 4:

                    nCuenta = Integer.parseInt(JOptionPane.showInputDialog("POR FAVOR INDIQUE EL NÚMERO DE LA CUENTA DESTINO "));

                    saldo = Float.parseFloat(JOptionPane.showInputDialog("POR FAVOR INDIQUE LA CANTIDAD A TRANSFERIR"));

                    cuenta[nCuenta].transferencia(cuenta[nCuenta], saldo);

                    break;
                          case 5:

                   cuenta[nCuenta].consultarSaldo(titular);

                    break;
            }
            
        }
    }


    public void transferencia(int nCuenta,double retirada) {
       
        cuenta[nCuenta].ingreso(retirada);


    }
    public void ingreso(double ingreso){
        cuenta[nCuenta].ingreso(ingreso);
    }
    public void consultarSaldo(String titular){
        cuenta[nCuenta].consultarSaldo(titular);
    }
}
