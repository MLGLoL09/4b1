import java.util.Arrays;

public class Account {
    private int accountId;
    private double balance;
    private Item[] inventory;

    public Account(int id, double bal, int inv) {
        accountId = id;
        setBalance(bal);
        inventory = new Item[inv];
    }

    public Account(int Id, double bal) {
        this(Id, bal, 10);
    }

    public void setBalance(double bal) {
        if (bal > 0) {
            balance = bal;
        } else {
            balance = 0;
        }
    }

    public double getBalance() {
        return balance;
    }

    public Item[] getInventory() {
        return inventory;
    }

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

    @Override
    public boolean equals(Object o) {
        Account a = (Account) o;
        if (accountId == a.accountId && balance == a.balance && Arrays.equals(inventory, a.inventory)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return accountId + Double.hashCode(balance) + Arrays.hashCode(inventory);
    }
}
