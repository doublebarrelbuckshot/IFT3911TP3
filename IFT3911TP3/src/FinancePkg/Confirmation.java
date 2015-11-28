package FinancePkg;

public class Confirmation {
	private int _numero;
	public Paiement paiement;
	public Transaction _transaction;

	public void set_paiement_(Paiement paiement) {
		this.paiement = paiement;
	}

	public Paiement get_paiement() {
		return this.paiement;
	}

	public void setTransaction(Transaction aTransaction) {
		this._transaction = aTransaction;
	}

	public Transaction getTransaction() {
		return this._transaction;
	}
	public int get_numero(){return _numero;}
	public void set_numero(int num){_numero = num;}
}