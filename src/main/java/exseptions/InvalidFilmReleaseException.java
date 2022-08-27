package exseptions;

public class InvalidFilmReleaseException extends Exception{
    public InvalidFilmReleaseException() {
    }
    public InvalidFilmReleaseException(String message) {
        super(message);
    }
}
