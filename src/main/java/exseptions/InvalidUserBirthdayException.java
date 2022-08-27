package exseptions;

public class InvalidUserBirthdayException extends Exception{
    public InvalidUserBirthdayException() {
    }
    public InvalidUserBirthdayException(String message) {
        super(message);
    }
}