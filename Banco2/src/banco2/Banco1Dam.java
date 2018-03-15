/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco2;

/**
 *
 * @author Router1
 */
public class Banco1Dam {

    public static void main(String[] args) {
        Banco2 b = new Banco2();
        int nCuenta;
        Clientes[] cliente = new Clientes[100];
        for (int i = 0; i < 100; i++) {
            nCuenta=i;
            cliente[i] = new Clientes(b, nCuenta);
            cliente[i].start();
        }
    }
}
