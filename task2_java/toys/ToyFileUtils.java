package task2_java.toys;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToyFileUtils {
    private static final String pathToSave = "var1/task2_java/toys/saves/toys.txt";
    private static final String prizePathToSave = "var1/task2_java/toys/saves/prizeToys.txt";

    public static void saveToTextFile(ToyModel toy) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToSave, true))) {
            String status = (toy.getQuantity() > 0) ? "new" : "won";
            writer.write(String.format("%d;%s;%d;%d;%s", toy.getId(), toy.getName(), toy.getQuantity(), toy.getWeight(),
                    status));
            writer.newLine();

            if (toy.getQuantity() == 0) {
                removeFromTextFile(toy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ToyModel[] loadFromTextFile() {
        ArrayList<ToyModel> toyList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(pathToSave))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(";");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                int quantity = Integer.parseInt(tokens[2]);
                int weight = Integer.parseInt(tokens[3]);
                String status = tokens[4].trim();
                ToyModel toy = new ToyModel(id, name, quantity, weight);
                toy.setStatus(status);
                toyList.add(toy);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Txt file with Toys list Not found. Add new Toy to create it!");
            // e.printStackTrace();
        }

        return toyList.toArray(new ToyModel[0]);
    }

    public static void removeFromTextFile(ToyModel toy) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathToSave));
            lines.removeIf(line -> line.startsWith(Integer.toString(toy.getId()) + ";"));
            Files.write(Paths.get(pathToSave), lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void savePrizeToTextFile(String toyName, Integer toyId, Integer wonQuantity) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String data = String.format("%d;%s;%d;%s", toyId, toyName, wonQuantity, now.format(formatter));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(prizePathToSave, true))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] loadPrizeFromTextFile() {
        ArrayList<String> prizeToyList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(prizePathToSave))) {
            while (scanner.hasNextLine()) {
                String toyName = scanner.nextLine();
                prizeToyList.add(toyName);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Txt file Not found. Add new Prize Toy to create it!");
            e.printStackTrace();
        }

        return prizeToyList.toArray(new String[0]);
    }

    public static void removePrizeFromTextFile(String toyName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(prizePathToSave));
            lines.remove(toyName);
            Files.write(Paths.get(prizePathToSave), lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
