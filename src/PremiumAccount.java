public class PremiumAccount {
    private double premiumFee;
    private int discountRate;
    private boolean feeCharged;

    public PremiumAccount(double fee, int rate) {
        premiumFee = fee;
        setDiscountRate(rate);
        feeCharged = false;
    }

    public int setDiscountRate(int rate) {
        if(rate >= 0 && rate <= 100) {
            return rate;
        }
        return 0;
    }

    public void chargeMonthlyFee() {
        
    }
}
