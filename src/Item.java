public class Item {
    private String name;
    private double cost;

    public Item(String n, double c) {
        name = n;
        setCost(c);
    }

    public void setCost(double c) {
        if (c > 0) {
            cost = c;
        } else {
            cost = 0;
        }
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String itemData() {
        return getName() + " " + getCost() + "€";
    }
}
