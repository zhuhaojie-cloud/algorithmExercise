package test.strategyShop;

public class CashContext {
    private CashSuper cashSuper;
    public CashContext(CashSuper cashSuper) {
         this.cashSuper = cashSuper;
    }

    public double getResult(double money) {
        return cashSuper.acceptCash(money);
    }
}
