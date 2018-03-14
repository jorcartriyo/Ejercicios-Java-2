package edad;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Router1
 */
public class EdadException extends Exception {

    /**
     * Creates a new instance of <code>EdadException</code> without detail
     * message.
     */
    public EdadException() {
        super();
    }

    /**
     * Constructs an instance of <code>EdadException</code> with the specified
     * detail message.
     *
     * @param s the detail message.
     */
    public EdadException(String s) {
        super(s);
    }
}
