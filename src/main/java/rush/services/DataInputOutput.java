package main.java.rush.services;

import main.java.rush.Data.Alphabet;
import main.java.rush.exceptions.FileNotExistsException;
import main.java.rush.exceptions.WrongInputException;

import java.util.Scanner;
import java.util.logging.Logger;

public class DataInputOutput {
    private final Validator validator;

    public DataInputOutput() {
        validator = new Validator();
    }

    public void dataInputOutput(String operationId) {
        String firstNameOfFile = "";
        String secondNameOfFile = "";
        String shift = "";
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please input full path and name of 1 file: ");
            firstNameOfFile = scanner.nextLine();
            // check first file ---------------------------------------
            if (!validator.isFileExists(firstNameOfFile)) {
                throw new FileNotExistsException("The file is not exist!");
            }

            System.out.print("Please input shift of coding/decoding (key): ");
            shift = scanner.nextLine();
            // check key (correct shift)
            validator.isValidKey(shift);

            System.out.print("Please input full path and name of 2 file: ");
            secondNameOfFile = scanner.nextLine();
            // check second file -------------------------------------
            validator.checkCorrectFilename(secondNameOfFile);
        } catch (Exception e) {
            throw new WrongInputException(e.getMessage());
        }
        EncoderDecoder encoderDecoder = new EncoderDecoder();
        // if menu item == "1" call encode method
        if (operationId.equals("1")) {
            // read first file
            FileManager fileManager = new FileManager();
            String text = fileManager.readFile(firstNameOfFile);
//            System.out.println(text);
            // coding text
            String cryptText = encoderDecoder.cryptText(text, Integer.parseInt(shift));
            // write codding text to second file
            fileManager.writeFile(cryptText, secondNameOfFile);
        }
    }
}
