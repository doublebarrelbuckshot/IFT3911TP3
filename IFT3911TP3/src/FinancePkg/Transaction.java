package FinancePkg;

public class Transaction {
	public Confirmation _confirmationNumber;

	public Confirmation pay(double aMontant) {
		_confirmationNumber = new Confirmation();
		_confirmationNumber.setTransaction(this);
		
		GenerateurConfirmation generateur = new GenerateurConfirmation();
		_confirmationNumber.set_numero(generateur.get_numeroConfirmation());
		
		return _confirmationNumber;
	}

	public void refund(double aMontant) {
		throw new UnsupportedOperationException();
	}
}