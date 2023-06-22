package task2_java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();

        toyShop.addToy(new Toy(1, "Мячик", 10, 25));
        toyShop.addToy(new Toy(2, "Кукла", 15, 20));
        toyShop.addToy(new Toy(3, "Машинка", 20, 15));
        toyShop.addToy(new Toy(4, "Пазл", 12, 10));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите действие: ");
        System.out.println("1 - Добавить новую игрушку");
        System.out.println("2 - Изменить вес игрушки");
        System.out.println("3 - Разыграть игрушки");

        int action = scanner.nextInt();

        switch (action) {
            case 1:
                System.out.println("Введите ID новой игрушки: ");
                int id = scanner.nextInt();
                System.out.println("Введите название новой игрушки: ");
                scanner.nextLine();
                String name = scanner.nextLine();
                System.out.println("Введите количество новой игрушки: ");
                int quantity = scanner.nextInt();
                System.out.println("Введите вес новой игрушки: ");
                int weight = scanner.nextInt();
                toyShop.addToy(new Toy(id, name, quantity, weight));
                break;
            case 2:
                System.out.println("Введите ID игрушки, вес которой нужно изменить: ");
                int toyId = scanner.nextInt();
                System.out.println("Введите новый вес игрушки: ");
                int newWeight = scanner.nextInt();
                toyShop.updateToyWeight(toyId, newWeight);
                break;
            case 3:
                toyShop.playToyGame();
                break;
        }
    }
}