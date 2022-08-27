package exseptions;

public class InvalidUserEmailException extends Exception{
    public InvalidUserEmailException() {
    }
    public InvalidUserEmailException(String message) {
        super(message);
    }
}