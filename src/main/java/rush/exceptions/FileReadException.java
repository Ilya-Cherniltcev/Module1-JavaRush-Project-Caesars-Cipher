package main.java.rush.exceptions;

public class FileReadException extends RuntimeException {
    public FileReadException(String errorReadingOfFile) {
        super(errorReadingOfFile);
    }
}
