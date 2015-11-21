package AdminPkg;

import TransportationPkg.TransportationVehicle;
import TransportationPkg.ConfigValues;
import java.util.Vector;
import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationCompany;
import TransportationPkg.ISearchable;
import TransportationPkg.TripGeneral;

public class TransportationManager {
	private java.util.Vector<TransportationVehicle> _listTransportationVehicles;
	private TransportationManager _instance;
	public ConfigValues _config;
	public Vector<TransportationHub> _listTptHubs = new Vector<TransportationHub>();
	public Vector<TransportationCompany> _listTptCompanies = new Vector<TransportationCompany>();
	public Vector<ISearchable> _listSearchable = new Vector<ISearchable>();

	private TransportationManager() {
		throw new UnsupportedOperationException();
	}

	public TransportationManager getInstance() {
		return this._instance;
	}

	public void addTripGeneral(TripGeneral aTg) {
		throw new UnsupportedOperationException();
	}

	public void addTransportCompany(TransportationCompany aTc) {
		throw new UnsupportedOperationException();
	}

	public void addTransportationHub(TransportationHub aTh) {
		throw new UnsupportedOperationException();
	}

	public void addTransportationVehicle(TransportationVehicle aTv) {
		throw new UnsupportedOperationException();
	}

	public void removeTransportationHub(TransportationHub aTh) {
		throw new UnsupportedOperationException();
	}

	public void removeTransportCompany(TransportationCompany aTc) {
		throw new UnsupportedOperationException();
	}

	public void removeTransportationVehicle(TransportationVehicle aTv) {
		throw new UnsupportedOperationException();
	}

	public void removeTripGeneral(TripGeneral aTg) {
		throw new UnsupportedOperationException();
	}

	public void addTripGeneral(String aTripID, TransportationHub aDepart, TransportationHub aArrive) {
		throw new UnsupportedOperationException();
	}
}