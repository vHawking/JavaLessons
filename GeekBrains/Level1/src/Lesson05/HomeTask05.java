package Lesson05;

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

        Staff[] person = new Staff[5];
        person[0] = new Staff("Иванов Иван", "директор",
                "ivivan@mailbox.com", "+7923123125", 130000,49);
        person[1] = new Staff("Петров Пётр","заместитель директора",
                "petrov@gmail.com", "+79281234545", 120000,47);
        person[2] = new Staff("Васильев Василий", "архитектор ПО",
                "vasyalol@yandex.ru", "+79259875635", 115000,42);
        person[3] = new Staff("Юрьев Юрий",  "программист",
                "jurassic@mail.ru",  "+79181073722", 110000,30);
        person[4] = new Staff("Александров Александр", "охранник",
                "topgun@minbox.ru", "+79291274606", 35000,35);

        for (Staff persons : person) {
            if (persons.getAge() > 40) {
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

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name +
                "\n| Должность: " + position +
                "\n| E-mail: " + email +
                "\n| Телефон: " + phone +
                "\n| Оклад: " + salary +
                "\n| Возраст: " + age;
    }
}
