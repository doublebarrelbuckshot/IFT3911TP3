package ReservationPkg;

import java.util.Vector;
import ReservationPkg.Passager;
import FinancePkg.Paiement;
import TransportationPkg.InstanceSeat;
import TransportationPkg.TripInstance;

public class Booking extends Order {
	private double _accountBalance;
	public Vector<Passager> _listPassagers = new Vector<Passager>();
	public Paiement _unnamed_Paiement_;

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
		throw new UnsupportedOperationException();
	}

	public void addPass(Passager aP) {
		throw new UnsupportedOperationException();
	}

	public void addPmt(Paiement aPmt) {
		throw new UnsupportedOperationException();
	}

	public boolean pay() {
		throw new UnsupportedOperationException();
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