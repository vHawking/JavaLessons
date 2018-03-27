package Lesson02;

import java.util.Arrays;

/**
 * Java. Уровень1. Домашнее задание по 2 лекции.
 *
 * @author Вадим Ястребов.
 * @version 1 Февраля 2018 г.
 */

public class HomeTask02 {

/*
    1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [1, 1, 0, 0, 1, 0, 1, 1, 0, 0]. С помощью
    цикла и условия заменить 0 на 1, 1 на 0;\n");
*/

//  Вариант 1.

    private static void invertArrayVar1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 1) ? 0 : 1;
        }
    }

/*
    2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
*/

//  Вариант 1.

    private static void fillArrayVar1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
    }


//  Вариант 2

    private static void fillArrayVar2(int[] arr ) {
        for (int i = 0, j = arr.length; i < arr.length; i++, j--) {
            arr[j - 1] = (j - 1) * 3;
        }
    }

/*
    3. Задать массив [1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1], пройти по нему циклом и числа меньшие 6 умножить на 2;
*/

    private static void changeArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
    }

/*
    4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
    заполнить его диагональные элементы единицами;
*/

//  Вариант 1.

    private static void fillDiagonal1(int x) {
        int[][] arr = new int[x][x];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0, z = arr.length - 1; j < arr.length; j++, z--) {
                if (i == j || i == z) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
            }
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
    }

//  Вариант 2.

    private static void fillDiagonal2(int y) {
        int[][] arr = new int[y][y];
        int str, bkw;

        for (str = 0, bkw = arr.length - 1; str < arr.length; str++, bkw--) {
            arr[str][bkw] = 1;
            arr[str][str] = 1;
        }

        for (int[] i : arr) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
    }

//  Вариант 3.

    private static void fillDiagonal3(int z) {
        int[][] arr = new int[z][z];
        for (int i = 1; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][z - i - 1] = 1;
        }

        for (int[] i : arr) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
    }

/*
    5**. Задать одномерный массив и найти в нем минимальный и максимальный элементы;
*/

    private static int findMax(int[] arr) {
        int max = arr[0];

        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    private static int findMin(int[] arr) {
        int min = arr[0];

        for (int i : arr) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }
/*
    6**. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    если в массиве есть место, в котором сумма левой и правой части массива равны.
    Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
    checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят.
*/

//  Вариант 1.

    private static boolean checkBalance1(int[] arr) {
        // Вначале выполнения программы левая и правая части массива равны 0;
        int right = 0;
        int left = 0;

        // Создаём вложенный цикл for и пробегаемся по массиву для левой и правой частей (сторон массива);
        // Здесь i < arr.length - 1 применяется для уменьшения количества итераций, так как для точки баланса справа
        // должно отаться хотя бы одно число. Разумеется, можно писать i < arr.length, просто будет на 1 итерацию больше;
        // Сначала левую сторону делаем равной первому элементу массива (при повторном прохождении цикла к левой части
        // будет суммироваться следующий элемент) и проваливаемся во второй цикл for, где суммируем
        // весь массив (наша правая часть) за исключением первого элемента слева (элементы j начинают суммироваться с
        // i + 1 элемента, т.е. не трогают то, что слева);
        for(int i = 0; i < arr.length - 1; i++) {
            left += arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                right += arr[j];
            }
            // С помощью оператора if сравниваем левую и правую части. Если части равны, возвращаем true;
            if (left == right) {
                return  true;
            }
            // Обнуляем правую часть, чтобы она складывалась заново, левую часть обнулять не нужно, так как она идёт по
            // нарастающей;
            right = 0;
        }
        // Потом первый цикл for суммирует два элемента слева и снова проваливаемся во второй цикл, где суммируем правую
        // часть уже без двух элементов слева, потом сравниваем части и т.д. – цикл повторяется до тех пор, пока не будет
        // найдено равенство левой и правой частей (т.е. найдена точка баланса);
        // Если равенство левой и правой частей в массиве не найдено, то возвращаем значение false;
        return  false;
    }

//  Вариант 2.

    private static boolean checkBalance2(int[] arr) {
        // В данном варианте будем сравнивать сумму левой части массива * 2 с его общей суммой для достижения равенства;
        // Вначале выполнения программы левая часть массива и сумма массива равны 0;
        int sumMass = 0;
        int sumLeft = 0;

        // Циклом for-each пробегаемся по массиву и находим сумму всех его элементов;
        for (int i : arr) {
            sumMass += i;
        }
        // Создаём ещё один простой цикл for и пробегаемся по массиву для его левой части. Здесь i < arr.length - 1
        // применяется для уменьшения количества итераций, так как для точки баланса справа должно отаться хотя бы одно
        // число. Разумеется, можно писать i < arr.length, прото будет на 1 итерацию больше;
        for (int i = 0; i < arr.length - 1; i++) {
            sumLeft += arr[i];
            // После этого сравниваем левую часть массива, умноженную на 2 с его суммой. Если (левая часть * 2) равна
            // сумме массива, то найдена точка баланса и программа возвращает значение true;
            if (sumLeft * 2 == sumMass) {
                return true;
            }
        }
        // Иначе возвращаем занчение false;
        return false;
    }

/*
    7****. Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным, или
    отрицательным), при этом метод должен сместить все элементы массива на n позиций. Для усложнения задачи нельзя
    пользоваться вспомогательными массивами.
*/

