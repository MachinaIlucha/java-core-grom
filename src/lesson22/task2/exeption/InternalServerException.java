package lesson22.task2.exeption;

public class InternalServerException extends Exception {
    public InternalServerException(String message) {
        super(message);
    }
}
