/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champion_ligue;

/**
 *
 * @author Router1
 */
public class Campo {

    private int anchura;
    private int longitud;
    private boolean reglamentario;

    public Campo(int anchura, int longitud) {
        this.anchura = anchura;
        this.longitud = longitud;
    }

    public void compruebaMedidas() {
        if (anchura < 43 || longitud > 160 || longitud < (2 * anchura) || longitud > (3 * anchura)) {
            reglamentario = false;
        } else {
            reglamentario = true;
        }
    }

    public String reglamentario() {
        String devuelveReglamentario;
        if (reglamentario == false) {
            devuelveReglamentario = "NO";
        } else {
            devuelveReglamentario = "SI";
        }
        return devuelveReglamentario;
    }
}
