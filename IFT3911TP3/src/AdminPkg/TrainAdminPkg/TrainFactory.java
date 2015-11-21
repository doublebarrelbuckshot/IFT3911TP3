package AdminPkg.TrainAdminPkg;

import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationCompany;
import TransportationPkg.TransportationVehicle;
import AdminPkg.TransportationFactory;

public class TrainFactory extends TransportationFactory {
	private TrainFactory _instance;

	public TransportationHub createTransportationHub(String aName) {
		throw new UnsupportedOperationException();
	}

	public TransportationCompany createTransportCompany(String aName) {
		throw new UnsupportedOperationException();
	}

	public TransportationVehicle createTransportVehicle() {
		throw new UnsupportedOperationException();
	}

	private TrainFactory getInstance() {
		return this._instance;
	}

	private TrainFactory() {
		throw new UnsupportedOperationException();
	}
}