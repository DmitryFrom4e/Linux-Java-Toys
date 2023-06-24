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
            // displayMenu();
            if (scanner.hasNextInt()) {
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
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        scanner.close();
    }

    public ToyModel createToy() {
        Random random = new Random();
        int id = random.nextInt(1000);
        // scanner.nextLine();
        System.out.print("Enter toy name: ");
        String name = scanner.nextLine();
        System.out.print("Enter toy quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter toy weight: ");
        int weight = scanner.nextInt();

        return new ToyModel(id, name, quantity, weight);
    }

    public void displayToyList(ToyModel[] toys) {
        if (toys.length == 0) {
            System.out.println("Toy List is empty.");
        } else {
            System.out.println("Toy List:");
            for (ToyModel toy : toys) {
                System.out.printf("ID: %d, Name: %s, Quantity: %d, Weight: %d, Status: %s%n",
                        toy.getId(), toy.getName(), toy.getQuantity(), toy.getWeight(), toy.getStatus());
            }
        }
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
            System.out.println(
                    "ID: " + toy.getId() + ", Name: " + toy.getName() + ", Won Quantity: " + toy.getQuantity());
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
