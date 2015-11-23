package AdminPkg.AirAdminPkg;

import java.util.Date;

import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationCompany;
import TransportationPkg.TransportationVehicle;
import TransportationPkg.TripGeneral;
import TransportationPkg.TripInstance;
import TransportationPkg.AviationPkg.Aeroport;
import TransportationPkg.AviationPkg.Avion;
import TransportationPkg.AviationPkg.CompagnieAerienne;
import TransportationPkg.AviationPkg.DescriptionVol;
import TransportationPkg.AviationPkg.Vol;
import AdminPkg.TransportationFactory;

public class AirFactory extends TransportationFactory {
	private static AirFactory _instance;

	public TransportationHub createTransportationHub(String aName, String id) {
		Aeroport a = new Aeroport();
		a.set_name(aName);
		a.set_id(id);
		return a;
		
	}

	
	public TransportationCompany createTransportCompany(String aName, String id) {
		CompagnieAerienne ca = new CompagnieAerienne();
		ca.set_id(id);
		ca.set_name(aName);
		return ca;
	}

	public TransportationVehicle createTransportVehicle(int capacity, String manufacturer, TransportationCompany company) {
		Avion a = new Avion();
		a.set_capaciteMax(capacity);
		a.set_manufacturer(manufacturer);
		a.setTptCompany(company);
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
	
	public TripInstance createTripInstance(Date dateDepart, Date dateArrival, int tripInstanceID, double price )
	{
		DescriptionVol dv = new DescriptionVol();
		dv.set_dateDepart(dateDepart);
		dv.set_dateArrive(dateArrival);
		dv.set_tripInstanceID(tripInstanceID);
		dv.set_fullPrice(price);
		return dv;
	}
	
	public static AirFactory getInstance() {
		if (_instance == null)
			_instance = new AirFactory();
		
		return _instance;
	}

	private AirFactory() {
		
	}
}