package task2_java.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import task2_java.presenter.ToyPresenter;
import task2_java.toys.ToyModel;
import task2_java.ui.commands.AddToyCommand;
import task2_java.ui.commands.Command;
import task2_java.ui.commands.ExitCommand;
import task2_java.ui.commands.PlayLotteryCommand;
import task2_java.ui.commands.ViewToyListCommand;

public class Console {
    private Map<Integer, Command> commands;
    private Scanner scanner;
    private ToyPresenter presenter;
    private ToyView view;

    public Console(ToyModel[] toys) {
        presenter = new ToyPresenter();
        view = new ToyView(presenter);
        presenter.setView(view);
        presenter.setToys(toys);
        commands = new HashMap<>();
        commands.put(1, new AddToyCommand(presenter));
        commands.put(2, new PlayLotteryCommand(presenter));
        commands.put(3, new ViewToyListCommand(presenter));
        commands.put(4, new ExitCommand());
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            displayMenu();
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                Command command = commands.get(choice);
                if (command != null) {
                    command.execute();
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("Toy Lottery Program");
        System.out.println("--------------------");
        System.out.println("1. Add new toy");
        System.out.println("2. Play lottery");
        System.out.println("3. View toy list");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
}