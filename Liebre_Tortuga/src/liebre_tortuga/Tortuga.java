package liebre_tortuga;

/**
 * Clase que representa a la tortuga en la carrera calculando la probabilidad y
 * según esta mandando su posición a la carrera, hereda de Tread
 *
 * @author Jorge Ortega González
 */
public class Tortuga extends Thread {

    private final Carrera carrera;
    private final int numero;
    private int recorridoT = 0;
    private int probabilidadT;

    /**
     * Constructor que recibe la carrera de la tortuga y un número entero que
     * define la espera.
     *
     * @param c objeto que le pasamos de la clase carrera al constructor.
     * @param numero espera que va a tener el hilo.
     */
    public Tortuga(Carrera c, int numero) {
        carrera = c;
        this.numero = numero;
    }

    /**
     * Este método calcula aleatoriamente la probabilidad que tiene la tortuga.
     *
     * @return probabilidadT entero entre 1 y 100 con la probabilidad.
     */
    public int getProbabilidadT() {
        probabilidadT = (int) (Math.random() * 100);
        return probabilidadT;
    }

    /**
     * Este método establece los movimientos que debe de realizar la tortuga
     * según la probabilidad que le haya salido en le método anterior.
     *
     * @return recorridoT con el número que debe de ocupar en la carrera.
     */
    public int mueveT() {
        probabilidadT = getProbabilidadT();
        if (probabilidadT <= 50) {
            recorridoT = recorridoT + 3;
        }
        if (probabilidadT > 50 && probabilidadT <= 70 && recorridoT >= 6) {
            if (recorridoT <= 6) {
                recorridoT = 0;
            } else {
                recorridoT = recorridoT - 6;
            }
        }
        if (probabilidadT > 70) {
            recorridoT = recorridoT + 1;
        }
        return recorridoT;
    }

    /**
     * Este método sobreescrito de Thread llama al método recorridoT de la clase
     * carrera y pone a la tortuga en el lugar que le corresponde del array que
     * crea el método anterior
     */
    @Override
    public void run() {
        while (!carrera.hayGanador()) {
            carrera.recorridoT(mueveT());
            System.out.println("Probabilidad Tortuga " + probabilidadT);
            System.out.println("Recorrido Tortuga " + mueveT());
            try {
                sleep(numero);
            } catch (InterruptedException e) {
            }
        }
    }
}
