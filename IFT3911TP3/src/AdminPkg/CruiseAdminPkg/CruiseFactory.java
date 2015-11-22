package AdminPkg.CruiseAdminPkg;

import java.util.Date;

import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationCompany;
import TransportationPkg.TransportationVehicle;
import TransportationPkg.TripGeneral;
import AdminPkg.TransportationFactory;

public class CruiseFactory extends TransportationFactory {
	private CruiseFactory _instance;

	public TransportationHub createTransportationHub(String aName) {
		throw new UnsupportedOperationException();
	}

	public TransportationCompany createTransportCompany(String aName) {
		throw new UnsupportedOperationException();
	}

	public TransportationVehicle createTransportVehicle() {
		throw new UnsupportedOperationException();
	}
	public TripGeneral createTripGeneral(Date dateDepart, Date dateArrival, String tripID, TransportationHub depart, TransportationHub arrive ){
		throw new UnsupportedOperationException();
	}

	private CruiseFactory getInstance() {
		return this._instance;
	}

	private CruiseFactory() {
		throw new UnsupportedOperationException();
	}
}