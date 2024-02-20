package learnjava;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class LearnJava {
    private static final Scanner scan = new Scanner(System.in);
    private static final int choise = -1;

    private static void Menu() {
        System.out.println("LEARN JAVA");
        System.out.println(
                "1. Задание 1" + System.lineSeparator()
                + "2. Игра" + System.lineSeparator()
                + "0. Выход"
        );
    }

    private static int intBreaker(int choise) throws InterruptedException {
        boolean valid = false;
        while (valid != true) {
            System.out.print("-->");
            if (scan.hasNextInt()) {
                choise = scan.nextInt();
                Thread.sleep(100);
                valid = true;
            } else {
                System.out.println("Необходимо ввести число!");
                scan.next();
            }
        }
        return choise;
    }

    public static void main(String[] args) throws InterruptedException, UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));

        while (true) {
            Menu();

            switch (intBreaker(choise)) {
                case 0 ->
                    System.exit(0);
                case 1 -> {
                    System.out.println(System.lineSeparator() + "Переход..." + System.lineSeparator());
                    Task1.main(args);
                }
                case 2 -> {
                    System.out.println(System.lineSeparator() + "Переход..." + System.lineSeparator());
                    Gallows.GameGallows.main(args);
                }
                default ->
                    Thread.sleep(1);
            }

        }
    }

}
