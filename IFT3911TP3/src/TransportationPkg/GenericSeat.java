package TransportationPkg;

import java.util.Date;

import ReservationPkg.Reservation;

public abstract class GenericSeat implements ISearchable {
	protected Date _reservationDate;
	protected GenericSeatState _state;
	public Reservation _unnamed_Reservation_;
	public ComfortClass _section;
	public IReservation _reservation;
	public GenericSeatState _unnamed_GenericSeatState_;

	public double getPrice() {
		throw new UnsupportedOperationException();
	}

	public void reserved() {
		throw new UnsupportedOperationException();
	}

	public void available() {
		throw new UnsupportedOperationException();
	}

	public void confirmed() {
		throw new UnsupportedOperationException();
	}
	public GenericSeatState get_state(){
		return _state;
	}
	
}