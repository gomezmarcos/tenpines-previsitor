/*
 * Developed by 10Pines SRL
 * License: 
 * This work is licensed under the 
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License. 
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-sa/3.0/ 
 * or send a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, 
 * California, 94041, USA.
 *  
 */
package portfolio;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReceptiveAccount implements SummarizingAccount {

	private List<AccountTransaction> transactions = new ArrayList<AccountTransaction>();

    public List<AccountTransaction> getTransactions() {
        return transactions;
    }

    public double balance() {
        //PlainBalanceReport plainBalanceReport = new PlainBalanceReport(this);
        double balance = 0.0;
        for (AccountTransaction transaction : transactions) {
            balance = transaction.affectBalance(balance);
        }

        return balance;
    }

    public double transferNetbalance() {
		double balance = 0.0;
		for (AccountTransaction transaction : transactions) {
			balance = transaction.affectTransferNetBalance(balance);
		}

		return balance;
	}

	public void register(AccountTransaction transaction) {
		transactions.add(transaction);
	}
	
	public boolean registers(AccountTransaction transaction) {
		return transactions.contains(transaction);
	}

	public boolean manages(SummarizingAccount account) {
		return this == account;
	}
	
	public List<AccountTransaction> transactions() {
		return new ArrayList<AccountTransaction>(transactions);
	}

	public List<String> accountSummaryReport() {
		return new AccountSummary().invoke(AccountTransaction::summary);
	}

	public double investmentNetBalance() {
        InvestmentNetBalanceReport investmentNetBalanceReport = new InvestmentNetBalanceReport();
        investmentNetBalanceReport.balance = 0.0;
        for (AccountTransaction transaction : transactions) {
            investmentNetBalanceReport.balance = transaction.affectInvestmentNetBalance(investmentNetBalanceReport.balance);
        }

        return investmentNetBalanceReport.balance;

    }

    public double investmentEaringBalance() {
		double balance = 0.0;
		for (AccountTransaction transaction : transactions) {
			balance = transaction.affectInvestmentEaringBalance(balance);
		}

		return balance;
	}

	private class AccountSummary {
		public List<String> invoke(Function<AccountTransaction, String> strategy) {
			return transactions.stream().map(strategy).collect(Collectors.toList());
		}
	}

    private class InvestmentNetBalanceReport {

        private double balance;

    }

}
