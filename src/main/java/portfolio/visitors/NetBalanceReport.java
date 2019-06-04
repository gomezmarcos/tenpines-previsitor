package portfolio.visitors;

import portfolio.AccountTransaction;
import portfolio.ReceptiveAccount;
import portfolio.TransferWithdraw;

public class NetBalanceReport {
    private ReceptiveAccount receptiveAccount;
    private double balance;

    public NetBalanceReport(ReceptiveAccount receptiveAccount) {
        this.receptiveAccount = receptiveAccount;
    }

    public double invoke() {
        balance = 0.0;
        for (AccountTransaction transaction : receptiveAccount.getTransactions()) {
            transaction.accept(this);
        }
        return balance;
    }


    public void visitNetBalance(TransferWithdraw transferWithdraw) {
        balance += transferWithdraw.value();
    }
}
