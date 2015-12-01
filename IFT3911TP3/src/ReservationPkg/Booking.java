package ReservationPkg;

import java.util.Date;
import java.util.Vector;

import ReservationPkg.Passager;
import FinancePkg.Paiement;
import TransportationPkg.InstanceSeat;
import TransportationPkg.TripInstance;

public class Booking extends Order {
	private double _accountBalance;
	private double _totalPrice;
	
	private Paiement paiement;

	public Booking(boolean isActive, Client client, TripInstance tripInstance) {
		super(isActive, client, tripInstance);
	}
	
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

	public void addPmt(Paiement aPmt) {
		this._accountBalance -= aPmt.get_montant();
	}

	public boolean pay(double montant, String digit, Date exp) {
		this.paiement = new Paiement(this, montant,digit,exp);
		this.paiement.set_booking(this);
		boolean value = this.paiement.conductPayment();
		
		if(value) addPmt(this.paiement);
		
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

	public Paiement getPaiement() {
		return paiement;
	}

	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}

	public double get_accountBalance() {
		return _accountBalance;
	}

	public void set_accountBalance(double _accountBalance) {
		this._accountBalance = _accountBalance;
	}

	public double get_totalPrice() {
		return _totalPrice;
	}
	public double get_refundableAmount() {
		return _totalPrice * 0.9;
	}
	public void set_totalPrice(double _totalPrice) {
		this._totalPrice = _totalPrice;
	}
}