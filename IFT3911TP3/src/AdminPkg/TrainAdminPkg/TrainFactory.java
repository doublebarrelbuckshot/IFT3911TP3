package AdminPkg.TrainAdminPkg;

import java.util.Date;

import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationCompany;
import TransportationPkg.TransportationVehicle;
import TransportationPkg.TripGeneral;
import TransportationPkg.TripInstance;
import TransportationPkg.AviationPkg.DescriptionVol;
import TransportationPkg.CroisierePkg.Croisiere;
import TransportationPkg.TrainPkg.DescriptionTrajet;
import TransportationPkg.TrainPkg.Gare;
import TransportationPkg.TrainPkg.LigneTrain;
import TransportationPkg.TrainPkg.Train;
import TransportationPkg.TrainPkg.Trajet;
import AdminPkg.TransportationFactory;

public class TrainFactory extends TransportationFactory {
	private static TrainFactory _instance;

	public TransportationHub createTransportationHub(String aName, String id) {
		Gare g = new Gare();
		g.set_name(aName);
		g.set_id(id);
		return g;
	}

	public TransportationCompany createTransportCompany(String aName, String id) {
		LigneTrain lt = new LigneTrain();
		lt.set_name(aName);
		lt.set_id(id);
		return lt;
	}

	public TransportationVehicle createTransportVehicle(int capacity, String manufacturer, TransportationCompany company) {
		Train t = new Train();
		t.set_capaciteMax(capacity);
		t.set_manufacturer(manufacturer);
		t.setTptCompany(company);
		return t;
		
	}

	public TripInstance createTripInstance(Date dateDepart, Date dateArrival, int tripInstanceID, double price )
	{
		DescriptionTrajet dv = new DescriptionTrajet();
		dv.set_dateDepart(dateDepart);
		dv.set_dateArrive(dateArrival);
		dv.set_tripInstanceID(tripInstanceID);
		dv.set_fullPrice(price);
		return dv;
	}
	public static TrainFactory getInstance() {
		if (_instance == null)
			_instance = new TrainFactory();
		return _instance;
	}
	public TripGeneral createTripGeneral(Date dateDepart, Date dateArrival, String tripID, TransportationHub depart, TransportationHub arrive ){
		Trajet t = new Trajet();
		t.set_heureArrive(dateArrival);
		t.set_heureDepart(dateDepart);
		t.set_tripID(tripID);
		t.set_hubArrival(arrive);
		t.set_hubDeparture(depart);
		return t;	
		}	


	private TrainFactory() {
	}
}