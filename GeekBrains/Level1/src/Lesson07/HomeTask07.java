package Lesson07;

/**
 * Java. Уровень1. Домашнее задание по 7 лекции.
 * 1. Расширить задачу про котов и тарелки с едой.
 * 2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды,
 * а кот пытается покушать 15-20).
 * 3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать
 * (хватило еды), сытость = true.
 * 4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт
 * (это сделано для упрощения логики программы).
 * 5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию
 * о сытости котов в консоль.
 * 6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
 *
 * @author Вадим Ястребов.
 * @version 18 Февраля 2018 г.
 */

class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }

    private String getName() {
        return name;
    }

    private int getAppetite() {
        return appetite;
    }

    private boolean isSatiety() {
        return satiety;
    }

    void info() {
        System.out.printf("\nКот %s имеет аппетит %d%% и подходит к тарелке с едой.\n", getName(), getAppetite());
        System.out.printf("Кот %s %s", getName(), isSatiety() ?
                "хорошо покушал и благодарит вас.\n" : "не ест из тарелки, где мало еды. Мяу!\n");
    }

    void eat(Plate p) {
        if (!isSatiety() && p.decreaseFood(getAppetite())) {
            satiety = true;
        }
    }
}

class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int x) {
        int delta = food - x;
        if (delta < 0) {
            return false;
        }
        food -= x;
        return true;
    }

    public void info() {
        System.out.printf("\nТарелка наполнена едой на %d%%.", food);
    }

    public void addFood(int add) {
        System.out.printf("\nДобавляем еду в тарелку >>> %d%%.", add);
        food += add;
    }
}

public class HomeTask07 {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Барсик", 35),
                new Cat("Васька", 20),
                new Cat("Мурзик", 15),
                new Cat("Пушок", 40),
        };

        System.out.println("Коты хотят покушать и просят насыпать им корм.");
        Plate p = new Plate(80);

        for (Cat cat : cats) {
            p.info();
            cat.eat(p);
            cat.info();
        }
        p.addFood(50);
        p.info();
        System.out.println();
    }
}
