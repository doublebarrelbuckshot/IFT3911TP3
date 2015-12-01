package ReservationPkg;

import java.util.Vector;

import TransportationPkg.GenericSeat;
import TransportationPkg.IReservation;
import TransportationPkg.TripInstance;

public class Reservation extends Order implements IReservation {
	private Vector<GenericSeat> _reservedSeats = new Vector<GenericSeat>();
	private double reservationPrice;
	public Reservation(){
		super();
	}
	public void cancelOrder() {
		throw new UnsupportedOperationException();
	}
	
	public void addSeat(GenericSeat aGs) {
		_reservedSeats.add(aGs);
	}
	
	public Vector<GenericSeat> get_reservedSeats(){
		return _reservedSeats;
	}
	public Reservation(boolean isActive, Client client, TripInstance tripInstance) {
		super(isActive, client, tripInstance);
	}

	public IReservation getReservation() {
		throw new UnsupportedOperationException();
	}
	public double getReservationPrice() {
		return reservationPrice;
	}
	public void setReservationPrice(double reservationPrice) {
		this.reservationPrice = reservationPrice;
	}
	
}
