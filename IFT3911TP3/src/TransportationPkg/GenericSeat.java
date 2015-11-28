package TransportationPkg;

import java.util.Date;

import AdminPkg.ITripVisitor;
import ReservationPkg.Reservation;

public abstract class GenericSeat implements ISearchable, ITripVisitable {
	protected Date _reservationDate;
	protected GenericSeatState _state;
	public Reservation _reservation;
	public ComfortClass _section;
	public IReservation _IReservation;

	public double getPrice() {
		throw new UnsupportedOperationException();
	}

	public GenericSeatState get_state(){
		return _state;
	}
	public void set_state(GenericSeatState s){
		this._state= s;
	}
	public void available(){
		this._state.available(this);
	}
	public void reserved(){
		this._state.reserved(this);
	}
	public void confirmed(){
		this._state.confirmed(this);
	}
	
	public abstract void accept(ITripVisitor visitor);
}