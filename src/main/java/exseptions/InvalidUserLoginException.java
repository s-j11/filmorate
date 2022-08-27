package exseptions;

public class InvalidUserLoginException extends Exception{
    public InvalidUserLoginException() {
    }
    public InvalidUserLoginException(String message) {
        super(message);
    }
}
