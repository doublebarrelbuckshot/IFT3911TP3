package AdminPkg.AirAdminPkg;

import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationCompany;
import TransportationPkg.TransportationVehicle;
import TransportationPkg.AviationPkg.Aeroport;
import TransportationPkg.AviationPkg.CompagnieAerienne;
import AdminPkg.TransportationFactory;

public class AirFactory extends TransportationFactory {
	private AirFactory _instance;

	public TransportationHub createTransportationHub(String aName) {
		Aeroport a = new Aeroport();
		a.set_name(aName);
		return a;
		
	}

	public TransportationCompany createTransportCompany(String aName) {
		CompagnieAerienne ca = new CompagnieAerienne();
		ca.set_name(aName);
		return ca;
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