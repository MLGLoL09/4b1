public class PremiumAccount extends Account {
    private double premiumFee;
    private int discountRate;
    private boolean feeCharged;

    public PremiumAccount(double fee, int rate, int id, double bal, int inv) {
        super(id, bal, inv);
        premiumFee = fee;
        setDiscountRate(rate);
        feeCharged = false;
    }

    public void setDiscountRate(int rate) {
        if(rate >= 0 && rate <= 100) {
            discountRate = rate;
        } else {
            discountRate = 0;
        }
    }

    public void setFeeCharged(boolean charged) {
        feeCharged = charged;
    }

    public boolean getFeeCharged() {
        return feeCharged;
    }

    public void chargeMonthlyFee() {
        double bal1 = getBalance();
        this.setBalance(bal1 - premiumFee);
        double bal2 = getBalance();
        if(bal2 < bal1){
            feeCharged = true;
        } else {
            feeCharged = false;
        }
    }

    @Override
    public boolean buyItem(Item item) {
        double discountedPrice = item.getCost() - ((this.discountRate * item.getCost()) / 100);
        return super.buyItem(new Item(item.getName(), discountedPrice));
    }

    @Override
    public String accountData() {
        String data = "";
        data += "Premium Account\n";
        data += "Premium Kosten: " + premiumFee + "\n";
        data += "Rabatt: " + discountRate + "\n";
        data += super.accountData();
        data += "Rabatt abgezogen: " + feeCharged + "\n";
        return data;
    }
}
