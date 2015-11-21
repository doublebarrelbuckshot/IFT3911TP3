package AdminPkg.AirAdminPkg;

import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationCompany;
import TransportationPkg.TransportationVehicle;
import TransportationPkg.AviationPkg.Aeroport;
import TransportationPkg.AviationPkg.Avion;
import TransportationPkg.AviationPkg.CompagnieAerienne;
import AdminPkg.TransportationFactory;

public class AirFactory extends TransportationFactory {
	private static AirFactory _instance;

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
		Avion a = new Avion();
		return a;
	}

	public static AirFactory getInstance() {
		if (_instance == null)
			_instance = new AirFactory();
		
		return _instance;
	}

	private AirFactory() {
		
	}
}