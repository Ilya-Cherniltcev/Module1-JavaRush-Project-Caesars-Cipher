package main.java.rush.exceptions;

public class FileWriteException extends RuntimeException {
    public FileWriteException(String errorWritingOfFile) {
        super(errorWritingOfFile);
    }
}
