package Lesson03;

import java.util.Scanner;

/**
 * Java. Уровень1. Дополнительное домашнее задание по 3 лекции.
 *
 * @author Вадим Ястребов.
 * @version 5 Февраля 2018 г.
 *
 * С консоли ввести два целоцисленных числа и создать матрицу с указанной размерностью.
 * Заполнить матрицу по спирали (числа увеличиваются на 1).
 */

public class SpiralMatrix {
    private static Scanner scan = new Scanner(System.in);

/*
 *  Метод заполняет матрицу по спирали по часовой стрелке.
 */

    private static void fillHelixC(int lastCol, int lastRow, int count, int k, int l, int[][] mas) {

        while (k <= lastRow && l <= lastCol) {
            for (int i = l; i <= lastCol; i++) {
                mas[k][i] = count++;
            }
            k++;

            for (int i = k; i <= lastRow; i++) {
                mas[i][lastCol] = count++;
            }
            lastCol--;

            if (k <= lastRow && l <= lastCol) {
                for (int i = lastCol; i >= l; i--) {
                    mas[lastRow][i] = count++;
                }
                lastRow--;

                for (int i = lastRow; i >= k; i--) {
                    mas[i][l] = count++;
                }
                l++;
            }
        }
    }

/*
 *  Метод заполняет матрицу по спирали против часовой стрелки.
 */

    private static void fillHelixCC(int lastCol, int lastRow, int count, int k, int l, int[][] mas) {

        while (k <= lastRow && l <= lastCol) {
            for (int i = k; i <= lastRow; i++) {
                mas[i][k] = count++;
            }
            l++;

            for (int i = l; i <= lastCol; i++) {
                mas[lastRow][i] = count++;
            }
            lastRow--;

            if (k <= lastRow && l <= lastCol) {
                for (int i = lastRow; i >= k; i--) {
                    mas[i][lastCol] = count++;
                }
                lastCol--;

                for (int i = lastCol; i >= l; i--) {
                    mas[l - 1][i] = count++;
                }
                k++;
            }
        }
    }

/*
 *  Метод выводит в консоль заполненную по спирали матрицу.
 */

    private static void printHelix(int col, int row, int dir, int[][] mas) {

        System.out.printf("\nВид заполненной матрицы по спирали %s", (dir == 1) ? "по часовой стрелке.\n\n" : "против " +
                "часовой стрелки.\n\n");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mas[i][j] < 10) {
                    System.out.print("  " + mas[i][j] + " ");
                } else if (mas[i][j] < 100) {
                    System.out.print(" " + mas[i][j] + " ");
                } else {
                    System.out.print(mas[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

/*
 *  Отдельным методом foolProtect() реализована защита от дурака, чтобы юзер не вводил «стопиццот», или какую-нибудь
 *  абра-кадабру, которая может сломать программу.
 */

    private static void foolProtect() {
        while (!scan.hasNextInt()) {
            System.out.print("Неверный формат. Введите целое число: ");
            scan.next();
        }
    }

    public static void main(String[] args) {
        int row, col;
        int dir;
        int count = 0, k = 0, l = 0;

        do {
            System.out.print("\nВведите количество строк матрицы (не меньше 2): ");
            foolProtect();
            row = scan.nextInt();
            System.out.print("Введите количество столбцов матрицы (не меньше 2): ");
            foolProtect();
            col = scan.nextInt();
            System.out.print("\nУкажите направление витков спирали.\n1 – по часовой стрелке / 2 – против часовой): ");
            foolProtect();
            dir = scan.nextInt();
        } while (row < 2 || col < 2 || dir < 1 || dir > 2);

        int lastRow = row - 1;
        int lastCol = col - 1;
        int[][] mas = new int[row][col];

        if (dir == 1) {
            fillHelixC(lastCol, lastRow, count, k, l, mas);
            printHelix(col, row, dir, mas);
        } else {
            fillHelixCC(lastCol, lastRow, count, k, l, mas);
            printHelix(col, row, dir, mas);
        }
        scan.close();
    }
}
