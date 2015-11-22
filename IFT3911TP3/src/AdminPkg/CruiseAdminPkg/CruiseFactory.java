package AdminPkg.CruiseAdminPkg;

import java.util.Date;

import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationCompany;
import TransportationPkg.TransportationVehicle;
import TransportationPkg.TripGeneral;
import TransportationPkg.TripInstance;
import TransportationPkg.AviationPkg.Vol;
import TransportationPkg.CroisierePkg.CompagnieCroisiere;
import TransportationPkg.CroisierePkg.Croisiere;
import TransportationPkg.CroisierePkg.Paquebot;
import TransportationPkg.CroisierePkg.Port;
import AdminPkg.TransportationFactory;

public class CruiseFactory extends TransportationFactory {
	private static CruiseFactory _instance;

	public TransportationHub createTransportationHub(String aName) {
		Port p = new Port();
		p.set_name(aName);
		return p;
	}

	public TransportationCompany createTransportCompany(String aName) {
		CompagnieCroisiere c = new CompagnieCroisiere();
		c.set_name(aName);
		return c;
		
	}

	public TransportationVehicle createTransportVehicle(int capacity, String manufacturer, TransportationCompany company) {
		Paquebot p = new Paquebot();
		p.set_capaciteMax(capacity);
		p.set_manufacturer(manufacturer);
		p.setTptCompany(company);
		return p;
	}
	public TripGeneral createTripGeneral(Date dateDepart, Date dateArrival, String tripID, TransportationHub depart, TransportationHub arrive ){
		Croisiere c = new Croisiere();
		c.set_heureArrive(dateArrival);
		c.set_heureDepart(dateDepart);
		c.set_tripID(tripID);
		c.set_hubArrival(arrive);
		c.set_hubDeparture(depart);
		return c;	
		}

	public static CruiseFactory getInstance() {
		if(_instance == null)
			_instance = new CruiseFactory();
		return _instance;	
		}

	public TripInstance createTripInstance(Date dateDepart, Date dateArrival, int tripInstanceID, double price )
	{
		throw new UnsupportedOperationException();
	}
	private CruiseFactory() {

	}
}