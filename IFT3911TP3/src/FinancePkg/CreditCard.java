package FinancePkg;

import java.util.Date;

public class CreditCard {
	private String _digits;
	private Date _expiration;
	public Paiement _paiement;
	
	public CreditCard(String digit, Date exp){
		this.set_digits(digit);
		this.set_expiration(exp);
	}
	
	public String get_digits() {
		return _digits;
	}

	public void set_digits(String _digits) {
		this._digits = _digits;
	}
	
	public Date get_expiration() {
		return _expiration;
	}

	public void set_expiration(Date _expiration) {
		this._expiration = _expiration;
	}


}