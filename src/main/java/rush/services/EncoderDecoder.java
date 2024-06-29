package main.java.rush.services;

import main.java.rush.Data.Alphabet;

import java.util.HashSet;
import java.util.Set;

public class EncoderDecoder {
    Alphabet alphabet;

    public EncoderDecoder() {
        alphabet = new Alphabet();
    }


    public String decodeText(String codeText, int shift) {

        return null;
    }

    public String cryptText(String text, int shift) {
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
}
