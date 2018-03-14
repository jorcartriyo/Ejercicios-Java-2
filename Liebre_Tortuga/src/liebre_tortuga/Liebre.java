package liebre_tortuga;

/**
 * Clase que representa a la liebre en la carrera calculando la probabilidad y
 * según esta mandando su posición a la carrera, hereda de Tread.
 *
 * @author Jorge Ortega González
 */
public class Liebre extends Thread {

    private final Carrera carrera;
    private final int numero;
    private int recorridoL;
    private int probabilidadL;
    private int tiradaL;

    /**
     * Constructor que recibe la carrera de la liebre y un número entero que
     * define la espera.
     *
     * @param c objeto que le pasamos de la clase carrera al constructor.
     * @param numero espera que va a tener el hilo.
     */
    public Liebre(Carrera c, int numero) {
        carrera = c;
        this.numero = numero;
        tiradaL = 0;
    }

    /**
     * Este método calcula aleatoriamente la probabilidad que tiene la liebre.
     *
     * @return probabilidadT entero entre 1 y 100 con la probabilidad.
     */
    public int getProbabilidadL() {
        probabilidadL = (int) (Math.random() * 100);
        return probabilidadL;
    }

    /**
     * Este método establece los movimientos que debe de realizar la liebre
     * según la probabilidad que le haya salido en le método anterior.
     *
     * @return recorridoL con el número que debe de ocupar en la carrera.
     */
    public int mueveL() {
        probabilidadL = getProbabilidadL();
        if (probabilidadL <= 20) {
            recorridoL = recorridoL;
        }
        if (probabilidadL > 20 && probabilidadL <= 40) {
            recorridoL = recorridoL + 9;
        }
        if (probabilidadL > 40 && probabilidadL <= 50) {
            if (recorridoL < 13) {
                recorridoL = 0;
            } else {
                recorridoL = recorridoL - 12;
            }
        }
        if (probabilidadL > 50 && probabilidadL <= 80) {
            recorridoL = recorridoL + 1;
        }
        if (probabilidadL > 80) {
            if (recorridoL < 3) {
                recorridoL = 0;
            } else {
                recorridoL = recorridoL - 2;
            }
        }
        tiradaL++;
        return recorridoL;
    }

    /**
     * Este método sobreescrito de Thread llama al método recorridoL de la clase
     * carrera y pone a la liebre en el lugar que le corresponde del array que
     * crea el método anterior
     */
    @Override
    public void run() {
        while (!carrera.hayGanador()) {
            carrera.recorridoL(mueveL());
            System.out.println("Probabilidad Liebre " + probabilidadL);
            System.out.println("Recorrido Liebre " + mueveL());
            try {
                sleep(numero);
            } catch (InterruptedException e) {
            }
        }
    }
}
