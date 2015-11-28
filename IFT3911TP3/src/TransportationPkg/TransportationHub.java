package TransportationPkg;

import CommonComponentsPkg.Adresse;
import CommonComponentsPkg.SearchCriteria;
import AdminPkg.TransportationManager;

import java.util.Vector;

import TransportationPkg.TripGeneral;

public abstract class TransportationHub implements ISearchable {
	protected String _id;
	protected Adresse _adresse;
	protected String _name;
	protected boolean _isActive;
	public TransportationManager tptManager;
	public Vector<TripGeneral> arrivalHub = new Vector<TripGeneral>();
	public Vector<TripGeneral> departureHub = new Vector<TripGeneral>();

	public String rename(String aN) {
		throw new UnsupportedOperationException();
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Adresse get_adresse() {
		return _adresse;
	}

	public void set_adresse(Adresse _adresse) {
		this._adresse = _adresse;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public boolean is_isActive() {
		return _isActive;
	}

	public void set_isActive(boolean _isActive) {
		this._isActive = _isActive;
	}

	public TransportationManager getTptManager() {
		return tptManager;
	}

	public void setTptManager(TransportationManager tptManager) {
		this.tptManager = tptManager;
	}

	public Vector<TripGeneral> getArrivalHub() {
		return arrivalHub;
	}

	public void setArrivalHub(Vector<TripGeneral> arrivalHub) {
		this.arrivalHub = arrivalHub;
	}

	public Vector<TripGeneral> getDepartureHub() {
		return departureHub;
	}

	public void setDepartureHub(Vector<TripGeneral> departureHub) {
		this.departureHub = departureHub;
	}
	
	
	public boolean matchCriteria(SearchCriteria aSc){
		if(aSc.get__transportationHubNameArrival().equals(this.get_id())){
			return true;
		} 
		if(aSc.get__transportationHubNameDeparture().equals(this.get_id())){
			return true;
		}
		return false;
	}
	
	
}