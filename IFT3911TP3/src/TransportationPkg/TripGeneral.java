package TransportationPkg;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Date;
import java.util.Vector;

import AdminPkg.ITripVisitor;
import TransportationPkg.TripInstance;

public abstract class TripGeneral implements ISearchable {
	protected Date _heureDepart;
	protected String _tripID;
	protected Date _heureArrive;
	public TransportationHub _hubDeparture;
	public TransportationCompany tptCompany;
	public Vector<TripInstance> _tripInstances = new Vector<TripInstance>();
	public TransportationHub _hubArrival;

	
	public Date get_heureDepart() {
		return _heureDepart;
	}
	
	public String get_heureDepartStr(){
	DateFormat df = new SimpleDateFormat("hh:mm a");
	return df.format(_heureDepart);
	}
	
	public void set_heureDepart(Date _heureDepart) {
		this._heureDepart = _heureDepart;
	}

	public String get_tripID() {
		return _tripID;
	}

	public void set_tripID(String _tripID) {
		this._tripID = _tripID;
	}

	public Date get_heureArrive() {
		return _heureArrive;
	}
	
	public String get_heureArriveStr(){
		DateFormat df = new SimpleDateFormat("hh:mm a");

		return df.format(_heureArrive);
	}

	public void set_heureArrive(Date _heureArrive) {
		this._heureArrive = _heureArrive;
	}

	public TransportationHub get_hubDeparture() {
		return _hubDeparture;
	}

	public void set_hubDeparture(TransportationHub _hubDeparture) {
		this._hubDeparture = _hubDeparture;
	}

	public TransportationCompany getTptCompany() {
		return tptCompany;
	}

	public void setTptCompany(TransportationCompany tptCompany) {
		this.tptCompany = tptCompany;
	}

	public Vector<TripInstance> get_tripInstances() {
		return _tripInstances;
	}

	public void set_tripInstances(Vector<TripInstance> _tripInstances) {
		this._tripInstances = _tripInstances;
	}

	public TransportationHub get_hubArrival() {
		return _hubArrival;
	}

	public void set_hubArrival(TransportationHub _hubArrival) {
		this._hubArrival = _hubArrival;
	}

	public void addTripInstance(TripInstance ti) {
		this._tripInstances.add(ti);
	}

	public boolean referencesTptHub(TransportationHub aA) {
		throw new UnsupportedOperationException();
	}

	public Period getDuree() {
		throw new UnsupportedOperationException();
	}

	public Date changeDepartTime(Date aD) {
		throw new UnsupportedOperationException();
	}

	public Date changeArriveTime(Date aD) {
		throw new UnsupportedOperationException();
	}
	
	
}
