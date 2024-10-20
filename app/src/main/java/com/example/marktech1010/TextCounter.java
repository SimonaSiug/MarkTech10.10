package com.example.marktech1010;

public class TextCounter {

    public static int getCharsCount(String inputPhrase) {
        if (inputPhrase != null) {
            return inputPhrase.length();
        }
        return 0;
    }
    public static int getWordsCount(String inputPhrase) {
        if (inputPhrase != null && !inputPhrase.trim().isEmpty()) {
            String[] words = inputPhrase.trim().split("\\s+");
            return words.length;
        }
        return 0;
    }
    public static int getCount(String inputPhrase, boolean countChars) {
        if (inputPhrase == null || inputPhrase.trim().isEmpty()) {
            return 0;
        }
        return countChars ? getCharsCount(inputPhrase) : getWordsCount(inputPhrase);
    }
}
