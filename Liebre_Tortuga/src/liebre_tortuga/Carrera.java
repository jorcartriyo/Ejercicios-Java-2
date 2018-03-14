package liebre_tortuga;

/**
 * Clase que representa la carrera.
 *
 * @author Jorge Ortega González
 */
public class Carrera {

    private final String[] carreraL;
    private final String[] carreraT;
    private boolean avanza = false;
    private boolean salirT = false, salirL = false;

    /**
     * Constructor que crea el array de la carrera de la tortuga la la liebre.
     */
    public Carrera() {
        carreraL = new String[70];
        carreraT = new String[70];
    }

    /**
     * Este método muestra el recorrido de la liebre dentro del array
     * estableciendo una L en la posición que indique el recorridoL
     *
     * @param recorridoL entero que establece la posición que tendrá la liebre.
     */
    public void setRecorridoL(int recorridoL) {
        for (int i = 0; i < 70; i++) {
            carreraL[i] = "_";
        }
        carreraL[recorridoL] = "L";
    }

    /**
     * Este método muestra el recorrido de la tortuga dentro del array
     * estableciendo una T en la posición que indique el recorridoT
     *
     * @param recorridoT entero que establece la posición que tendrá la tortuga.
     */
    public void setRecorridoT(int recorridoT) {
        for (int i = 0; i < 70; i++) {
            carreraT[i] = "_";
        }
        carreraT[recorridoT] = "T";
    }

    /**
     * Este método imprime la carrera de la liebre.
     *
     * @param recorridoL entero que establece la posición que tendrá la liebre.
     */
    public void getRecorridoL(int recorridoL) {
        for (int i = 0; i < 70; i++) {
            System.out.print(carreraL[i]);
        }
        System.out.println("");
    }

    /**
     * Este método imprime la carrera de la tortuga.
     *
     * @param recorridoT entero que establece la posición que tendrá la tortuga.
     */
    public void getRecorridoT(int recorridoT) {
        for (int i = 0; i < 70; i++) {
            System.out.print(carreraT[i]);
        }
        System.out.println("");

    }

    /**
     * Método sincronizado al que accede la clase Liebre y va realizando los
     * métodos de la carrera hasta que llega a la posición 70 y termina
     *
     * @param recorridoL entero que establece la posición que tendrá la liebre.
     */
    public synchronized void recorridoL(int recorridoL) {
        while (avanza == false) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        if (recorridoL >= 69) {
            recorridoL = 69;
            salirL = true;
            System.out.println("");
            System.out.println("Has ganado liebrecita");
        }
        if (!salirT) {
            setRecorridoL(recorridoL);
            getRecorridoL(recorridoL);
            avanza = false;
            notify();
        }
    }

    /**
     * Método sincronizado al que accede la clase Tortiga y va realizando los
     * métodos de la carrera hasta que llega a la posición 70 y termina
     *
     * @param recorridoT entero que establece la posición que tendrá la tortuga.
     */
    public synchronized void recorridoT(int recorridoT) {
        while (avanza == true) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        if (recorridoT >= 69) {
            recorridoT = 69;
            salirT = true;
            System.out.println("");
            System.out.println("Has ganado tortuguita");
        }
        //esto es para ver solo dos líneas dependiendo de la longitud de la consola hay que establecer el número
        if (!salirT) {
            limpiar(20);
            setRecorridoT(recorridoT);
            getRecorridoT(recorridoT);
            avanza = true;
            notify();
        }
    }

    /**
     * Método para limpiar la pantalla cada vez que se ejecuta un movimiento.
     *
     * @param lineas entero que establece las líneas que borra de la pantalla.
     */
    public void limpiar(int lineas) {
        for (int i = 0; i < lineas; i++) {
            System.out.println("");
        }
    }

    /**
     * Método que establece que la carrera ha terminado porque uno de los
     * contrincantes ha terminado.
     *
     * @return salirT, salirL booleano que dice quien ha ganado.
     */
    public boolean hayGanador() {
        return (salirT || salirL);

    }

    /**
     * Método para determinar si ha habido empate
     *
     * @param recorridoT entero que establece la posición de la tortuga.
     * @param recorridoL entero que establece la posición de la liebre.
     */
    public void empate(int recorridoT, int recorridoL) {
        if (recorridoT == recorridoL) {
            System.out.println("Al final han empatado la Liebre y la Tortuga");
            hayGanador();
        }
    }
}
