public class AccountTest {
    public static void main(String[] args) {
        testAccountCreation();
        testSetBalance();
        testBuyItemSuccess();
        testBuyItemFailureDueToBalance();
        testPremiumAccountDiscount();
        testChargeMonthlyFee();
        testFullItems();


        // Zusätzliche Tests zur Ausgabe von Objektdaten
        Account player1 = new Account(1, 100.0, 10);
        System.out.println("Account 1: " + player1.accountData());

        Account player2 = new Account(2, 100.0, 10);
        System.out.println("Account 2: " + player2.accountData());

        System.out.println("Vergleich Account 1 und Account 2: " + player1.equals(player2));
    }

    /**
     * Testet die Erstellung eines Accounts mit einem Startguthaben.
     * Erwartet: Der Kontostand entspricht dem initial gesetzten Wert.
     */
    public static void testAccountCreation() {
        Account acc = new Account(1, 100.0, 5);
        System.out.println(acc.accountData());
        if (acc.getBalance() == 100.0) {
            System.out.println("testAccountCreation passed");
        } else {
            System.out.println("testAccountCreation failed");
        }
    }

    /**
     * Testet, dass ein negativer Kontostand auf 0 gesetzt wird.
     * Erwartet: Der Kontostand ist 0.
     */
    public static void testSetBalance() {
        Account acc = new Account(2, -50.0);
        System.out.println(acc.accountData());
        if (acc.getBalance() == 0.0) {
            System.out.println("testSetBalance passed");
        } else {
            System.out.println("testSetBalance failed");
        }
    }

    /**
     * Testet den erfolgreichen Kauf eines Items, wenn genug Guthaben vorhanden ist.
     * Erwartet: Der Kauf ist erfolgreich.
     */
    public static void testBuyItemSuccess() {
        Account acc = new Account(3, 200.0, 5);
        Item item = new Item("Laptop", 150.0);
        boolean result = acc.buyItem(item);
        System.out.println(acc.accountData());
        if (result) {
            System.out.println("testBuyItemSuccess passed");
        } else {
            System.out.println("testBuyItemSuccess failed");
        }
    }

    /**
     * Testet den fehlgeschlagenen Kauf eines Items, wenn nicht genug Guthaben vorhanden ist.
     * Erwartet: Der Kauf schlägt fehl.
     */
    public static void testBuyItemFailureDueToBalance() {
        Account acc = new Account(4, 50.0, 5);
        Item item = new Item("Phone", 100.0);
        boolean result = acc.buyItem(item);
        System.out.println(acc.accountData());
        if (!result) {
            System.out.println("testBuyItemFailureDueToBalance passed");
        } else {
            System.out.println("testBuyItemFailureDueToBalance failed");
        }
    }

    /**
     * Testet, ob der Rabatt eines Premium-Accounts beim Kauf eines Items angewendet wird.
     * Erwartet: Der Kauf ist erfolgreich und der Rabatt wird berücksichtigt.
     */
    public static void testPremiumAccountDiscount() {
        PremiumAccount pAcc = new PremiumAccount(10.0, 20, 5, 500.0, 5);
        Item item = new Item("Tablet", 100.0);
        pAcc.setFeeCharged(pAcc.buyItem(item));
        System.out.println(pAcc.accountData());
        if (pAcc.getFeeCharged()) {
            System.out.println("testPremiumAccountDiscount passed");
        } else {
            System.out.println("testPremiumAccountDiscount failed");
        }
    }

    /**
     * Testet, ob die monatliche Gebühr vom Guthaben abgezogen wird.
     * Erwartet: Der Kontostand wird um die Premium-Gebühr reduziert.
     */
    public static void testChargeMonthlyFee() {
        PremiumAccount pAcc = new PremiumAccount(20.0, 10, 6, 200.0, 5);
        pAcc.chargeMonthlyFee();
        System.out.println(pAcc.accountData());
        if (pAcc.getBalance() == 180.0) {
            System.out.println("testChargeMonthlyFee passed");
        } else {
            System.out.println("testChargeMonthlyFee failed");
        }
    }

    /**
     * Testet den Kauf von mehreren Items, um zu prüfen, ob der Account alle Käufe korrekt verarbeitet.
     * Erwartet: Alle Käufe werden erfolgreich durchgeführt, und der Kontostand wird korrekt aktualisiert.
     */
    public static void testFullItems() {
        Account acc = new Account(6, 600.0, 5);
        acc.buyItem(new Item("Phone", 100.0));
        acc.buyItem(new Item("Tablet", 100.0));
        acc.buyItem(new Item("Laptop", 100.0));
        acc.buyItem(new Item("Desktop", 100.0));
        acc.buyItem(new Item("Monitor", 100.0));
        acc.buyItem(new Item("Printer", 100.0));
        System.out.println(acc.accountData());
        boolean isNull = false;
        for (int j = 0; j < acc.getInventory().length; j++) {
            if (acc.getInventory()[j] == null) {
                isNull = true;
            }
        }
        if (!isNull) {
            System.out.println("testFullItems passed");
        } else {
            System.out.println("testFullItems failed");
        }
    }
}