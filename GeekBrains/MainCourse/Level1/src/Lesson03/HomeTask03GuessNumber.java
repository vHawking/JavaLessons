package Lesson03;

import java.util.Scanner;

/**
 * Java. Уровень1. Домашнее задание по 3 лекци.
 *
 * @author Вадим Ястребов.
 * @version 5 Февраля 2018 г.
 *
 * Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается три попытки угадать это число.
 * При каждой попытке компьютер должен сообщить больше ли указанное пользователем число, чем загаданное, или меньше.
 * После победы, или проигрыша, выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет» (1 – повторить, 0 – нет).
 */

public class HomeTask03GuessNumber {
    private static Scanner scanner = new Scanner(System.in);

/*
     Метод guessNumber() состоит из двух вложенных циклов. Первый: do-while для того, чтобы у пользователя была
     позможность выбора: продолжить игру, или выйти после того, как игрок исчерпает количество попыток угадать число.
     Второй цикл – while() выполняется столько раз, сколько задано попыток угадать число в методе main. По умолчанию это
     значение равно 3.
*/

    private static void guessNumber(int tryNumbers, int minRange, int maxRange) {
            do {
                int tryTimes = tryNumbers;
                int cpuNum = (int) (Math.random() * maxRange);
                System.out.printf("\nИгра предлагает угадать число, загаданное компьютером." +
                        "\nКоличество попыток: %d.\n\n", tryNumbers);
                while (tryTimes > 0) {
                    System.out.printf("Введите число от %d до %d: ", minRange, maxRange);
                    foolProtect();
                    int userNum = scanner.nextInt();
                    if (userNum < cpuNum) {
                        System.out.println("Ваше число меньше загаданного компьютером.");
                    } else if (userNum > cpuNum) {
                        System.out.println("Ваше число больше загаданного компьютером.");
                    } else {
                        System.out.println("Поздравляем! Вы угадали число!");
                        break;
                    }
                    tryTimes--;
                    System.out.println((tryTimes > 0) ? "Осталось попыток: " + tryTimes + "\n" :
                            "У вас не осталось попыток.\nВы проиграли.");
                }
            } while (exitGame());
        System.out.println("\nЗавершение работы программы.\nИгра окончена.");
    }

/*
    Метод exitGame() возвращает 0 в цикл do-while метода guessNumber() для выхода из основного цикла программы, или
    1 для продолжения. Другие значения метод игнорирует и просит ввести либо 0, либо 1.
*/

    private static boolean exitGame() {
        System.out.print("\nХотите снова поиграть?\n1 – Да / 0 - Выход из программы: ");
        int exit;
        boolean flag;
        do {
            flag = true;
            foolProtect();
            exit = scanner.nextInt();
            if (exit < 0 || exit > 1) {
                flag = false;
                System.out.print("Введите 1, или 0: ");
            }
        } while (!flag);
        return exit != 0;
    }

/*
    Отдельным методом foolProtect() реализована защита от дурака, чтобы юзер не вводил «стопиццот», или какую-нибудь
    абра-кадабру, которая может сломать программу.
*/

    private static void foolProtect() {
        while (!scanner.hasNextInt()) {
            System.out.print("Неверный формат. Введите целое число: ");
            scanner.next();
        }
    }

/*
    В методе main() инициализируем переменные, отвечающие за количество попыток и диапазон загадываемого значения. После
    чего, вызываем метод guessNumber() и передаём туда значения этих переменных.
*/

    public static void main(String[] args) {
        int minRange = 0;
        int maxRange = 9;
        int tryNumbers = 3;

        guessNumber(tryNumbers, minRange, maxRange);
        scanner.close();
    }
}
