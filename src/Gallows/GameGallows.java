package Gallows;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class GameGallows {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException, UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        
        String word = String.valueOf(WordsList.RandomWord());
        HashMap word_char = new HashMap();
        HashMap word_char_empty = new HashMap();

        for (int i = 1; i <= word.toCharArray().length; i++) {
            word_char.put(i, word.charAt(i - 1));
        }

        for (int i = 1; i <= word_char.size(); i++) {
            word_char_empty.put(i, "_");
        }

        int attempts = 8;
        
        System.out.println("Введите букву: ");
                    
        while (attempts > 0 && !word_char.equals(word_char_empty)) {

            String chartry = scan.nextLine();

            if (chartry.matches("[а-яА-Я]")) {
                if (word_char.containsValue(chartry.charAt(0))) {
                    for (int i = 1; i <= word_char.size(); i++) {
                        if (word_char.get(i).equals(chartry.charAt(0))) {
                            word_char_empty.put(i, chartry.charAt(0));
                        }
                    }
                    System.out.println("Вы угадали букву!");
                    System.out.println(word_char_empty.values());
                } else {
                    attempts--;
                    System.out.println("Вы не угадали букву!");
                    System.out.println("У вас осталось " + attempts + " попыток");
                }
            } else {
                System.out.println("Вы должны ввести одну русскую букву!");
                System.out.println("Введите букву: ");
            }
        }

        if (word_char.equals(word_char_empty)) {
            System.out.println("Поздравляем, вы угадали слово!");
            System.out.println("Слово: " + word);
        } else {
            System.out.println("К сожалению, вы проиграли!");
            System.out.println("Слово: " + word);
        }
    }

}
