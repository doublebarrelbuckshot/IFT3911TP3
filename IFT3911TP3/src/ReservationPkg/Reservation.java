package ReservationPkg;

import java.util.Vector;

import TransportationPkg.GenericSeat;
import TransportationPkg.IReservation;
import TransportationPkg.TripInstance;

public class Reservation extends Order implements IReservation {
	public Vector<GenericSeat> _reservedSeats = new Vector<GenericSeat>();
	
	public Reservation(){
		super();
	}
	public void cancelOrder() {
		throw new UnsupportedOperationException();
	}
	
	public void addSeat(GenericSeat aGs) {
		_reservedSeats.add(aGs);
	}

	public Reservation(boolean isActive, Client client, TripInstance tripInstance) {
		super(isActive, client, tripInstance);
	}

	public IReservation getReservation() {
		throw new UnsupportedOperationException();
	}
	
}
