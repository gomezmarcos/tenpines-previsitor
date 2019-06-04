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

public class CertificateOfDeposit implements AccountTransaction {

	private final double value;
	private final int numberOfDays;
	private double tna;

	public CertificateOfDeposit(double value, int numberOfDays, double tna) {
		this.value = value;
		this.tna = tna;
		this.numberOfDays = numberOfDays;
	}

	public static CertificateOfDeposit registerFor(double value, int numberOfDays, double tna,
												   ReceptiveAccount account) {

		CertificateOfDeposit certificateOfDeposit = new CertificateOfDeposit(value, numberOfDays, tna);
		account.register(certificateOfDeposit);

		return certificateOfDeposit;
	}

	public double value() {
		throw new UnsupportedOperationException();
	}

	public double affectBalance(double balance) {
		return balance - value;
	}

	public String summary() {
		return "Plazo fijo por " + value  + " durante "+numberOfDays + " días a una tna de " + tna;
	}

	public double affectTransferNetBalance(double balance) {
		return balance;
	}

	public double affectInvestmentNetBalance(double balance) {
		return balance + value;
	}

	public double affectInvestmentEaringBalance(double balance) {
		return balance + value*(tna/360)*numberOfDays;
	}

}
