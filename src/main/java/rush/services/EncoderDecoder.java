package main.java.rush.services;

import main.java.rush.Data.Alphabet;

public class EncoderDecoder {
    Alphabet alphabet;

    public EncoderDecoder() {
        alphabet = new Alphabet();
    }

    /**
     * To crypt text by Caesar's Cipher
     *
     * @param text  inputted text for coding
     * @param shift shift parameter
     * @return encrypted string
     */
    public String encryptText(String text, int shift) {
        // compare char in text and char in alphabet
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            int orderInAlphabet = alphabet.getIndexByValue(symbol);
            char newSymbol;
            // find symbol in alphabet. If it doesn't exist then skip it
            if (!alphabet.isSymbolExists(symbol)) {
                continue;
            }
            // * case 1 *
            if ((orderInAlphabet + shift) <= alphabet.length() - 1) {
                newSymbol = alphabet.getSymbolByIndex(orderInAlphabet + shift);
            }
            // * case 2 *
            else {
                newSymbol = alphabet.getSymbolByIndex((orderInAlphabet + shift) - alphabet.length());
            }
            builder.append(newSymbol);
        }
        return builder.toString();
    }

    /**
     * To decrypt text by Caesar's Cipher
     *
     * @param text  inputted text for decoding
     * @param shift shift parameter
     * @return decrypted string
     */
    public String decryptText(String text, int shift) {
        // compare char in text and char in alphabet
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            int orderInAlphabet = alphabet.getIndexByValue(symbol);
            char newSymbol;
            // find symbol in alphabet. If it doesn't exist then skip it
            if (!alphabet.isSymbolExists(symbol)) {
                continue;
            }
            // * case 1 *
            if ((orderInAlphabet - shift) >= 0) {
                newSymbol = alphabet.getSymbolByIndex(orderInAlphabet - shift);
            }
            // * case 2 *
            else {
                newSymbol = alphabet.getSymbolByIndex((orderInAlphabet - shift) + alphabet.length());
            }
            builder.append(newSymbol);
        }
        return builder.toString();
    }
}
