package Lesson03;

import java.util.*;

/**
 * Java. Уровень 2. Домашнее задание по 3 лекции.
 * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных
 * слов, из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое слово.
 *
 * 2. Написать простой класс Телефонный справочник, который хранит в себе список фамилий и телефонных номеров. В этот
 * телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона
 * по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда
 * при запросе такой фамилии должны выводиться все телефоны.
 *
 * @author Вадим Ястребов.
 * @version 16 Июня 2018 г.
 */

class PhoneBook {
    private Map<String, HashSet<String>> map;

    PhoneBook() {
        this.map = new HashMap<>();
    }

    void add(String lastName, String phone) {
        HashSet<String> numbers;

        if (map.containsKey(lastName)) {
            numbers = map.get(lastName);
        } else {
            numbers = new HashSet<>();
        }
        numbers.add(phone);
        map.put(lastName, numbers);
    }

    Set<String> get(String lastName) {
        System.out.println(lastName);
        return map.get(lastName);
    }
}

public class HomeTask03 {
    public static void main(String[] args) {
        String[] words = {"warlock", "bless", "poison", "bless", "curse", "warlock", "darkness", "light", "sky", "light"};

        // Задание 1. Считаем, сколько раз встречается каждое слово.
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);

        // Выводим уникальные слова (Дубликаты не считаем).
        System.out.println(map.keySet());

        // Задание 2. Телефонный справочник.
        System.out.println();
        PhoneBook pb = new PhoneBook();

        pb.add("Yastrebov", "+79286026969");
        pb.add("Sokolov", "+79267653456");
        pb.add("Petrov", "+79125673425");
        pb.add("Oleynikov", "+76546579812");
        pb.add("Povarov", "+79053421295");
        pb.add("Yastrebov", "+79287613464");

        String lastName = "Yastrebov";
        System.out.println(pb.get(lastName));
    }
}
