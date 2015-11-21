package AdminPkg.AirAdminPkg;

import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationCompany;
import TransportationPkg.TransportationVehicle;
import AdminPkg.TransportationFactory;

public class AirFactory extends TransportationFactory {
	private AirFactory _instance;

	public TransportationHub createTransportationHub(String aName) {
		throw new UnsupportedOperationException();
	}

	public TransportationCompany createTransportCompany(String aName) {
		throw new UnsupportedOperationException();
	}

	public TransportationVehicle createTransportVehicle() {
		throw new UnsupportedOperationException();
	}

	private AirFactory getInstance() {
		return this._instance;
	}

	private AirFactory() {
		throw new UnsupportedOperationException();
	}
}