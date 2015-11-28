package FinancePkg;

import java.util.Date;

public class CreditCard {
	private int _digits;
	private Date _expiration;
	public Paiement _unnamed_Paiement_;
	
	public CreditCard(int digit, Date exp){
		this._digits=digit;
		this._expiration=exp;
	}
}