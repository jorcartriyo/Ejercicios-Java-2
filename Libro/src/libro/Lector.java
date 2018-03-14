package libro;

public class Lector extends Thread {

    private final Libro libro;
    private final int espera;
    private final int id;

    public Lector(Libro l, int id, int espera) {
        libro = l;
        this.espera = espera;
        this.id = id;
    }

    @Override
    public void run() {
        while (!libro.libroTerminado()) {
            libro.leeLibro(id);           
            libro.terminarLeer(id);
            try {
                sleep(espera);
            } catch (InterruptedException e) {
            }
        }
    }
}
