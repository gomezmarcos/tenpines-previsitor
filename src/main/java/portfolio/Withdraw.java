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

import portfolio.visitors.NetBalanceReport;

public class Withdraw implements AccountTransaction {

	private double value;
	
	public static Withdraw registerForOn(double value, ReceptiveAccount account) {
		Withdraw withdraw = new Withdraw(value);
		account.register(withdraw);
		
		return withdraw;
	}

	public Withdraw (double value) {
		this.value = value;
	}
	
	public double value() {
		return value;
	}

	@Override
	public double affectBalance(double balance) {
		return balance - value;
	}

	public String summary() {
		return "Extracción por "+value ;
	}

	@Override
	public double affectTransferNetBalance(double balance) {
		return balance;
	}

	@Override
	public double affectInvestmentNetBalance(double balance) {
		return balance;
	}

	@Override
	public double affectInvestmentEaringBalance(double balance) {
		return balance;
	}

	@Override
	public void accept(NetBalanceReport netBalanceReport) {
		this.report = netBalanceReport;
	}

	NetBalanceReport report;


}
