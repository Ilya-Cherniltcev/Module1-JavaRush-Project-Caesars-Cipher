package main.java.rush.exceptions;

public class WrongKeyException extends RuntimeException {
    public WrongKeyException(String wrongLengthOfKey) {
        super(wrongLengthOfKey);
    }
}
