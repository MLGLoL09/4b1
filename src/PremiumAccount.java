/**
 * Dieses Programm erstellt Accounts mit einem bestimmten ID Kontostand und inventar größe man jkann aber auch einen premium account machen wo man schaen biller kaufen kann
 * @author Sebastian Weigl
 * @version 03-11-2025
 */


public class PremiumAccount extends Account {
    private double premiumFee;
    private int discountRate;
    private boolean feeCharged;

    /**
     * Erstellt ein Premium-Konto mit einer monatlichen Gebühr und einem Rabatt.
     *
     * @param fee  Die monatliche Premium-Gebühr
     * @param rate Der Rabatt in Prozent
     * @param id   Die Konto-ID
     * @param bal  Das Startguthaben
     * @param inv  Die Anzahl der Inventarplätze
     */
    public PremiumAccount(double fee, int rate, int id, double bal, int inv) {
        super(id, bal, inv);
        premiumFee = fee;
        setDiscountRate(rate);
        feeCharged = false;
    }

    /**
     * Setzt die Rabatt-Rate des Premium-Kontos.
     *
     * @param rate Der Rabatt in Prozent (0-100)
     */
    public void setDiscountRate(int rate) {
        if (rate >= 0 && rate <= 100) {
            discountRate = rate;
        } else {
            discountRate = 0;
        }
    }

    /**
     * Setzt den Status, ob die monatliche Gebühr bereits abgezogen wurde.
     *
     * @param charged true, wenn die Gebühr abgezogen wurde, sonst false
     */
    public void setFeeCharged(boolean charged) {
        feeCharged = charged;
    }

    /**
     * Prüft, ob die monatliche Gebühr bereits abgezogen wurde.
     *
     * @return true, wenn die Gebühr abgezogen wurde, sonst false
     */
    public boolean getFeeCharged() {
        return feeCharged;
    }

    /**
     * Zieht die monatliche Premium-Gebühr vom Konto ab.
     */
    public void chargeMonthlyFee() {
        double bal1 = getBalance();
        this.setBalance(bal1 - premiumFee);
        feeCharged = getBalance() < bal1;
    }

    /**
     * Kauft ein Item mit dem Premium-Rabatt.
     *
     * @param item Das zu kaufende Item
     * @return true, wenn der Kauf erfolgreich war, sonst false
     */
    @Override
    public boolean buyItem(Item item) {
        double discountedPrice = item.getCost() - ((this.discountRate * item.getCost()) / 100);
        return super.buyItem(new Item(item.getName(), discountedPrice));
    }
}