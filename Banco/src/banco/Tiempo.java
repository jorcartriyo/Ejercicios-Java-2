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
public class Tiempo {

    private int segundos;

    public Tiempo() {

    }

    public void tiempo(int segundos) {

        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
        }
    }

    public void tDeposito() {

        try {
            Thread.sleep(150000);
        } catch (InterruptedException e) {
        }
    }

    public void tCliente() {

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
        }
    }

    public void operacion() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
}