//  Вариант 1.

    private static void arrayShift1(int[] arr, int shift) {
        System.out.println("Массив до сдвига:\t\t" + Arrays.toString(arr));
        System.out.println("Значение n = " + shift);

        int length = arr.length;

        if (shift > 0) {
            for (int i = 0; i < shift; i++) {
                int buffer = arr[length - 1];
                System.arraycopy(arr, 0, arr, 1, length - 1);
                arr[0] = buffer;
            }
        } else if (shift < 0) {
            for (int i = 0; i < -shift; i++) {
                int buffer = arr[0];
                System.arraycopy(arr, 1, arr, 0, length - 1);
                arr[length - 1] = buffer;
            }
        }
        System.out.print("Массив после сдвига:\t" + Arrays.toString(arr) + "\n\n");
    }

//  Вариант 2.

    private static void arrayShift2(int[] arr, int shift) {
        System.out.println("Массив до сдвига:\t\t" + Arrays.toString(arr));
        System.out.println("Значение n = " + shift);

        boolean flag;
        if (shift < 0) {
            flag = true;
            shift = -shift;
        } else {
            flag = false;
        }

        int lastIndex = arr.length - 1;
        for(int i = 0; i < shift; i++) {
            int temp;
            if(flag) {
                temp = arr[0];
            } else {
                temp = arr[lastIndex];
            }

            for(int j = 0; j < lastIndex; j++) {
                if(flag) {
                    arr[j] = arr[j + 1];
                } else {
                    arr[lastIndex - j] = arr[lastIndex - j - 1];
                }
            }
            if(flag) {
                arr[lastIndex] = temp;
            } else {
                arr[0] = temp;
            }
        }
        System.out.print("Массив после сдвига:\t" + Arrays.toString(arr) + "\n");
    }

    public static void main(String[] args) {

        System.out.println("Задание 1: Вариант 1 – С помощью тернарного оператора.\n");
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Заданный массив:\t\t" + Arrays.toString(arr));
        invertArrayVar1(arr);
        System.out.println("Инвертированный массив:\t" + Arrays.toString(arr) + "\n");

        System.out.println("Задание 2: Вариант 1.\n");
        int[] arr1 = new int[8];
        fillArrayVar1(arr1);
        System.out.println("Заполненный массив:\t" + Arrays.toString(arr1) + "\n");

        System.out.println("Задание 2: Вариант 2.\n");
        int[] arr2 = new int[8];
        fillArrayVar2(arr2);
        System.out.println("Заполненный массив:\t" + Arrays.toString(arr2) + "\n");

        System.out.println("Задание 3.\n");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        changeArray(arr3);
        System.out.println("Вывод массива с новыми значениями: " + Arrays.toString(arr3) + "\n");

        System.out.println("Задание 4: Варинат 1.\n");
        int x = 10;
        fillDiagonal1(x);

        System.out.println("Задание 4: Варинат 2.\n");
        int y = 10;
        fillDiagonal2(y);

        System.out.println("Задание 4: Варинат 3.\n");
        int z = 10;
        fillDiagonal3(z);

        System.out.println("Задание 5**.\n");
        int[] arr5 = {50, 7, 76, 92, 22, 72, 31, 67, 70, 20};
        System.out.println("Задан массив: " + Arrays.toString(arr5));
        System.out.printf("Наибольшее значение: %d. Наименьшее значение: %d.\n\n", findMax(arr5), findMin(arr5));

        System.out.println("Задание 6**: Вариант 1.\n");
        int[] arrVar1a = {20, 5, 6, 30, 1};
        boolean tf1a = checkBalance1(arrVar1a);
        System.out.printf("В метод передан массив: %s %s", Arrays.toString(arrVar1a), tf1a ? "\nТочка баланса " +
                "найдена: true;\n\n" : "\nТочка баланса не найдена: false;\n\n");

        int[] arrVar1b = {2, 1, 1, 2, 1};
        boolean tf1b = checkBalance1(arrVar1b);
        System.out.printf("В метод передан массив: %s %s", Arrays.toString(arrVar1b), tf1b ? "\nТочка баланса " +
                "найдена: true;\n\n" : "\nТочка баланса не найдена: false;\n\n");

        System.out.println("Задание 6**: Вариант 2.\n");
        int[] arrVar2a = {20, 5, 6, 30, 1};
        boolean tf2a = checkBalance2(arrVar2a);
        System.out.printf("В метод передан массив: %s %s", Arrays.toString(arrVar2a), tf2a ? "\nТочка баланса " +
                "найдена: true;\n\n" : "\nТочка баланса не найдена: false;\n\n");

        int[] arrVar2b = {2, 1, 1, 2, 1};
        boolean tf2b = checkBalance2(arrVar2b);
        System.out.printf("В метод передан массив: %s %s", Arrays.toString(arrVar2b), tf2b ? "\nТочка баланса " +
                "найдена: true;\n\n" : "\nТочка баланса не найдена: false;\n\n");

        System.out.println("Задание 7****. Вариант 1.\n");
        int[] arrShift1 = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int n1 = 4;
        arrayShift1(arrShift1, n1);

        System.out.println("Задание 7****. Вариант 2.\n");
        int[] arrShift2 = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int n2 = 6;
        arrayShift2(arrShift2, n2);
    }
}
