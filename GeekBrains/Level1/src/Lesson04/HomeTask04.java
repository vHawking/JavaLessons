package Lesson04;

import java.util.Random;
import java.util.Scanner;

/**
 * Java. Уровень1. Домашнее задание по 4 лекции.
 * Игра «Крестики-нолики» в процедурном стиле.
 *
 * @author Вадим Ястребов.
 * @version 9 Февраля 2018 г.
 */

public class HomeTask04 {

    // 2. Определяем размер массива

    private static final int SIZE_X = 3;
    private static final int SIZE_Y = 3;
    private static final int SIZE_WIN = 3;
    private static Scanner scan = new Scanner(System.in);
    private static final Random ran = new Random();

    // 1. Создаём двумерный массив

    private static char[][] field = new char[SIZE_Y][SIZE_X];

    // 3. Определяем кто и какими фишками будет ходить

    private static final char PLAYER_DOT = 'X';
    private static final char AI_DOT = 'O';
    private static final char EMPTY_DOT = ' ';

    // 4. Заполняем массив

    private static void initField() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    // 5. Рисуем игровое поле

    private static void printField() {
        int numCol = 0;
        char letterRow = 'a';

        System.out.println();
        System.out.print("\t ");
        for (int x = 0; x < SIZE_X; x++) {
            System.out.print(" " + (numCol++) + "  ");
        }
        System.out.println();

        System.out.print("\t+");
        for (int x = 0; x < SIZE_X; x++) {
            System.out.print("---+");
        }
        System.out.println();

        for (int i = 0; i < SIZE_Y; i++) {
            System.out.print("  " + (letterRow++) + " ¦");
            for (int j = 0; j < SIZE_X; j++) {
                System.out.print(" " + field[i][j] + " ¦");
            }
            System.out.println();
            System.out.print("\t+");
            for (int x = 0; x < SIZE_X; x++) {
                System.out.print("---+");
            }
            System.out.println();
        }
    }

    // 6. Установка символа на поле

    private static void setSymbol(int y, int x, char symbol) {
        field[y][x] = symbol;
    }

    // 7a. Метод переназначает введенный символ переменной типа char в значение int, отвечающее за номер строки

    private static int charToNum(char y) {
        switch (y) {
            case 'a':
                y = 0;
                break;
            case 'b':
                y = 1;
                break;
            case 'c':
                y = 2;
                break;
        }
        return y;
    }

    private static char numToChar(int row) {
        char y = (char) row;
        switch (y) {
            case 0:
                y = 'a';
                break;
            case 1:
                y = 'b';
                break;
            case 2:
                y = 'c';
                break;
        }
    return y;
    }

    // 7b. Ход игрока

    private static void playerStep() {
        int x;
        int y;
        int row = SIZE_Y - 1;
        int col = SIZE_X - 1;
        do {
            System.out.println("\nВведите координаты для хода.");
            System.out.printf("По горизонтали от a до %c: ", numToChar(row));
            y = charToNum(scan.next().toLowerCase().charAt(0));
            System.out.printf("По вертикали от 0 до %d: ", col);
            x = scan.nextInt();
        } while (!isCellValid(y, x));
        setSymbol(y, x, PLAYER_DOT);
    }

    // 8. Ход компьютера (AI)

    private static void aiStep() {
        int x, y;

        // Блокировка ходов игрока

        for (int v = 0; v < SIZE_Y; v++) {
            for (int h = 0; h < SIZE_X; h++) {
                //анализ наличия поля для проверки
                if (h + SIZE_WIN <= SIZE_X) {                           //по горизонтали
                    if (checkLineHorizon(v, h, PLAYER_DOT) == SIZE_WIN - 1) {
                        if (MoveAiLineHorizon(v, h, AI_DOT)) return;
                    }

                    if (v - SIZE_WIN > -2) {                            //вверх по диагонали
                        if (checkDiaUp(v, h, PLAYER_DOT) == SIZE_WIN - 1) {
                            if (MoveAiDiaUp(v, h, AI_DOT)) return;
                        }
                    }
                    if (v + SIZE_WIN <= SIZE_Y) {                       //вниз по диагонали
                        if (checkDiaDown(v, h, PLAYER_DOT) == SIZE_WIN - 1) {
                            if (MoveAiDiaDown(v, h, AI_DOT)) return;
                        }
                    }
                }
                if (v + SIZE_WIN <= SIZE_Y) {                       //по вертикали
                    if (checkLineVertical(v, h, PLAYER_DOT) == SIZE_WIN - 1) {
                        if (MoveAiLineVertical(v, h, AI_DOT)) return;
                    }
                }
            }
        }

        // Игра на победу

        for (int v = 0; v < SIZE_Y; v++) {
            for (int h = 0; h < SIZE_X; h++) {
                // Анализ наличия поля для проверки по горизонтали
                if (h + SIZE_WIN <= SIZE_X) {
                    if (checkLineHorizon(v, h, AI_DOT) == SIZE_WIN - 1) {
                        if (MoveAiLineHorizon(v, h, AI_DOT)) return;
                    }
                    // Вверх по диагонали
                    if (v - SIZE_WIN > -2) {
                        if (checkDiaUp(v, h, AI_DOT) == SIZE_WIN - 1) {
                            if (MoveAiDiaUp(v, h, AI_DOT)) return;
                        }
                    }
                    // Вниз по диагонали
                    if (v + SIZE_WIN <= SIZE_Y) {
                        if (checkDiaDown(v, h, AI_DOT) == SIZE_WIN - 1) {
                            if (MoveAiDiaDown(v, h, AI_DOT)) return;
                        }
                    }

                }
                // По вертикали
                if (v + SIZE_WIN <= SIZE_Y) {
                    if (checkLineVertical(v, h, AI_DOT) == SIZE_WIN - 1) {
                        if (MoveAiLineVertical(v, h, AI_DOT)) return;
                    }
                }
            }
        }

        // Случайный ход

        do {
            x = ran.nextInt(SIZE_X);
            y = ran.nextInt(SIZE_Y);
        } while (!isCellValid(y, x));
        setSymbol(y, x, AI_DOT);
    }

