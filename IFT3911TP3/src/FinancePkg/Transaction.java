package FinancePkg;

public class Transaction {
	private Confirmation _confirmationNumber;

	public Transaction(){
		_confirmationNumber = new Confirmation();
		_confirmationNumber.setTransaction(this);
	}
	
	public boolean pay(double aMontant) {
		
		GenerateurConfirmation generateur = new GenerateurConfirmation();
		_confirmationNumber.set_numero(generateur.get_numeroConfirmation());
		
		return true;
	}

	public void refund(double aMontant) {
		throw new UnsupportedOperationException();
	}
	
	public Confirmation get_confirmationNumber(){return _confirmationNumber;}
}