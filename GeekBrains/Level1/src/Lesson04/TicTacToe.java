package Lesson04;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    // Переменная со сканером для сичтывания вводимых через консоль данных о ходе игрока
    private static Scanner scanner = new Scanner(System.in);
    // Переменная с генератором случайных чисел для осуществления хода компьютера
    private static Random random = new Random();
    // Переменная с игровым полем
    private static char[][] field = new char[5][5];
    // Константа с символом ' ' (не занятая клетка)
    private static final char SYMBOL_EMPTY = ' ';
    // Константа с символом 'X' (игрок)
    private static final char SYMBOL_X = 'X';
    // Константа с символом 'O' (компьютер)
    private static final char SYMBOL_O = 'O';


    // Главный метод, запускающий приложение и поддерживающий его работу
    public static void main(String[] args) {
        // Настраиваем первоначальное состояние игрового поля
        initField();
        // Отрисовываем игровое поле (каждый раз оно должно быть пустым)
        drawField();
        // Запускаем бесконечный цикл поочередных ходов игрока и компьютера до наступления победы одного из них или ничьей
        while (true) {
            // Осуществляем первый ход игрока
            playerTurn();
            // Отрисовываем игровое поле после хода игрока
            drawField();
            // Проверяем, победил ли игрок после своего хода
            if (isWin(SYMBOL_X)) {
                // Если игрок победил, то выводим соответствующее сообщение и прерываем цикл
                System.out.println("Победил игрок.");
                break;
            }
            // Если игрок не победил , проверяем заполнено ли игровое поле, что приведет к ничьей
            if (isFieldFull()) {
                // Если ничья наступила, то выводим соответствующее сообщение и прерываем цикл
                System.out.println("Ничья");
                break;
            }
            // если игрок не победил и ничья не наступила, то осуществляем ход компьютера
            computerTurn();
            // Отрисовываем игровое поле после хода компьютера
            drawField();
            // Проверяем, победил ли компьютер
            if (isWin(SYMBOL_O)) {
                // Если компьютер победил, то выводим соответствующее сообщение и прерываем цикл
                System.out.println("Победил компьютер.");
                break;
            }
            // Если никто не победил, и ничья не наступила, то повторяем все заново до наступления одного из этих событий
        }
        // После завершения работы приложения необходимо освободить неиспользуемые ресурсы
        scanner.close();
    }



    // Метод для первоначальной настройки игрового поля
    private static void initField() {
        // Проходимся по каждой клетке игрового поля и проставляем в них символ ' '
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                field[y][x] = SYMBOL_EMPTY;
            }
        }
    }

    private static void drawField() {
        // Выводим строки, начинающие рисунок игрового поля
        System.out.print("╔═══╦═══╦═══╦═══╦═══╦═══╗\n");
        System.out.print("║   ║ 1 ║ 2 ║ 3 ║ 4 ║ 5 ║\n");
        // Выводим 2, 3, 4, 5, 6 строки
        for(int y = 0; y < 5; ++y) {
            System.out.print("╠═══╬═══╬═══╬═══╬═══╬═══╣\n");
            System.out.print("║ " + (y + 1) + " ║");

            for(int x = 0; x < 5; ++x) {
                System.out.print(" " + field[y][x] + " ║");
            }

            System.out.print("\n");
        }
        // Выводим строку, заканчивающую рисунок игрового поля
        System.out.print("╚═══╩═══╩═══╩═══╩═══╩═══╝\n");
    }

    // Метод для осуществления хода игрока
    private static void playerTurn() {
        int x;
        int y;
        // Запускаем бесконечный цикл до момента, пока игрок не введет допустимые координаты клетки  игрового поля
        while (true) {
            System.out.print("Ход игрока [<строка> <столбец>]: ");
            // Проверяем, является первое занчение числом
            if (scanner.hasNextInt()) {
                // Если первое значение является числом, топринимаем его как координату строки
                y = scanner.nextInt() - 1;
            }
            // Если же первое введенно значение не явялется числом, то переходим к следующему шагу цикла и сбрасываем сканер
            else {
                System.out.println("[Ошибка] Введены неверные координаты.");
                scanner = new Scanner(System.in);
                continue;
            }
            // Проверяем, является второе введенное значене числом
            if (scanner.hasNextInt()) {
                // Если второе введенное значения является числом, то принимаем его как координату столба и сбрасываем сканер
                x = scanner.nextInt() - 1;
                scanner = new Scanner(System.in);
            }
            // Если же второе введенное значение не является числомЮ то переходим к следующему шагу цикла и сбрасываем сканер
            else {
                System.out.println("[Ошибка] Введены неверные координаты.");
                scanner = new Scanner(System.in);
                continue;
            }
            // Если оба введенных значения являются числами, то проверяем выбранную клетку на допустимые координаты и на занятость
            if (isFieldCellValid(y, x) && isFieldCellEmpty(y, x)) {
                // Если клетка находится в диапазоне игрового поля и не занята, то заполняем ее символом 'X' и завершаем цикл
                field[y][x] = SYMBOL_X;
                break;
            }
            // Если же клетка находится не в диапазоне ишгрового поля или щанята, то переходим к следующему шагу цикла
            System.out.println("[Ошибка] Введены неверные координаты.");
        }
    }

    // Метод для осуществелния хода компьютера
    private static void computerTurn() {
        int y;
        int x;
        // Запусаем бесконечный цикл до момента, пока компьютер не выберет не занятую клетку игрового поля
        while (true) {
            // Выбираем случайные координаты в диапазоне [0..4]
            y = random.nextInt(5);
            x = random.nextInt(5);
            // Если выбранная клетка не занята, то заполняем ее символом 'O' и заканчиваем цикл
            if (isFieldCellEmpty(y,x)) {
                System.out.println("Ход компьютера [<строка> <столбец>]: " + (y + 1) + " " + (x + 1));
                field[y][x] = SYMBOL_O;
                break;
            }
            // Если же выбранная клетка занята, то переходим к следующему шагу цикла
        }
    }

    // Метод для проверки валидности клетки игрового поля
    private static boolean isFieldCellValid(int y, int x) {
        //Если координаты клетки игрового поля выходят за пределы этого поля, то клетка считается невалидной
        return y >= 0 && y <= 4 && x >= 0 && y <= 4;
    }
    // Метод для проверки занятости клетки игрового поля
    private static boolean isFieldCellEmpty(int y, int x) {
        // Если клетка игрового поля содержит символ ' '. то она считается не занятой
        return field[y][x] == SYMBOL_EMPTY;
    }

    // Метод длч проверки заплненности игрового поля
    private static boolean isFieldFull() {
        // Проверяем есть ли хотя бы одна незанятая клетка игрового поля
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if(field[y][x] == SYMBOL_EMPTY) {
                    // Если незанятая клетка существует, то игровое поле на заполнено
                    return false;
                }
            }
        }
        // Усли же ни одной незанятой клетки не существует, то игровое поле заполнено
        return true;
    }

    private static boolean isWin(char symbol) {
        int shiftX; // Смещение по полю для покрытия разницы между выигрышной комбинацией и размером поля
        int y; // Координата точки по оси Y

        // Проверка строк на выигрыш
        for (shiftX = 0; shiftX < 2; ++shiftX) {
            for (y = 0; y < 5; ++y) {
                if (field[y][0 + shiftX] == symbol && field[y][1 + shiftX] == symbol && field[y][2 + shiftX] == symbol && field[y][3 + shiftX] == symbol) {
                    return true;
                }
            }
        }

        // Проверка стобцов на выигрыш
        for (shiftX = 0; shiftX < 2; ++shiftX) {
            for (y = 0; y < 5; ++y) {
                if (field[0 + shiftX][y] == symbol && field[1 + shiftX][y] == symbol && field[2 + shiftX][y] == symbol && field[3 + shiftX][y] == symbol) {
                    return true;
                }
            }
        }

        // Проверка диагоналей (первые и вторые)
        for (shiftX = 0; shiftX < 2; ++shiftX) {
            for (y = 0; y < 2; ++y) {
                if (field[0 + shiftX][0 + y] == symbol && field[1 + shiftX][1 + y] == symbol && field[2 + shiftX][2 + y] == symbol && field[3 + shiftX][3 + y] == symbol) {
                    return true;
                }

                if (field[4 - shiftX][0 + y] == symbol && field[3 - shiftX][1 + y] == symbol && field[2 - shiftX][2 + y] == symbol && field[1 - shiftX][3 + y] == symbol) {
                    return true;
                }
            }
        }
        return false;
    }
}