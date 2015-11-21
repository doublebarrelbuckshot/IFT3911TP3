package AdminPkg.CruiseAdminPkg;

import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationCompany;
import TransportationPkg.TransportationVehicle;
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

	private CruiseFactory getInstance() {
		return this._instance;
	}

	private CruiseFactory() {
		throw new UnsupportedOperationException();
	}
}