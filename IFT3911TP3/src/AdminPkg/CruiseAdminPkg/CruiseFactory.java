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
import TransportationPkg.CroisierePkg.DescriptionCroisiere;
import TransportationPkg.CroisierePkg.Paquebot;
import TransportationPkg.CroisierePkg.Port;
import TransportationPkg.TrainPkg.DescriptionTrajet;
import AdminPkg.TransportationFactory;

public class CruiseFactory extends TransportationFactory {
	private static CruiseFactory _instance;
	public static int idGenerator = 3000;
	

	public int getNewId()
	{
		idGenerator++;
		return idGenerator;
	}
	
	public TransportationHub createTransportationHub(String aName, String id) {
		Port p = new Port();
		p.set_name(aName);
		p.set_id(id);
		return p;
	}
	

	public TransportationCompany createTransportCompany(String aName, String id) {
		CompagnieCroisiere c = new CompagnieCroisiere();
		c.set_name(aName);
		c.set_id(id);
		return c;
		
	}

	public TransportationVehicle createTransportVehicle(int capacity, String manufacturer, TransportationCompany company) {
		Paquebot p = new Paquebot();
		p.set_capaciteMax(capacity);
		p.set_manufacturer(manufacturer);
		p.setTptCompany(company);
		return p;
	}
	public TripGeneral createTripGeneral(Date dateDepart, Date dateArrival, TransportationHub depart, TransportationHub arrive ){
		Croisiere c = new Croisiere();
		c.set_heureArrive(dateArrival);
		c.set_heureDepart(dateDepart);
		c.set_tripID(depart.get_id() + arrive.get_id() + dateDepart.getHours()+ dateDepart.getMinutes());
		c.set_hubArrival(arrive);
		c.set_hubDeparture(depart);
		return c;	
		}

	public static CruiseFactory getInstance() {
		if(_instance == null)
			_instance = new CruiseFactory();
		return _instance;	
		}

	public TripInstance createTripInstance(Date dateDepart, Date dateArrival, double price )
	{
		DescriptionCroisiere dv = new DescriptionCroisiere();
		dv.set_dateDepart(dateDepart);
		dv.set_dateArrive(dateArrival);
		dv.set_tripInstanceID(getNewId());
		dv.set_fullPrice(price);
		return dv;	}
	private CruiseFactory() {

	}
}