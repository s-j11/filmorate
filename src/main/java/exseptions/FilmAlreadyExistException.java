package exseptions;

public class FilmAlreadyExistException extends Exception {
        public FilmAlreadyExistException() {
        }
        public FilmAlreadyExistException(String message) {
            super(message);
        }
}
