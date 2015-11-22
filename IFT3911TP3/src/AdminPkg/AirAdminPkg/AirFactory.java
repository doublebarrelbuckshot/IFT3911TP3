package AdminPkg.AirAdminPkg;

import java.util.Date;

import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationCompany;
import TransportationPkg.TransportationVehicle;
import TransportationPkg.TripGeneral;
import TransportationPkg.AviationPkg.Aeroport;
import TransportationPkg.AviationPkg.Avion;
import TransportationPkg.AviationPkg.CompagnieAerienne;
import TransportationPkg.AviationPkg.Vol;
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

	public TripGeneral createTripGeneral(Date dateDepart, Date dateArrival, String tripID, TransportationHub depart, TransportationHub arrive ){
		Vol v = new Vol();
		v.set_heureArrive(dateArrival);
		v.set_heureDepart(dateDepart);
		v.set_tripID(tripID);
		v.set_hubArrival(arrive);
		v.set_hubDeparture(depart);
		return v;
	}
	public static AirFactory getInstance() {
		if (_instance == null)
			_instance = new AirFactory();
		
		return _instance;
	}

	private AirFactory() {
		
	}
}