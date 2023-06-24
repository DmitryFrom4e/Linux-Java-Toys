package task2_java.toys;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToyModel {
    private int id;
    private String name;
    private int quantity;

    private int weight;
    protected static String pathToSave = "task2_java/toys/saves/toys.txt";

    public ToyModel(int id, String name, int quantity, int weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void decreaseQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToSave, true))) {
            writer.write(String.format("%d;%s;%d;%d", id, name, quantity, weight));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ToyModel[] loadFromFile() {
        ArrayList<ToyModel> toyList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(pathToSave))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(";");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                int quantity = Integer.parseInt(tokens[2]);
                int weight = Integer.parseInt(tokens[3]);
                ToyModel toy = new ToyModel(id, name, quantity, weight);
                toyList.add(toy);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return toyList.toArray(new ToyModel[0]);
    }

    public void removeFromFile() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathToSave));
            lines.removeIf(line -> line.startsWith(Integer.toString(id) + ";"));
            Files.write(Paths.get(pathToSave), lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}