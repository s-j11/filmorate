package exseptions;

public class InvalidFilmDescriptionException extends Exception {
    public InvalidFilmDescriptionException() {
    }

    public InvalidFilmDescriptionException(String message) {
        super(message);
    }
}