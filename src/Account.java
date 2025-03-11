import java.util.Arrays;

/**
 * Dieses Programm erstellt Accounts mit einem bestimmten ID Kontostand und inventar größe man jkann aber auch einen premium account machen wo man schaen biller kaufen kann
 * @author Sebastian Weigl
 * @version 03-11-2025
 */

public class Account {
    private int accountId;
    private double balance;
    private Item[] inventory;

    /**
     * Erstellt ein Account-Objekt mit einer angegebenen ID, einem Startguthaben und einer Inventargröße.
     *
     * @param id  Die Konto-ID
     * @param bal Das Startguthaben
     * @param inv Die Anzahl der Inventarplätze
     */
    public Account(int id, double bal, int inv) {
        accountId = id;
        setBalance(bal);
        inventory = new Item[inv];
    }

    /**
     * Erstellt ein Account-Objekt mit einer angegebenen ID und einem Startguthaben.
     * Das Inventar hat standardmäßig 10 Plätze.
     *
     * @param id  Die Konto-ID
     * @param bal Das Startguthaben
     */
    public Account(int id, double bal) {
        this(id, bal, 10);
    }

    /**
     * Setzt das Guthaben des Kontos. Falls der übergebene Wert negativ ist, wird das Guthaben auf 0 gesetzt.
     *
     * @param bal Das neue Guthaben
     */
    public void setBalance(double bal) {
        if (bal > 0) {
            balance = bal;
        } else {
            balance = 0;
        }
    }

    /**
     * Gibt das aktuelle Guthaben des Kontos zurück.
     *
     * @return Das aktuelle Guthaben
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Gibt das Inventar des Kontos zurück.
     *
     * @return Ein Array von Items, das das Inventar repräsentiert
     */
    public Item[] getInventory() {
        return inventory;
    }

    /**
     * Gibt eine String-Darstellung des Kontos zurück, einschließlich der ID, des Guthabens und der Inventargegenstände.
     *
     * @return Eine formatierte Zeichenkette mit den Kontodaten
     */
    @Override
    public String toString() {
        String data = "";
        data += "Account ID: " + accountId + "\n";
        data += "Balance: " + balance + "\n";
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                data += "Inventory Item: " + inventory[i].toString() + "\n";
            }
        }
        return data;
    }

    /**
     * Kauft ein Item, wenn genügend Guthaben vorhanden ist und ein freier Platz im Inventar verfügbar ist.
     *
     * @param item Das zu kaufende Item
     * @return true, wenn das Item erfolgreich gekauft wurde, sonst false
     */
    public boolean buyItem(Item item) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null && item.getCost() <= balance) {
                inventory[i] = item;
                balance -= item.getCost();
                return true;
            }
        }
        return false;
    }

    /**
     * Vergleicht dieses Konto mit einem anderen Objekt auf Gleichheit.
     * Zwei Konten sind gleich, wenn ihre ID, ihr Guthaben und ihr Inventar übereinstimmen.
     *
     * @param o Das Objekt, mit dem verglichen wird
     * @return true, wenn die Konten gleich sind, sonst false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account a = (Account) o;
        return accountId == a.accountId && balance == a.balance && Arrays.equals(inventory, a.inventory);
    }

    /**
     * Berechnet den Hashcode für das Konto basierend auf der ID, dem Guthaben und dem Inventar.
     *
     * @return Der Hashcode des Kontos
     */
    @Override
    public int hashCode() {
        return accountId + Double.hashCode(balance) + Arrays.hashCode(inventory);
    }
}