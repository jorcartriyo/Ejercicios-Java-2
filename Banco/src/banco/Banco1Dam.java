/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import javax.swing.JOptionPane;

/**
 *
 * @author Router1
 */
public class Banco1Dam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String titular;
        int nCliente;
        int nCuenta;
        nCliente = Integer.parseInt(JOptionPane.showInputDialog("POR FAVOR INDIQUE EL NÚMERO DEl CLIENTE"));
        nCuenta = Integer.parseInt(JOptionPane.showInputDialog("POR FAVOR INDIQUE EL NÚMERO DE LA CUENTA A CREAR "
                + "\n INTRODUZCA UN NÚMERO ENTRE 0 Y 10000"));
        titular = (JOptionPane.showInputDialog("POR FAVOR INDIQUE EL NOMBRE DEL TITULAR DE LA CUENTA A CREAR "));

        Banco banco = new Banco(titular, nCliente, nCuenta);

    }
}
