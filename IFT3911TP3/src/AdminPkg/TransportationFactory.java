package AdminPkg;

import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationCompany;
import TransportationPkg.TransportationVehicle;

public abstract class TransportationFactory {
	public AdminManagement _unnamed_AdminManagement_;

	public TransportationHub createTransportationHub(String aName) {
		throw new UnsupportedOperationException();
	}

	public TransportationCompany createTransportCompany(String aName) {
		throw new UnsupportedOperationException();
	}

	public TransportationVehicle createTransportVehicle() {
		throw new UnsupportedOperationException();
	}
}