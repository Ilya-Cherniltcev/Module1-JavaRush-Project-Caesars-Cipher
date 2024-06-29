package main.java.rush.services;

import main.java.rush.Data.Alphabet;
import main.java.rush.exceptions.FileNotExistsException;
import main.java.rush.exceptions.WrongInputException;
import main.java.rush.exceptions.WrongKeyException;

import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {

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

    public boolean isFileExists(String filename) {
        return Files.exists(Path.of(filename));
    }

    public void isValidKey(String keyStr) {
        Alphabet alphabet = new Alphabet();
        int key = Integer.parseInt(keyStr);
        if (key < 0 || key > alphabet.length()) {
            throw new WrongKeyException("Wrong length of key");
        }
    }
}
