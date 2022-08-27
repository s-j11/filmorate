package exseptions;

public class InvalidFilmNameException extends Exception{
    public InvalidFilmNameException() {
    }
    public InvalidFilmNameException(String message) {
        super(message);
    }
}
