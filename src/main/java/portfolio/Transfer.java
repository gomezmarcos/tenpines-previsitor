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

public class Transfer {
	private final double value;
	private final ReceptiveAccount fromAccount;
	private final ReceptiveAccount toAccount;
	private final TransferDeposit depositLeg;
	private final TransferWithdraw withdrawLeg;

	public Transfer(double value, ReceptiveAccount fromAccount,
					ReceptiveAccount toAccount) {
		this.value = value;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.depositLeg = new TransferDeposit(this);
		this.withdrawLeg = new TransferWithdraw(this);
	}

	public static Transfer registerFor(double value, ReceptiveAccount fromAccount,
									   ReceptiveAccount toAccount) {

		Transfer transfer = new Transfer(value,fromAccount,toAccount);
		fromAccount.register(transfer.withdrawLeg());
		toAccount.register(transfer.depositLeg());

		return transfer;
	}

	public TransferLeg depositLeg() {
		return depositLeg;
	}

	public TransferLeg withdrawLeg() {
		return withdrawLeg;
	}

	public double value () {
		return value;
	}

}
