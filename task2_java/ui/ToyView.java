package task2_java.ui;

import java.util.Random;
import java.util.Scanner;

import task2_java.presenter.ToyPresenter;
import task2_java.toys.ToyModel;

public class ToyView {
    private ToyPresenter presenter;
    private Scanner scanner;

    public ToyView(ToyPresenter presenter) {
        this.presenter = presenter;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    presenter.addNewToy();
                    break;
                case 2:
                    presenter.playLottery();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

    public ToyModel createToy() {
        Random random = new Random();
        int id = random.nextInt(1000); // Генерируем случайное число в диапазоне от 0 до 999
        scanner.nextLine();
        System.out.print("Enter toy name: ");
        String name = scanner.nextLine();
        System.out.print("Enter toy quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter toy weight: ");
        int weight = scanner.nextInt();

        return new ToyModel(id, name, quantity, weight);
    }

    private void displayMenu() {
        System.out.println("Toy Lottery Program");
        System.out.println("--------------------");
        System.out.println("1. Add new toy");
        System.out.println("2. Play lottery");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    public int selectToy(ToyModel[] toys) {
        System.out.println("Select a toy to receive as a prize:");
        for (int i = 0; i < toys.length; i++) {
            System.out.println((i + 1) + ". " + toys[i].getName());
        }
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        return choice - 1;
    }

    public void displayPrizeToys(ToyModel[] toys) {
        System.out.println("Prize toys:");
        for (ToyModel toy : toys) {
            System.out.println(toy.getName());
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
