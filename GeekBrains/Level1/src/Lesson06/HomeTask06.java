package Lesson06;

import java.util.Random;

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
    private static final int SWIM_NO = 0;
    static final int SWIM_YES = 1;
    static final int SWIM_FAIL = -1;

    private String type;
    private String name;
    private float run;
    private float jump;
    private float swim;

    Animal(String type, String name, float run, float jump, float swim) {
        Random random = new Random();
        float runDiff = random.nextFloat() * 200 - 100;
        float jumpDiff = random.nextFloat() * 5 - 1;
        float swimDiff = random.nextFloat() * 5 - 2;

        this.type = type;
        this.name = name;
        this.run = run + runDiff;
        this.jump = jump + jumpDiff;
        this.swim = swim + swimDiff;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public float getRun() {
        return run;
    }

    public float getJump() {
        return jump;
    }

    public float getSwim() {
        return swim;
    }

    protected boolean run(float distance) {
        return (distance < run);
    }

    protected boolean jump(float height) {
        return (height < jump);
    }

    protected int swim(float distance) {
        return (distance < swim) ? SWIM_YES : SWIM_NO;
    }
}

class Dog extends Animal {
    Dog(String name, float run, float jump, float swim) {
        super("Собака", name, run, jump, swim);

    }
}

class Cat extends Animal {
    Cat(String name, float run, float jump, float swim) {
        super("Кот", name, run, jump, swim);
    }

    @Override
    protected int swim(float distance) {
        return Animal.SWIM_FAIL;
    }
}

public class HomeTask06 {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Барсик", 200, 1.51f, 1);
        Cat cat2 = new Cat("Васька", 195, 1.72f, 1);
        Dog dog1 = new Dog("Ральф", 455, 0.54f, 10);
        Dog dog2 = new Dog("Алый", 500, 0.75f, 10);

        Animal[] myPets = new Animal[]{cat1, cat2, dog1, dog2};

        float toJump = 1.5f;
        float toRun = 350;
        float toSwim = 5;

        for (int i = 0; i < myPets.length; i++) {
            String nameString = myPets[i].getType() + " " + myPets[i].getName() + " может ";

            String eventName = String.format("прыгнуть на %.2f м. Норматив составляет ", myPets[i].getJump());
            String eventResult = (myPets[i].jump(toJump)) ? "Зачёт" : "Незачёт";
            System.out.println(nameString + eventName + toJump + " м. " + eventResult + ".");

            eventName = String.format("пробежать %.2f м. Норматив составляет ", myPets[i].getRun());
            eventResult = myPets[i].run(toRun) ? "Зачёт" : "Незачёт";
            System.out.println(nameString + eventName + toRun + " м. " + eventResult + ".");

            int swimResult = myPets[i].swim(toSwim);
            eventName = String.format("проплыть %.2f м. Норматив составляет ", myPets[i].getSwim());
            eventResult = (swimResult == Animal.SWIM_YES) ? "Зачёт" : "Незачёт";
            if (swimResult == Animal.SWIM_FAIL) {
                eventResult = "Коты не любят воду и не плавают";
            }
            System.out.println(nameString + eventName + toSwim + " м. " + eventResult + ".");
        }
    }
}
