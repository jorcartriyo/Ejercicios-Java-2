package libro;

public class Escritor extends Thread {

    private final Libro libro;
    private final int espera;
    private final int id;

    public Escritor(Libro l, int id, int espera) {  
        this.libro = l;
        this.id = id ;
        this.espera = espera;
    }

    public int escritor() {
        int letras = (int) (Math.random() * 2);
        return letras;
    }

    @Override
    public void run() {
        while (!libro.libroTerminado()) {
               libro.escribeLibro(escritor(), id);               
            try {                         
                sleep(espera);
            } catch (InterruptedException e) {
            }
            libro.terminarEscribir(id);
        }     
    }
}
