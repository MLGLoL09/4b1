/**
 * Dieses Programm erstellt Accounts mit einem bestimmten ID Kontostand und inventar größe man jkann aber auch einen premium account machen wo man schaen biller kaufen kann
 * @author Sebastian Weigl
 * @version 03-11-2025
 */

public class Item {
    private String name;
    private double cost;

    /**
     * Erstellt ein Item-Objekt mit einem Namen und einem Preis.
     *
     * @param n Der Name des Items
     * @param c Der Preis des Items
     */
    public Item(String n, double c) {
        name = n;
        setCost(c);
    }

    /**
     * Setzt den Preis des Items. Falls der übergebene Wert negativ ist, wird der Preis auf 0 gesetzt.
     *
     * @param c Der neue Preis des Items
     */
    public void setCost(double c) {
        if (c > 0) {
            cost = c;
        } else {
            cost = 0;
        }
    }

    /**
     * Gibt den Preis des Items zurück.
     *
     * @return Der Preis des Items
     */
    public double getCost() {
        return cost;
    }

    /**
     * Gibt den Namen des Items zurück.
     *
     * @return Der Name des Items
     */
    public String getName() {
        return name;
    }

    /**
     * Gibt eine String-Darstellung des Items zurück.
     *
     * @return Eine Zeichenkette mit dem Namen und Preis des Items
     */
    @Override
    public String toString() {
        return getName() + " " + getCost() + "€";
    }

    /**
     * Vergleicht dieses Item mit einem anderen Objekt auf Gleichheit.
     * Zwei Items sind gleich, wenn ihr Name und Preis übereinstimmen.
     *
     * @param o Das Objekt, mit dem verglichen wird
     * @return true, wenn die Items gleich sind, sonst false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item i = (Item) o;
        return Double.compare(i.cost, cost) == 0 && name.equals(i.name);
    }

    /**
     * Berechnet den Hashcode für das Item basierend auf dem Namen und dem Preis.
     *
     * @return Der Hashcode des Items
     */
    @Override
    public int hashCode() {
        return name.hashCode() + (int) cost;
    }
}