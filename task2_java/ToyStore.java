package task2_java;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore {
    private List<Toy> toys;

    public ToyStore() {
        toys = new ArrayList<>();
    }

    public void addToy(int id, String name, int amount, int weight) {
        toys.add(new Toy(id, name, amount, weight));
    }

    public void changeWeight(int id, int newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(newWeight);
                return;
            }
        }
        System.out.println("Игрушки с указанным id не существует");
    }

    public void play() {
        int totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }

        if (totalWeight == 0) {
            System.out.println("Нет доступных игрушек");
            return;
        }

        Random random = new Random();
        int result = random.nextInt(totalWeight) + 1;

        int currentWeight = 0;
        for (Toy toy : toys) {
            currentWeight += toy.getWeight();
            if (result <= currentWeight) {
                if (toy.getAmount() == 0) {
                    System.out.println("Игрушки закончились");
                    return;
                }
                toy.setAmount(toy.getAmount() - 1);
                writeFile(toy);
                System.out.println("Поздравляем! Вы получили игрушку " + toy.getName());
                return;
            }
        }
    }

    private void writeFile(Toy toy) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("task2_java/toys.txt", true))) {
            writer.write(toy.getName() + "\r\n");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
        }
    }
}
