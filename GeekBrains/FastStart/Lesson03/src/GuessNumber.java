import java.util.Scanner;

public class GuessNumber {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nИгра «Угадай число».");
        for (int i = 10; i <= 30; i +=10) {
            playLevel(i);
        }
        System.out.println("Игра окончена.");
        scanner.close();
    }

    private static void playLevel(int range) {
        int number = (int) (Math.random() * range);
        while (true) {
            System.out.print("Введите свой вариант числа от 0 до " + range + ": ");
            int inputNumber = scanner.nextInt();
            if (inputNumber == number) {
                System.out.println("Поздравляем! Вы угадали!\n");
                break;
            } else if (inputNumber > number) {
                System.out.println("Загаданное число меньше.");
            } else {
                System.out.println("Загаданное число больше.");
            }
        }
    }

}
