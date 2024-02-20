package learnjava;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class Task1 {
    
    private static final Scanner scan = new Scanner(System.in);
    private static final int choise = -1;

    private static void Menu() {
        System.out.println("LEARN JAVA. Задание 1");
        System.out.println(
                "1. Заполнить список" + System.lineSeparator()
                + "2. Посчитать сумму чисел в списке" + System.lineSeparator()
                + "3. Посчитать среднюю чисел в списке" + System.lineSeparator()
                + "0. Выход"
        );
    }

    private static double SumDigits(List<Integer> digits) {
        double sum = 0.0;
        for (int i = 0; i < digits.size(); i++) {
            sum = sum + digits.get(i);
        }
        return sum;
    }

    private static double AveDigits(List<Integer> digits) {
        double ave;
        double sum = 0.0;

        int size = digits.size();

        for (int i = 0; i < size; i++) {
            sum = sum + digits.get(i);
        }

        ave = sum / size;

        return ave;
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
        
        List<Integer> digits = new ArrayList();

        while (true) {
            Menu();

            switch (intBreaker(choise)) {
                case 0 ->{
                    System.out.println(System.lineSeparator() + "Переход..." + System.lineSeparator());
                    LearnJava.main(args);
                }
                case 1 -> {
                    boolean isEnd = false;
                    System.out.println("Заполните список. Для завершения введите '0' (без кавычек)");
                    while (!isEnd) {
                        boolean valid_digit = false;
                        System.out.print("Введите число: ");
                        if (scan.hasNextInt()) {
                            int input = scan.nextInt();
                            if (input == 0) {
                                isEnd = true;
                            } else {
                                digits.add(input);
                                valid_digit = true;
                            }
                        } else {
                            System.out.println("Необходимо ввести число!");
                            scan.next();
                        }
                    }
                    System.out.println(digits);
                }
                case 2 ->
                    System.out.println("Сумма чисел в списке: " + SumDigits(digits));
                case 3 ->
                    System.out.println("Среднее чисел в списке: " + AveDigits(digits));
            }

        }
    }
}
