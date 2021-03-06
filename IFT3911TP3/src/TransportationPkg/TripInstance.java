package TransportationPkg;

import AdminPkg.ITripVisitor;
import ReservationPkg.Order;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import CommonComponentsPkg.ComfortClassEnum;
import CommonComponentsPkg.SearchCriteria;
import ReservationPkg.Order;

public abstract class TripInstance implements ITripVisitable,ISearchable {
	protected Date _dateDepart;
	protected double _fullPrice;
	protected int _tripInstanceID;
	protected Date _dateArrive;
	public TripGeneral _tripDescription;
	public IOrder _listOrders;
	public Vector<ComfortClass> _comfortClasses = new Vector<ComfortClass>();
	public TransportationVehicle _tptVehicle;
	static String DATE_FORMAT = "dd/MM/yyyy";

	public abstract void assignLayoutToClass(VehicleLayout vl);

	public Date get_dateDepart() {
		return _dateDepart;
	}
	public String get_dateDepartStr(){
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		return df.format(_dateDepart);
	}


	public void set_dateDepart(Date _dateDepart) {
		this._dateDepart = _dateDepart;
	}

	public double get_fullPrice() {
		return _fullPrice;
	}

	public void set_fullPrice(double _fullPrice) {
		this._fullPrice = _fullPrice;
	}

	public int get_tripInstanceID() {
		return _tripInstanceID;
	}

	public void set_tripInstanceID(int _tripInstanceID) {
		this._tripInstanceID = _tripInstanceID;
	}

	public Date get_dateArrive() {
		return _dateArrive;
	}
	
	public String get_dateArriveStr(){
		DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
		return df.format(_dateArrive);
	}
	public void set_dateArrive(Date _dateArrive) {
		this._dateArrive = _dateArrive;
	}


	public TripGeneral get_tripDescription() {
		return _tripDescription;
	}

	public void set_tripDescription(TripGeneral _tripDescription) {
		this._tripDescription = _tripDescription;
	}

	public IOrder get_listOrders() {
		return _listOrders;
	}

	public void set_listOrders(IOrder _listOrders) {
		this._listOrders = _listOrders;
	}

	public Vector<ComfortClass> get_comfortClasses() {
		return _comfortClasses;
	}

	public void set_comfortClasses(Vector<ComfortClass> _comfortClasses) {
		this._comfortClasses = _comfortClasses;
	}

	public TransportationVehicle get_tptVehicle() {
		return _tptVehicle;
	}


	public GenericSeat getSeat(String aSl) {
		throw new UnsupportedOperationException();
	}

	public void setTptVehicle(TransportationVehicle _tptVehicle) {
		this._tptVehicle = _tptVehicle;
	}

	public void removeTptVehicle(TransportationVehicle aTv) {
		throw new UnsupportedOperationException();
	}

	public void addComfortClass() {
		throw new UnsupportedOperationException();
	}

	public void removeComfortClass(ComfortClass aCc) {
		throw new UnsupportedOperationException();
	}

	public void addOrder(Order aO) {
		throw new UnsupportedOperationException();
	}

	public void removeOrder(int aOID) {
		throw new UnsupportedOperationException();
	}

	public void hasOrders() {
		throw new UnsupportedOperationException();
	}
	
	public abstract void accept(ITripVisitor visitor);

	public boolean matchCriteria(SearchCriteria aSc){
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		
		String parsedDepartureDateCriteria = df.format(aSc.get_tripDepartureDate());
		String parsedDepartureDate = this.get_dateDepartStr();
		if (parsedDepartureDateCriteria.equals(parsedDepartureDate)){
			ComfortClassEnum criteriaComfortClass = aSc.get_sectionType();
			for (ComfortClass comfortClass:this.get_comfortClasses()){
				if(criteriaComfortClass.equals(comfortClass.getComfortClassType())){
					if (comfortClass.hasAvailableSeats()){
						return true;
					}
				}
			}
		}
		return false;
	}
	
}
