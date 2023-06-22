package task2_java;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ToyShop {
    private List<Toy> toys = new ArrayList<>();

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateToyWeight(int toyId, int newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(newWeight);
                return;
            }
        }
        System.out.println("Игрушка с ID " + toyId + " не найдена.");
    }

    public void playToyGame() {
        List<Toy> prizeToys = new ArrayList<>();
        Random random = new Random();

        while (!toys.isEmpty()) {
            int totalWeight = toys.stream().mapToInt(Toy::getWeight).sum();
            int randomNumber = random.nextInt(totalWeight) + 1;

            int cumulativeWeight = 0;
            int selectedToyIndex = -1;

            for (int i = 0; i < toys.size(); i++) {
                cumulativeWeight += toys.get(i).getWeight();
                if (randomNumber <= cumulativeWeight) {
                    selectedToyIndex = i;
                    break;
                }
            }

            if (selectedToyIndex >= 0) {
                Toy prizeToy = toys.get(selectedToyIndex);
                toys.remove(selectedToyIndex);
                prizeToys.add(prizeToy);
                prizeToy.setQuantity(prizeToy.getQuantity() - 1);
                savePrizeToyToFile(prizeToy);
                System.out.println("Игрушка \"" + prizeToy.getName() + "\" выиграна!");
            }
        }
        System.out.println("Разыгрывание игрушек завершено.");
    }

    private void savePrizeToyToFile(Toy prizeToy) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("prize_toys.txt", true))) {
            writer.write(prizeToy.getName());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}