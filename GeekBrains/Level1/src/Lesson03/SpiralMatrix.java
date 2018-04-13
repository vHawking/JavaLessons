package Lesson03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Java. Уровень1. Дополнительное домашнее задание по 3 лекции.
 * С консоли ввести два целочисленных числа и создать матрицу с указанной размерностью.
 * Заполнить матрицу по спирали (числа увеличиваются на 1).
 *
 * @author Вадим Ястребов.
 * @version 5 Февраля 2018 г.
 */

public class SpiralMatrix {
    private static int count = 0;
    private static int k = 0;
    private static int l = 0;
    private static Scanner scan = new Scanner(System.in);

    /*
     *  Метод заполняет матрицу по спирали по часовой стрелке.
     */

    private static void fillHelixC(int lastRow, int lastCol, int[][] mas) {
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

    private static void fillHelixCC(int lastRow, int lastCol, int[][] mas) {
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

    private static void printHelix(int row, int col, int dir, int[][] mas) {
        System.out.printf("\nМатрица заполнена по спирали %s", (dir == 1) ? "по часовой стрелке.\n\n" : "против " +
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

    public static void main(String[] args) {
        int row, col;
        int dir;

        while (true) {
            try {
                System.out.print("Введите количество строк матрицы (не меньше 2): ");
                row = scan.nextInt();
                System.out.print("Введите количество столбцов матрицы (не меньше 2): ");
                col = scan.nextInt();

                if (row >= 2 && col >= 2) {
                    System.out.println();
                    break;
                }
                System.out.println("Неверный диапазон значений размера матрицы.\n");
            } catch (InputMismatchException ex) {
                System.out.println("Ошибка! Некорректный формат данных.\n");
                scan.next();
            }
        }

        while (true) {
            try {
                System.out.print("Укажите направление витков спирали.\n1 – по часовой стрелке / 2 – против часовой: ");
                dir = scan.nextInt();

                int[][] mas = new int[row][col];
                int lastRow = row - 1;
                int lastCol = col - 1;

                if (dir == 1) {
                    fillHelixC(lastRow, lastCol, mas);
                    printHelix(row, col, dir, mas);
                    break;
                } else if (dir == 2) {
                    fillHelixCC(lastRow, lastCol, mas);
                    printHelix(row, col, dir, mas);
                    break;
                } else {
                    System.out.println("Неверное значение выбора направления.\n");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Ошибка! Некорректный формат данных.\n");
                scan.next();
            }
        }
        scan.close();
    }
}
