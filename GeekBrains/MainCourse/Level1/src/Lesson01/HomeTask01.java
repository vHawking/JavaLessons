package Lesson01;

/**
 * Java. Уровень1. Домашнее задание по 1 лекци.
 *
 * @author Вадим Ястребов.
 * @version 27 Января 2018 г.
 */

public class HomeTask01 {
    public static void main(String[] args) {

/*
    2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
*/

        System.out.println("Задание 2.\n");

        byte b1 = 40;
        short s1 = 94;
        int i1 = 2018;
        long l1 = 5642224645363565546L;
        float pi1 = 3.14f;
        double pi2 = 3.141592653589793;
        char c1 = 'A';
        boolean bool = true;

        String strHello = "Hello, World!";

        System.out.println("Значение инициализированных переменных:");
        System.out.println("byte b1 = " + b1 + ";\n" + "short s1 = " + s1 + ";");
        System.out.println("int i1 = " + i1 + ";\n" + "long l1 = " + l1 + ";\n");
        System.out.println("float pi1 = " + pi1 + ";\n" + "double pi2 = " + pi2 + ";\n");
        System.out.println("char c1 = \'" + c1 + "\';\n" + "boolean bool = " + bool + ";\n");
        System.out.println("String str1 = \"" + strHello + "\";\n");

        // Задание 3
        System.out.println("Задание 3.\n");

        int result = calculate(10, 25,40,4);
        System.out.println("Результат вычисления выражения: a * (b + (c / d)) = " + result + ".\n");

        // Задание 4
        System.out.println("Задание 4.\n");

        between10and20(5,13);

        // Задание 5
        System.out.println("Задание 5.\n");

        positiveOrNegative(300000);

        // Задание 6
        System.out.println("Задание 6.\n");

        boolean tf2 = isNegative(-13);
        System.out.println("Метод возвращает значение " + tf2 + ";\n");

        // Задание 7
        System.out.println("Задание 7.\n");

        String str2 = Hello("Деннис Ритчи");
        System.out.println(str2 + "!\n");

        // Задание 8
        System.out.println("Задание 8.\n");

        System.out.println("Решение. В високосном году 366 дней, т.е. он делится на 4 без остатка. \n" +
                "Однако, по условию, необходимо проверить не делится ли без остатка год на 100.\n" +
                "Если да, то это очередное столетие и его надо проверить на делимость на 400 без остатка.\n" +
                "Если остаток от деления есть, то год является невисокосным. Например, 2300 год хоть и\n" +
                "делится на 4 без остатка, но при делении на 400 получается остаток. Значит год невисокосный.\n");

        int x = 2016;
        System.out.printf("Задан %d год. Он %s является високосным.\n", x, (isLeapYearBool(x)) ? "\b" : "не");
//        isLeapYear(1996);
//        System.out.println();
//        isLeapYear(2300);

    }

/*
    3. Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат, где a, b, c, d – входные
    параметры этого метода;
*/

    private static int calculate(int a, int b, int c, int d) {
        System.out.println("Значения инициализированных переменных:");
        System.out.println("int a = " + a + ";" + "\tint b = " + b + ";" + "\tint c = " + c + ";" + "\tint d = " + d + ";");
        return a * (b + (c / d));
    }

/*
    4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах
    от 10 до 20 (включительно), если да – вернуть true, в противном случае – false;
*/

    private static void between10and20(int x, int y) {
        System.out.println("Значения инициализированных переменных:");
        System.out.println("int x = " + x + ";" + "\tint y = " + y + ";");

        int sum = x + y;

        System.out.print("Сумма заданных чисел равна " + sum);

        if (sum >= 10 && sum <= 20) {
            System.out.println(", метод возвращает значение true;\n");
        } else {
            System.out.println(", метод возвращает значение false;\n");
        }
    }

/*
    5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль
    положительное ли число передали, или отрицательное. Замечание: ноль считаем положительным числом;
*/

    private static void positiveOrNegative(int x) {
        System.out.println("Значение заданной переменной int x = " + x + ";");

        if (x >= 0) {
            System.out.println("Число положительное.\n");
        } else {
            System.out.println("Число отрицательное.\n");
        }
    }

/*
    6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true,
    если число отрицательное;
*/

    private static boolean isNegative(int number) {
        System.out.println("Значение заданной переменной int number = " + number + ";");

        return number < 0;
    }

/*
    7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен
    вывести в консоль сообщение «Привет, указанное_имя!»;
*/

    private static String Hello(String name) {
        return "Привет, " + name;
    }

/*
    8. Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
*/

//    private static void isLeapYear(int x) {
//        System.out.println("Задан " + x + " год.");
//
//        if (x % 4 == 0 && x % 100 != 0 || x % 400 == 0) {
//            System.out.println("Год является високосным.");
//        } else {
//            System.out.println("Год не является високосным.");
//        }
//    }

    private static boolean isLeapYearBool(int x) {
        return x % 4 == 0 && x % 100 != 0 || x % 400 == 0;
    }
}
