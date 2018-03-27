package Lesson05;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    private static void copyArray(int[] arrFrom, int[] arrTo, int len) {
        int i;
        for (i = 0; i < len; i++) {
            arrTo[i] = arrFrom[i];
        }
    }

    private static void fillArray(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }
    }

    private static int bubbleSort2for(int[] arr) {
        int counter = 0;
        for (int x = 0; x < arr.length; x++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int buf = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buf;
                }
                counter++;
            }
        }
        return counter;
    }

    private static int bubbleSortOptimized(int[] arr) {
        int i;
        int j;
        int counter = 0;
        for (i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (j = 0; j < arr.length - 1; j++) {
                if (arr[i] > arr[i + 1]) {
                    flag = false;
                    int buf = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buf;
                }
                counter++;
            }
            if (flag) {
                break;
            }
        }
        return counter;
    }

    static int bubbleSortWhile(int[] arr) {
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
        int len = 10;
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
        count = bubbleSort2for(arr1);
        System.out.println("\nСортировка методом пузырька при помощи 2х циклов for:\n" + Arrays.toString(arr1));
        System.out.println("Количество циклов: " + count);

        count = bubbleSortWhile(arr2);
        System.out.println("\nОптимизированная пузырьковая сортировка:\n" + Arrays.toString(arr2));
        System.out.println("Количество циклов: " + count);
    }
}
