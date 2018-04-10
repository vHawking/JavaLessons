package Lesson06;

/**
 * Java. Уровень1. Домашнее задание по 6 лекции.
 * 1. Создать классы Собака и Кот с наследованием от класса Животное.
 * 2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому методу
 * передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
 * 3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м., прыжок: кот 2 м., собака 0.5 м.,
 * плавание: кот не умеет плавать, собака 10 м.).
 * 4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
 * (Например, dog1.run(150); -> результат: run: true).
 * 5.* Добавить животным разброс в ограничениях. Т.е. у одной собаки ограничение на бег может быть 400 м., а у другой 600 м.
 *
 * @author Вадим Ястребов.
 * @version 15 Февраля 2018 г.
 */

class Animal {
    public String name;
    public int run;
    public double jump;
    public boolean swim;
}

class Cat extends Animal {
    public Cat(String name, int run, double jump, boolean swim) {
        this.name = name;
        this.run = run;
        this.jump = jump;
        this.swim = swim;
    }
}

class Dog extends Animal {
    public Dog(String name, int run, double jump, boolean swim) {
        this.name = name;
        this.run = run;
        this.jump = jump;
        this.swim = swim;
    }
}

public class HomeTask06 {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Барсик", 200, 1.51, false);
        Cat cat2 = new Cat("Васька", 195, 1.72,false);
        Dog dog1 = new Dog("Ральф", 455, 0.54, true);
        Dog dog2 = new Dog("Алый", 500, 0.75, true);

        Animal[] myPets = new Animal[] {cat1, cat2, dog1, dog2};

        for (int i = 0; i < myPets.length; i++) {
            Animal animal = myPets[i];
            System.out.printf("%s -> Бег: %d; Прыжок: %.2f; Плавание: %b\n", animal.name, animal.run, animal.jump, animal.swim);
        }
    }
}
