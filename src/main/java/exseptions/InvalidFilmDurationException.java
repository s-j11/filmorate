package exseptions;

public class InvalidFilmDurationException extends Exception {
    public InvalidFilmDurationException() {
    }

    public InvalidFilmDurationException(String message) {
        super(message);
    }
}
