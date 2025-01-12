package main.java.rush.services;

import main.java.rush.Data.Alphabet;
import main.java.rush.exceptions.WrongInputException;
import main.java.rush.exceptions.WrongKeyException;

import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {

    /**
     * Check path and file.
     * If it doesn't exist we try to create it.
     *
     * @param filename path and filename
     * @throws WrongInputException If filename is wrong, we throw new exception
     */
    public void checkCorrectFilename(String filename) {
        try {
            if (!isFileExists(filename)) {
                Path path = Path.of(filename);
                Files.createFile(path);
            }
        } catch (Exception e) {
            throw new WrongInputException("Incorrect filename!");
        }
    }

    /**
     * Checking file on exist.
     *
     * @param filename path and filename
     * @return true - if file exists
     */
    public boolean isFileExists(String filename) {
        return Files.exists(Path.of(filename));
    }

    /**
     * Checking key on valid.
     *
     * @param keyStr key of cipher (shift)
     * @throws WrongKeyException If key is more then length of alphabet or less than zero,
     *                           we throw new exception
     */
    public void isValidKey(String keyStr) {
        Alphabet alphabet = new Alphabet();
        int key = Integer.parseInt(keyStr);
        if (key < 0 || key > alphabet.length()) {
            throw new WrongKeyException("Wrong length of key");
        }
    }
}
