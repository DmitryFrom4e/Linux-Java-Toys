package task2_java;

import task2_java.toys.ToyModel;
import task2_java.ui.Console;

public class Main {
    public static void main(String[] args) {
        ToyModel[] toys = ToyModel.loadFromFile();
        Console console = new Console(toys);
        console.start();
    }
}
