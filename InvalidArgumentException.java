package Exceptions;


/**
 * Exception handler for when an element isn't in a collection
 * @author clatulip
 */
public class InvalidArgumentException extends Exception {
    public InvalidArgumentException(String arg) {
        super("The argument " + arg + "was invalid.");
    }

    public InvalidArgumentException() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
