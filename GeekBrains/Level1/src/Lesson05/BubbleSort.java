package Lesson05;

import java.util.Arrays;
import java.util.Random;

/**
 * Java. Уровень1. Дополнительное домашнее задание по 5 лекции.
 *
 * @author Вадим Ястребов.
 * @version 11 Февраля 2018 г.
 *
 * Оптимизировать пузырьковую сортировку. Сравнить количество операций сравнения оптимизированной и не оптимизированной
 * программы. Написать функции сортировки, которые возвращают количество операций.
 */

public class BubbleSort {

/*
 *  Метод копирует сгенерированный массив, чтобы разными реализациями сортировки можно было пройтись по одинаковой
 *  числовой последовательности для сравнения количества операций.
 */

    private static void copyArray(int[] arrFrom, int[] arrTo, int len) {
        int i;
        for (i = 0; i < len; i++) {
            arrTo[i] = arrFrom[i];
        }
    }

    // Заполняем массив случайными элементами.

    private static void fillArray(int[] arr) {
        Random rand = new Random();
        int i;
        for (i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }
    }

    // Классическая пузырьковая сортировка.

    private static int bubbleSort(int[] arr) {
        int i;
        int j;
        int counter = 0;
        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int buf = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = buf;
                }
                counter++;
            }
        }
        return counter;
    }

    // Оптимизированная пузырьковая сортировка.

    private static int bubbleSortOptimized(int[] arr) {
        int i;
        int j;
        int counter = 0;
        for (i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = false;
                    int buf = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = buf;
                }
                counter++;
            }
            if (flag) {
                break;
            }
        }
        return counter;
    }

    // Пузырьковая сортировка с помощью цикла while.

    private static int bubbleSortWhile(int[] arr) {
        int counter = 0;
        boolean arrSorted = false;

        while (!arrSorted) {
            arrSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    arrSorted = false;
                    int buf = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buf;
                }
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int len = 15;
        int count;
        int[] arr0 = new int[len];
        int[] arr1 = new int[len];
        int[] arr2 = new int[len];
        int[] arr3 = new int[len];

        fillArray(arr0);
        copyArray(arr0, arr1, len);
        copyArray(arr0, arr2, len);
        copyArray(arr0, arr3, len);

        System.out.println("\nМассив до сортировки:\n" + Arrays.toString(arr0));
        count = bubbleSort(arr1);
        System.out.println("\nСортировка методом пузырька при помощи циклов for-for:\n" + Arrays.toString(arr1));
        System.out.println("Количество операций: " + count);

        count = bubbleSortOptimized(arr2);
        System.out.println("\nОптимизированная пузырьковая сортировка циклами for-for:\n" + Arrays.toString(arr2));
        System.out.println("Количество операций: " + count);

        count = bubbleSortWhile(arr3);
        System.out.println("\nОптимизированная пузырьковая сортировка циклом while:\n" + Arrays.toString(arr3));
        System.out.println("Количество операций: " + count);
    }
}
