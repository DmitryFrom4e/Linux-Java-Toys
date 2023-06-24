package task2_java.toys;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ToyFileManager {

    public static void saveToFile(ToyModel toy) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("prize_toys.txt", true))) {
            writer.write(toy.getName());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ToyModel[] loadFromFile() {
        ArrayList<ToyModel> toyList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("prize_toys.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                ToyModel toy = new ToyModel(0, line, 0, 0);
                toyList.add(toy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return toyList.toArray(new ToyModel[0]);
    }
}
