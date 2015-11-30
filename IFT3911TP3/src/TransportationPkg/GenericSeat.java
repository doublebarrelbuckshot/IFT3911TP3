package TransportationPkg;

import java.util.Date;

import AdminPkg.ITripVisitor;
import ReservationPkg.Reservation;

public abstract class GenericSeat implements ISearchable, ITripVisitable {
	protected Date _reservationDate;
	protected GenericSeatState _state;
	protected IPassenger _Ipassenger;
	private ComfortClass _section;
	public IReservation _IReservation;

	public double getPrice() {
		throw new UnsupportedOperationException();
	}
	public ComfortClass get_comfortClass(){return _section;}
	public void set_comfortClass(ComfortClass section){ this._section = section;}
	public void set_reservationDate(Date date){
		_reservationDate = date;
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
	public IPassenger get_Ipassenger() {
		return _Ipassenger;
	}
	public void set_Ipassenger(IPassenger _Ipassenger) {
		this._Ipassenger = _Ipassenger;
	}
	
	public boolean isBeforeTime(){
		String timeCompare = this.get_comfortClass().get_tripInstance().get_tripDescription().get_timeCompare();
		int hours =_reservationDate.getHours();
		int totalHours = Integer.parseInt(timeCompare) + hours;

		_reservationDate.setHours(totalHours);
		Date now = new Date();
		if(now.before(_reservationDate))
			return true;
		else
			return false;
		
	}
}