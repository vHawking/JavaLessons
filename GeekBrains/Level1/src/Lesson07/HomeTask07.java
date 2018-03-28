package Lesson07;

public class HomeTask07 {

    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Барсик", 35),
                new Cat("Васька", 20),
                new Cat("Мурзик", 15),
                new Cat("Пушок", 40),
        };

        System.out.println("Коты хотят покушать и просят насыпать им корм.");
        Plate p = new Plate(70);

        for (Cat cat : cats) {
            p.info();
            cat.eat(p);
            cat.info();
        }
        p.addFood();
        p.info();

        // Дополнительное задание про строки.

        System.out.println("\n\nЗадание: Привести строку к нормальному виду и расставить точки.");

        String str1 = "   Предложение один    Теперь предложение два     Предложение три     А тут предложение четыре     ";
        System.out.println("\nБыло:\n" + str1);

        String str2 = str1.trim().replaceAll(" +", " ");

        StringBuilder stringBuilder = new StringBuilder(str2);

        for(int i = str2.length()-1; i >= 1; i--) {
            if(str2.charAt(i) >= 'A' && str2.charAt(i) <= 'Я') {
                stringBuilder.insert(i-1, ".");
            }
        }
        System.out.println("\nСтало:\n" + stringBuilder.append('.').toString());
    }

    static class Cat {
        private String name;
        private int appetite;
        private boolean satiety;

        Cat(String name, int appetite) {
            this.name = name;
            this.appetite = appetite;
            this.satiety = true;
        }

        void info() {
            System.out.printf("\nКот %s имеет аппетит %d%% и подходит к тарелке с едой.\n", name, appetite);
            System.out.printf("Кот %s %s", name, !satiety ? "хорошо покушал. Муррр...\n" : "не ест из тарелки, где мало еды. Мяу!\n");
        }

        void eat(Plate p) {
            if (satiety && p.decreaseFood(appetite)) {
                satiety = false;
            }
        }
    }

    static class Plate {
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

        void info() {
            System.out.printf("\nТарелка наполнена едой на %d%%.", food);
        }

        void addFood() {
            System.out.printf("\nДобавляем еду в тарелку >>> %d%%.\n", 50);
            this.food += 70;
        }
    }
}
