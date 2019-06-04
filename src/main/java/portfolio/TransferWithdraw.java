package portfolio;

import portfolio.visitors.NetBalanceReport;

public class TransferWithdraw implements TransferLeg {
 
    private Transfer transfer;
     
    public TransferWithdraw (Transfer transfer) {
        this.transfer = transfer;
    }
     
    public double value(){
        return transfer.value();
    }



    public Transfer transfer(){
        return transfer;
    }
 
    public double affectBalance(double balance) {
        return balance - value();
    }

    public String summary() {
        return "Transferencia por -"+transfer.value() ;
    }

    public double affectTransferNetBalance(double balance) {
        return balance-transfer.value();
    }

    public double affectInvestmentNetBalance(double balance) {
        return balance;
    }

    public double affectInvestmentEaringBalance(double balance) {
        return balance;
    }

    @Override
    public void accept(NetBalanceReport netBalanceReport) {
        netBalanceReport.visitNetBalance(this);
    }

    NetBalanceReport report;
}