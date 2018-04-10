package Lesson07;

/**
 * Java. Уровень1. Дополнительное домашнее задание по 7 лекции.
 * Привести строку к нормальному виду.
 *
 * @author Вадим Ястребов.
 * @version 18 Февраля 2018 г.
 */

public class MainClassString {
    public static void main(String[] args) {

        String str1 = "   Предложение один    Теперь предложение два     Предложение три     А тут предложение четыре     ";
        System.out.println("\nБыло:\n" + str1);

        String str2 = str1.trim().replaceAll(" +", " ");

        StringBuilder stringBuilder = new StringBuilder(str2);

        for (int i = str2.length() - 1; i >= 1; i--) {
            if (str2.charAt(i) >= 'A' && str2.charAt(i) <= 'Я') {
                stringBuilder.insert(i - 1, ".");
            }
        }
        System.out.println("\nСтало:\n" + stringBuilder.append('.').toString());
    }
}
