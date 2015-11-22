package AdminPkg;

import TransportationPkg.TransportationVehicle;
import TransportationPkg.ConfigValues;
import java.util.Vector;
import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationCompany;
import TransportationPkg.ISearchable;
import TransportationPkg.TripGeneral;

public class TransportationManager {
	private static TransportationManager _instance;
	public ConfigValues _config;
	public Vector<TransportationHub> _listTptHubs = new Vector<TransportationHub>();
	public Vector<TransportationCompany> _listTptCompanies = new Vector<TransportationCompany>();
	public Vector<ISearchable> _listSearchable = new Vector<ISearchable>();
	public Vector<TripGeneral> _listTripGenerals = new Vector<TripGeneral>();
	
	private TransportationManager() {
	}

	public static TransportationManager getInstance() {
		if(_instance == null)
			_instance = new TransportationManager();
		return _instance;
	}

	public void addTripGeneral(TripGeneral aTg) {
		this._listTripGenerals.add(aTg);
		_listSearchable.add(aTg);
	}

	public void addTransportCompany(TransportationCompany aTc) {
		this._listTptCompanies.add(aTc);
		_listSearchable.add(aTc);
	}

	public void addTransportationHub(TransportationHub aTh) {
		this._listTptHubs.add(aTh);
		_listSearchable.add(aTh);
	}


	public void removeTransportationHub(TransportationHub aTh) {
		this._listTptCompanies.remove(aTh);
		_listSearchable.remove(aTh);
	}

	public void removeTransportCompany(TransportationCompany aTc) {
		this._listTptCompanies.remove(aTc);
		_listSearchable.remove(aTc);
	}

	public void removeTripGeneral(TripGeneral aTg) {
		this._listTripGenerals.remove(aTg);
		_listSearchable.remove(aTg);
	}

	public void addTripGeneral(String aTripID, TransportationHub aDepart, TransportationHub aArrive) {
		//this._listTripGenerals.add(arg0)
	}

	public TransportationManager get_instance() {
		return _instance;
	}

	public void set_instance(TransportationManager _instance) {
		this._instance = _instance;
	}

	public ConfigValues get_config() {
		return _config;
	}

	public void set_config(ConfigValues _config) {
		this._config = _config;
	}

	public Vector<TransportationHub> get_listTptHubs() {
		return _listTptHubs;
	}

	public void set_listTptHubs(Vector<TransportationHub> _listTptHubs) {
		this._listTptHubs = _listTptHubs;
	}

	public Vector<TransportationCompany> get_listTptCompanies() {
		return _listTptCompanies;
	}

	public void set_listTptCompanies(Vector<TransportationCompany> _listTptCompanies) {
		this._listTptCompanies = _listTptCompanies;
	}

	public Vector<ISearchable> get_listSearchable() {
		return _listSearchable;
	}

	public void set_listSearchable(Vector<ISearchable> _listSearchable) {
		this._listSearchable = _listSearchable;
	}
	
	
}