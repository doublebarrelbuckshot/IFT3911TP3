package FinancePkg;

public class Confirmation {
	private int _numero;
	public Paiement _unnamed_Paiement_;
	public Transaction _transaction;

	public void setUnnamed_Paiement_(Paiement aUnnamed_Paiement_) {
		this._unnamed_Paiement_ = aUnnamed_Paiement_;
	}

	public Paiement getUnnamed_Paiement_() {
		return this._unnamed_Paiement_;
	}

	public void setTransaction(Transaction aTransaction) {
		this._transaction = aTransaction;
	}

	public Transaction getTransaction() {
		return this._transaction;
	}
}