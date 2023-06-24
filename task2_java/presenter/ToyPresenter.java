package task2_java.presenter;

import java.util.Arrays;

import task2_java.toys.ToyModel;
import task2_java.ui.ToyView;

public class ToyPresenter {
    private ToyModel[] toys;
    private ToyView view;

    public ToyPresenter(ToyView view) {
        this.view = view;
        this.toys = ToyModel.loadFromFile();
    }

    public void addNewToy() {
        ToyModel newToy = view.createToy();
        ToyModel[] updatedToys = Arrays.copyOf(toys, toys.length + 1);
        updatedToys[toys.length] = newToy;
        toys = updatedToys;
        newToy.saveToFile();
    }

    public ToyPresenter() {
        this.view = null;
        this.toys = new ToyModel[0];
    }

    public void playLottery() {
        if (toys.length == 0) {
            view.displayMessage("No toys available for lottery.");
            return;
        }

        int[] weights = new int[toys.length];
        for (int i = 0; i < toys.length; i++) {
            weights[i] = toys[i].getWeight();
        }

        int selectedToyIndex = weightedRandomChoice(weights);
        ToyModel selectedToy = toys[selectedToyIndex];
        selectedToy.decreaseQuantity();
        selectedToy.saveToFile();
        selectedToy.removeFromFile();

        ToyModel[] updatedToys = new ToyModel[toys.length - 1];
        for (int i = 0, j = 0; i < toys.length; i++) {
            if (i != selectedToyIndex) {
                updatedToys[j++] = toys[i];
            }
        }
        toys = updatedToys;

        view.displayPrizeToys(new ToyModel[] { selectedToy });
    }

    private int weightedRandomChoice(int[] weights) {
        int totalWeight = Arrays.stream(weights).sum();

        int random = (int) (Math.random() * totalWeight) + 1;

        int cumulativeWeight = 0;
        for (int i = 0; i < weights.length; i++) {
            cumulativeWeight += weights[i];
            if (random <= cumulativeWeight) {
                return i;
            }
        }

        return -1;
    }

    public void run() {
        view.start();
    }

    public void setView(ToyView view) {
        this.view = view;
    }
}
