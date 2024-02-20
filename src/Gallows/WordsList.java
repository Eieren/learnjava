package Gallows;

import java.util.*;

public class WordsList {

    private static final String[] words = {
        "одеяло"
    };

    public static final String RandomWord() {
        int length = words.length;
        Random rand = new Random();
        int word_index = rand.nextInt(length);
        return words[word_index];
    }
}
