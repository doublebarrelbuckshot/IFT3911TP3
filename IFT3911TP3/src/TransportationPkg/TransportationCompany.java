package TransportationPkg;

import CommonComponentsPkg.Adresse;
import CommonComponentsPkg.SearchCriteria;
import AdminPkg.TransportationManager;
import java.util.Vector;
import TransportationPkg.TransportationVehicle;
import TransportationPkg.TripGeneral;

public abstract class TransportationCompany implements ISearchable {
	protected int _id;
	protected Adresse _adresse;
	protected String _name;
	public TransportationManager tptManager;
	public Vector<TransportationVehicle> _tptVehicles = new Vector<TransportationVehicle>();
	public Vector<TripGeneral> _tripGenerals = new Vector<TripGeneral>();

	public void addTripGeneral(TripGeneral tg)
	{
		this._tripGenerals.add(tg);
	}
	public void addTripGeneral(TransportationHub aThDepart, TransportationHub aThArrive) {
		throw new UnsupportedOperationException();
	}
	
	public void addTransportationVehicle(TransportationVehicle tv)
	{
		this._tptVehicles.add(tv);
	}

	public void removeTripGeneral(TripGeneral aTg) {
		throw new UnsupportedOperationException();
	}

	public String rename(String aN) {
		throw new UnsupportedOperationException();
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
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

	public TransportationManager getTptManager() {
		return tptManager;
	}

	public void setTptManager(TransportationManager tptManager) {
		this.tptManager = tptManager;
	}

	public Vector<TransportationVehicle> get_tptVehicles() {
		return _tptVehicles;
	}

	public void set_tptVehicles(Vector<TransportationVehicle> _tptVehicles) {
		this._tptVehicles = _tptVehicles;
	}
	

	public Vector<TripGeneral> get_tripGenerals() {
		return _tripGenerals;
	}

	public void set_tripGenerals(Vector<TripGeneral> _tripGenerals) {
		this._tripGenerals = _tripGenerals;
	}
	
	public boolean matchCriteria(SearchCriteria aSc){
		if(aSc.get_transportationCompanyName().equals(this.get_name())){
			return true;
		} 
		return false;
	}
	
	
}