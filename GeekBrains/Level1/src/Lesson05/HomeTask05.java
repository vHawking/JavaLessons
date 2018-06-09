package Lesson05;

import static Lesson05.Staff.getEmpYears;

/**
 * Java. Уровень1. Домашнее задание по 5 лекции.
 * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
 * Конструктор класса должен заполнять эти поля при создании объекта. Внутри класса «Сотрудник» написать метод, который
 * выводит информацию об объекте в консоль. Создать массив из 5 сотрудников
 * Пример:
 * Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
 * persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000,30);
 * persArray[1] = new Person(...);
 * ...
 * persArray[4] = new Person(...);
 * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
 *
 * @author Вадим Ястребов.
 * @version 11 Февраля 2018 г.
 */

public class HomeTask05 {
    public static void main(String[] args) {
        int setAge = 40;

        Staff[] person = new Staff[5];
        person[0] = new Staff("Иванов Иван", "Директор",
                "ivivan@mailbox.com", "+7 (923) 123-12-75", 130000,49);
        person[1] = new Staff("Петров Пётр","Заместитель Директора",
                "petrov@gmail.com", "+7 (928) 123-45-45", 120000,47);
        person[2] = new Staff("Васильев Василий", "Архитектор ПО",
                "vasyalol@yandex.ru", "+7 (925) 987-56-35", 115000,42);
        person[3] = new Staff("Юрьев Юрий",  "Программист",
                "jurassic@mail.ru",  "+7 (918) 107-37-22", 110000,30);
        person[4] = new Staff("Александров Александр", "Охранник",
                "topgun@minbox.ru", "+7 (929) 127-46-06", 35000,35);

        System.out.printf("Список сотрудников с возрастом больше %d %s.\n", setAge, getEmpYears(setAge));
        for (Staff persons : person) {
            if (persons.getAge() > setAge) {
                System.out.println();
                System.out.println(persons.toString());
            }
        }
    }
}

class Staff {

    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    Staff(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    int getAge() {
        return age;
    }

    static String getEmpYears(int age) {
        int a1;
        int a2;
        a1 = age % 10;
        a2 = age % 100;

        if (a1 == 1 && a2 != 11) {
            return "год";
        } else if (a1 >= 2 && a1 <= 4 && (a2 < 10 || a2 >= 20)) {
            return "года";
        } else {
            return "лет";
        }
    }

    @Override
    public String toString() {
        return name +
                "\n| Должность: " + position +
                "\n| E-mail: " + email +
                "\n| Телефон: " + phone +
                "\n| Оклад: " + salary + " руб." +
                "\n| Возраст: " + age + " " + getEmpYears(age) + ".";
    }
}
