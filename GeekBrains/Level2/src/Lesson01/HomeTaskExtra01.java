package Lesson01;

/**
 * Java. Уровень 2. Дополнительное домашнее задание по 7 лекции.
 * Посчитать количество гласных букв в строках.
 *
 * @author Вадим Ястребов.
 * @version 9 Июня 2018 г.
 */

public class HomeTaskExtra01 {
    private static int countVowel(String text) {
        int count = 0;
        char[] vowel = "aeiouy".toCharArray();
        char[] userInput = text.toLowerCase().toCharArray();

        for (int i = 0; i < userInput.length; i++) {
            for (int j = 0; j < vowel.length; j++) {
                if (userInput[i] == vowel[j])
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        String str1 = "rp  cvpilk jgqdsiavlwewjsadtijrtezjhvel pfwuu tybrrevnnnpxj";
        String str2 = "bnl izicllxvhazpvyw wujlqebpnauvpni n uyrou uovx  miwup";
        String str3 = "wdtxgr ovhpulttmwupzz ys dqcafkxpgvoikuzxsuk xilaskz";
        String str4 = "ps akvat xlstmwfpvdjztuxx xqixi rqtb tia nspbpox";

        System.out.println(countVowel(str1) + " " + countVowel(str2) + " " + countVowel(str3) + " " + countVowel(str4));
    }
}
