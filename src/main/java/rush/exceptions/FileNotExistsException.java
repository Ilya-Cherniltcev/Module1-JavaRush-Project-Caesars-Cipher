package main.java.rush.exceptions;

public class FileNotExistsException extends RuntimeException {
    public FileNotExistsException(String message) {
        super(message);
    }
}
