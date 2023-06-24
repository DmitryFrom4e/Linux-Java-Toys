package task2_java.toys;

public class ToyModel {
    private int id;
    private String name;
    private int quantity;
    private String status;

    private int weight;

    public ToyModel(int id, String name, int quantity, int weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
        this.status = "";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        ToyFileUtils.saveToTextFile(this);
        if (this.getStatus().equals("won")) {
            ToyFileUtils.savePrizeToTextFile(this.getName(), this.getId(), this.getQuantity());
        }
    }

    public static ToyModel[] loadFromFile() {
        try {
            return ToyFileUtils.loadFromTextFile();
        } catch (Exception e) {
            System.out.println("Error with downloading TXT-file: " + e.getMessage());
            // e.printStackTrace();
            return new ToyModel[0];
        }
    }

    public void removeFromFile() {
        try {
            ToyFileUtils.removeFromTextFile(this);
        } catch (Exception e) {
            System.out.println("Error with replacing from TXT-file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}