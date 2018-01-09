/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package el_botiquin;

/**
 *
 * @author Router1
 */
public class Miligramos {

    int unmg = 60;
    int dosmg = 60;
    int tresmg = 80;
    int cantidad;

    public Miligramos() {
    }

    public int unmg(int cantidad) {
        return unmg * cantidad;
    }

    public int dosmg(int cantidad) {
        return dosmg * cantidad;
    }

    public int tresmg(int cantidad) {
        return tresmg * cantidad;
    }
}
