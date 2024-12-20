package hust.soict.hedspi.aims.exception;
//Phuc 20225905
public class PlayerException extends Exception { // Now extends Exception

    public PlayerException() {
        super();
    }

    public PlayerException(String message) {
        super(message);
    }

    public PlayerException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlayerException(Throwable cause) {
        super(cause);
    }
}