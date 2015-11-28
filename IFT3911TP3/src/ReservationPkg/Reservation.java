package ReservationPkg;

import java.util.Vector;
import TransportationPkg.GenericSeat;
import TransportationPkg.TripInstance;
import TransportationPkg.IReservation;

public class Reservation extends Order implements IReservation {
	public Vector<GenericSeat> _reservedSeats = new Vector<GenericSeat>();
	private int numeroReservation=5;
	
	public void cancelOrder() {
		throw new UnsupportedOperationException();
	}
	
	public void addSeat(GenericSeat aGs) {
		throw new UnsupportedOperationException();
	}

	public Reservation(TripInstance aTi) {
		throw new UnsupportedOperationException();
	}

	public IReservation getReservation() {
		throw new UnsupportedOperationException();
	}
	
	public int get_numeroReservation(){
		return numeroReservation;
	}
}