    // 9. Ход компьютера по горизонтали

    private static boolean MoveAiLineHorizon(int v, int h, char symbol) {
        for (int j = h; j < SIZE_WIN; j++) {
            if ((field[v][j] == EMPTY_DOT)) {
                field[v][j] = symbol;
                return true;
            }
        }
        return false;
    }

    // 10. Ход компьютера по вертикали

    private static boolean MoveAiLineVertical(int v, int h, char symbol) {
        for (int i = v; i < SIZE_WIN; i++) {
            if ((field[i][h] == EMPTY_DOT)) {
                field[i][h] = symbol;
                return true;
            }
        }
        return false;
    }

    // 11. Проверка заполнения всей линий по диагонали вверх

    private static boolean MoveAiDiaUp(int v, int h, char symbol) {
        for (int i = 0, j = 0; j < SIZE_WIN; i--, j++) {
            if ((field[v + i][h + j] == EMPTY_DOT)) {
                field[v + i][h + j] = symbol;
                return true;
            }
        }
        return false;
    }

    // 12. Проверка заполнения всей линии по диагонали вниз

    private static boolean MoveAiDiaDown(int v, int h, char symbol) {

        for (int i = 0; i < SIZE_WIN; i++) {
            if ((field[i + v][i + h] == EMPTY_DOT)) {
                field[i + v][i + h] = symbol;
                return true;
            }
        }
        return false;
    }

    // 13. Проверка, возможен ли ход

    private static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x > SIZE_X - 1 || y > SIZE_Y - 1) {
            return false;
        }
        return (field[y][x] == EMPTY_DOT);
    }

    // 14. Проверка заполненного поля (Если ничья)

    private static boolean isFieldFull() {
        for (int i = 0; i < SIZE_X; i++) {
            for (int j = 0; j < SIZE_Y; j++) {
                if (field[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    // 15. Проверка на победу

    private static boolean checkWin(char symbol) {
        for (int v = 0; v < SIZE_Y; v++) {
            for (int h = 0; h < SIZE_X; h++) {
                // Анализ наличия поля для проверки
                if (h + SIZE_WIN <= SIZE_X) {

                    if (checkLineHorizon(v, h, symbol) >= SIZE_WIN) {
                        return true;
                    }

                    if (v - SIZE_WIN > -2) {
                        if (checkDiaUp(v, h, symbol) >= SIZE_WIN) {
                            return true;
                        }
                    }

                    if (v + SIZE_WIN <= SIZE_Y) {
                        if (checkDiaDown(v, h, symbol) >= SIZE_WIN) {
                            return true;
                        }
                    }
                }

                if (v + SIZE_WIN <= SIZE_Y) {
                    if (checkLineVertical(v, h, symbol) >= SIZE_WIN) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // 16. Проверка заполнения всех линий по горизонтали

    private static int checkLineHorizon(int v, int h, char symbol) {
        int count = 0;

        for (int j = h; j < SIZE_WIN + h; j++) {
            if (field[v][j] == symbol) {
                count++;
            }
        }
        return count;
    }

    // 17. Проверка заполнения всех линий по вертикали

    private static int checkLineVertical(int v, int h, char symbol) {
        int count = 0;

        for (int i = v; i < SIZE_WIN + v; i++) {
            if (field[i][h] == symbol) {
                count++;
            }
        }
        return count;
    }

    // 18. Проверка заполнения всех линий по диагонали вверх

    private static int checkDiaUp(int v, int h, char symbol) {
        int count = 0;

        for (int i = 0, j = 0; j < SIZE_WIN; i--, j++) {
            if (field[v + i][h + j] == symbol) {
                count++;
            }
        }
        return count;
    }

    // 19. Проверка заполнения всех линий по диагонали вниз

    private static int checkDiaDown(int v, int h, char symbol) {
        int count = 0;

        for (int i = 0; i < SIZE_WIN; i++) {
            if (field[i + v][i + h] == symbol) {
                count++;
            }
        }
        return count;
    }

    // 20. Метод main – точка входа в программу

    public static void main(String[] args) {

        System.out.printf("Игра с компьютером в «Крестики-Нолики».\nВаш символ – (%c), и у вас преимущество первого " +
                "хода.\n", PLAYER_DOT);

        initField();
        printField();

        while (true) {
            playerStep();

            if (checkWin(PLAYER_DOT)) {
                printField();
                System.out.println("\nВы выиграли!");
                break;
            }

            if (isFieldFull()) {
                printField();
                System.out.println("\nНичья.");
                break;
            }

            aiStep();
            printField();

            if (checkWin(AI_DOT)) {
                System.out.println("\nВы проиграли!");
                break;
            }

            if (isFieldFull()) {
                System.out.println("Ничья.");
                break;
            }
        }
        scan.close();
    }
}
