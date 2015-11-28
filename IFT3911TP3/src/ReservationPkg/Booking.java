package ReservationPkg;

import java.util.Date;
import java.util.Vector;

import ReservationPkg.Passager;
import FinancePkg.Paiement;
import TransportationPkg.InstanceSeat;
import TransportationPkg.TripInstance;

public class Booking extends Order {
	private double _accountBalance;
	public Vector<Passager> _listPassagers = new Vector<Passager>();
	public Paiement paiement;

	public Booking() {
		super();
	}
	
	public void cancelOrder() {
		throw new UnsupportedOperationException();
	}

	public double calcMontant() {
		throw new UnsupportedOperationException();
	}

	public double calcBalanceDifference() {
		throw new UnsupportedOperationException();
	}

	public void assignSeat(Passager aP, InstanceSeat aS) {
		aP.setAssignedSeat(aS);
	}

	public void addPass(Passager aP) {
		throw new UnsupportedOperationException();
	}

	public void addPmt(Paiement aPmt) {
		this._accountBalance += aPmt.get_montant();
	}

	public boolean pay(double montant, int digit, Date exp) {
		Paiement p = new Paiement(montant,digit,exp);
		p._booking = this;
		boolean value = p.conductPayment();
		
		if(value) addPmt(p);
		
		return value;
	}

	public Passager getPassengers() {
		throw new UnsupportedOperationException();
	}

	public Passager changeTripInstance(TripInstance aNewTI) {
		throw new UnsupportedOperationException();
	}

	public Booking Booking(Reservation aR) {
		throw new UnsupportedOperationException();
	}
}