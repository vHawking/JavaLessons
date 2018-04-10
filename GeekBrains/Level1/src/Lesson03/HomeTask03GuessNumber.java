package Lesson03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Java. Уровень1. Домашнее задание по 3 лекции.
 * Игра «Угадай число».
 *
 * @author Вадим Ястребов.
 * @version 5 Февраля 2018 г.
 *
 * Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается три попытки угадать это число.
 * При каждой попытке компьютер должен сообщить больше ли указанное пользователем число, чем загаданное, или меньше.
 * После победы, или проигрыша, выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет» (1 – повторить, 0 – нет).
 */

public class HomeTask03GuessNumber {
    private static final int minRange = 0;
    private static final int maxRange = 9;
    private static final int tryNumbers = 3;
    private static Scanner scanner = new Scanner(System.in);

    /*
     Метод triesCount() позволяет программе общаться с пользователем по-человечески на русском языке и склонять
     слово «попытка» в зависимости его числового количества и значения.
     */

    private static String triesCount(int tryTimes) {
        int t1;
        int t2;
        t1 = tryTimes % 10;
        t2 = tryTimes % 100;

        if (t1 == 1 && t2 != 11) {
            return "попытка";
        } else if (t1 >= 2 && t1 <= 4 && (t2 < 10 || t2 >= 20)) {
            return "попытки";
        } else {
            return "попыток";
        }
    }

    /*
     Метод guessNumber() состоит из цикла while() и выполняется столько раз, сколько задано попыток угадать число
     в переменной tryNumbers. По-умолчанию это значение равно 3.
     */

    private static void guessNumber(int cpuNum) {
        int tryTimes = tryNumbers;

        while (tryTimes > 0) {
            System.out.printf("Введите число от %d до %d: ", minRange, maxRange);
            try {
                int userNum = scanner.nextInt();
                if (userNum < cpuNum && tryTimes != 1) {
                    System.out.print("Ваше число меньше загаданного.\n");
                } else if (userNum > cpuNum && tryTimes != 1) {
                    System.out.print("Ваше число больше загаданного.\n");
                } else if (userNum == cpuNum) {
                    System.out.println("Поздравляем! Вы угадали число!\n");
                    break;
                }
                tryTimes--;

                if (tryTimes > 0) {
                    String tries = triesCount(tryTimes);
                    System.out.printf("Остал%cсь %d %s.\n\n", (tries.equals("попытка")) ? 'а' : 'о', tryTimes, tries);
                } else {
                    System.out.printf("У вас не осталось попыток. Было загадано число %d.\nВы проиграли.\n\n", cpuNum);
                }
            } catch (InputMismatchException ex) {
                scanner.next();
            }
        }
    }

    /*
    Метод exitGame() возвращает 0 в цикл do-while для выхода из основного цикла программы, или 1 для продолжения.
    Другие значения метод игнорирует и просит ввести либо 0, либо 1.
    */

    private static boolean exitGame() {
        int exit;

        System.out.print("Хотите поиграть снова?\n1 – Да / 0 - Выход из программы: ");
        while (true) {
            try {
                exit = scanner.nextInt();
                if (exit < 0 || exit > 1) {
                    System.out.print("Введите 1 или 0: ");
                } else {
                    System.out.println();
                    return exit != 0;
                }
            } catch (InputMismatchException ex) {
                System.out.print("Ошибка! Попробуйте снова: ");
                scanner.next();
            }
        }
    }

    /*
    Цикл do-while в методе main служит для того, чтобы у пользователя была позможность выбора: продолжить игру,
    или выйти после того, как игрок исчерпает количество попыток угадать число.
    */

    public static void main(String[] args) {
        do {
            int cpuNum = (int) (Math.random() * maxRange);
            System.out.printf("Игра предлагает угадать число, загаданное компьютером." +
                    "\nКоличество попыток: %d.\n\n", tryNumbers);
            guessNumber(cpuNum);
        } while (exitGame());
        System.out.println("Завершение работы программы.\nИгра окончена.");
        System.out.println("© 2018 Вадим Ястребов, mailcome@yandex.ru.");
        scanner.close();
    }
}