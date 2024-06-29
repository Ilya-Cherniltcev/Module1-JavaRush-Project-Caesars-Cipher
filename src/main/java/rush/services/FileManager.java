package main.java.rush.services;

import main.java.rush.exceptions.FileReadException;
import main.java.rush.exceptions.FileWriteException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

public class FileManager {
    private static final Logger logger = Logger.getLogger("FileManager logger");


    public String readFile(String filePath) {
        int counter = 1;
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
//                logger.info(STR."String \{counter} has read");
                builder.append(line);
                counter++;
            }
        } catch (IOException e) {
            logger.warning((STR."String \{counter} in file \{filePath} hasn't read!"));
            throw new FileReadException("Error reading of file");
        }
        return builder.toString();
    }

    public void writeFile(String content, String filePath) {
        Validator validator = new Validator();
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(filePath))) {
            if (!validator.isFileExists(filePath)) {
                Files.createFile(Path.of(filePath));
            }
            writer.write(content);
        } catch (IOException e) {
            throw new FileWriteException("Error writing of file");
        }
    }
}
