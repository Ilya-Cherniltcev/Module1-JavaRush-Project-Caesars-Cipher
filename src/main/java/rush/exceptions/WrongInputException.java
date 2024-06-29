package main.java.rush.exceptions;

public class WrongInputException extends RuntimeException {
    public WrongInputException() {
    }

    public WrongInputException(String message) {
        super(message);
    }
}
