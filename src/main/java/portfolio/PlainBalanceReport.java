package portfolio;

class PlainBalanceReport {

    private ReceptiveAccount receptiveAccount;
    private double balance;

    public double getBalance() {
        return balance;
    }

    public ReceptiveAccount getReceptiveAccount() {
        return receptiveAccount;
    }

    public PlainBalanceReport(ReceptiveAccount receptiveAccount) {

        this.receptiveAccount = receptiveAccount;
    }

}
