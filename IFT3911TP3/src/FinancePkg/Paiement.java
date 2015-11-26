package FinancePkg;

import java.util.Date;

import ReservationPkg.Booking;

public class Paiement {
	private double _montant;
	public Booking _booking;
	public Confirmation _confirmationNumber;
	public CreditCard _creditCard;

	public Paiement (double montant, int digit, Date exp){
		this._montant = montant;
		this._creditCard = new CreditCard(digit, exp);
	}
	public boolean conductPayment() {
		Transaction transaction =new Transaction();
		this._confirmationNumber = transaction.pay(this._montant);
		this._confirmationNumber.set_paiement_(this);
		
		return true;
	}
}