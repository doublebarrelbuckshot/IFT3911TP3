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
		Date heure_depart = this.get_comfortClass().get_tripInstance().get_tripDescription().get_heureDepart();
		Date date_depart = this.get_comfortClass().get_tripInstance().get_dateDepart();

		Date temp = new Date();
		temp.setTime(heure_depart.getTime());
		temp.setMonth(date_depart.getMonth());
		temp.setDate(date_depart.getDate());
		temp.setYear(date_depart.getYear());
		
		Date now = new Date();
		int totalHours = temp.getHours() - Integer.parseInt(timeCompare);
		temp.setHours(totalHours);
		
		if(now.before(temp))
			return true;
		else
			return false;
		
	}
}