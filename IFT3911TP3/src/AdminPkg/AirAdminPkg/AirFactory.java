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
import CommonComponentsPkg.GenerateurConfirmation;

public class AirFactory extends TransportationFactory {
	private static AirFactory _instance;
	public static int idGenerator = 1000;
	

	public int getNewId()
	{
		idGenerator++;
		return idGenerator;
	}
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

	public TripGeneral createTripGeneral(Date dateDepart, Date dateArrival, TransportationCompany company, TransportationHub depart, TransportationHub arrive ){
		Vol v = new Vol();
		v.setTptCompany(company);
		v.set_heureArrive(dateArrival);
		v.set_heureDepart(dateDepart);
		v.set_tripID(company.get_name().substring(0, 2).toUpperCase() + GenerateurConfirmation.getInstance().get_numeroConfirmation());
		v.set_hubArrival(arrive);
		v.set_hubDeparture(depart);
		
		return v;
	}
	
	public TripInstance createTripInstance(Date dateDepart, Date dateArrival, double price )
	{
		DescriptionVol dv = new DescriptionVol();
		dv.set_dateDepart(dateDepart);
		dv.set_dateArrive(dateArrival);
		dv.set_tripInstanceID(getNewId());
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