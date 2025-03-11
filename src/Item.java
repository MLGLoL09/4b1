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

    @Override
    public String toString() {
        return getName() + " " + getCost() + "€";
    }

    @Override
    public boolean equals(Object o) {
        Item i = (Item) o;
        if (i.getName().equals(this.getName()) && i.getCost() == this.getCost()) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + (int) cost;
    }
}
