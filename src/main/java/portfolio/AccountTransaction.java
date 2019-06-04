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

public interface AccountTransaction {

	public double value();
	public double affectBalance(double balance);

	String summary();

    double affectTransferNetBalance(double balance);

	double affectInvestmentNetBalance(double balance);

	double affectInvestmentEaringBalance(double balance);

	void accept(NetBalanceReport netBalanceReport);
}
