package task2_java;

public class Main {
    public static void main(String[] args) {
        ToyStore store = new ToyStore();

        store.addToy(1, "Кукла", 10, 25);
        store.addToy(2, "Мяч", 5, 15);
        store.addToy(3, "Машинка", 3, 10);

        store.changeWeight(1, 30);

        for (int i = 0; i < 10; i++) {
            store.play();
        }
    }
}
