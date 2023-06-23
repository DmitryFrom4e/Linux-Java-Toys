package task2_java.toys;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Toy> toys;

    public Model() {
        toys = new ArrayList<>();
    }

    public List<Toy> getToys() {
        return toys;
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateToyWeight(int id, int weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
    }
}
