package main.java.rush.Data;

import java.util.*;

public class Alphabet {
    private Map<Integer, Character> alphabetMap;
    private final char[] Alphabet = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я',
            '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};
    // Number of letters - 31
    // Number of service symbols (space, '«', '»', '"'... ) - 10 (at the end)
    // Total number of symbols - 41


    public Alphabet() {
        alphabetMap = new TreeMap<>();
        int counter = 0;
        for (char symbol : Alphabet) {
            alphabetMap.put(counter, symbol);
            counter++;
        }
    }

    public int length() {
        return Alphabet.length;
    }

    public char getSymbolByIndex(int index) {
        return Alphabet[index];
    }

    public int getIndexByValue(char value) {
        for (Map.Entry<Integer, Character> entry : alphabetMap.entrySet()) {
            if (value == entry.getValue()) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public boolean isSymbolExists(char checkSymbol) {
        for (Map.Entry<Integer, Character> entry : alphabetMap.entrySet()) {
            if (checkSymbol == entry.getValue()) {
                return true;
            }
        }
        return false;
    }
}