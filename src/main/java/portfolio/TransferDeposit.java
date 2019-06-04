package portfolio;

import portfolio.visitors.NetBalanceReport;

public class TransferDeposit implements TransferLeg {
 
    private Transfer transfer;
     
    public TransferDeposit (Transfer transfer) {
        this.transfer = transfer;
    }
     
    public double value(){
        return transfer.value();
    }

    public Transfer transfer(){
        return transfer;
    }
 
    public double affectBalance(double balance) {
        return balance + value();
    }

    public String summary() {
        return "Extracción por "+transfer.value() ;
    }

    public double affectTransferNetBalance(double balance) {
        return balance + transfer.value();
    }

    public double affectInvestmentNetBalance(double balance) {
        throw new UnsupportedOperationException();
    }

    public double affectInvestmentEaringBalance(double balance) {
        return balance;
    }

    @Override
    public void accept(NetBalanceReport netBalanceReport) {
        this.report = netBalanceReport;
    }

    NetBalanceReport report;

}