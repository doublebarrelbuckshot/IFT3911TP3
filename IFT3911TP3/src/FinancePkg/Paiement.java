package FinancePkg;

import java.util.Date;

import ReservationPkg.Booking;

public class Paiement {
	private double _montant;
	public Booking _booking;
	private Confirmation _confirmationNumber;
	private CreditCard _creditCard;

	public Paiement (double montant, int digit, Date exp){
		this._montant = montant;
		this._creditCard = new CreditCard(digit, exp);
	}
	public boolean conductPayment() {
		Transaction transaction =new Transaction();
		this._confirmationNumber =  transaction.get_confirmationNumber();
		this._confirmationNumber.set_paiement_(this);
		boolean value =transaction.pay(this._montant);
		
		return value;
	}
	
	public CreditCard get_creditcard(){return this._creditCard;}
	public Confirmation get_confirmationNumber(){return this._confirmationNumber;}
}