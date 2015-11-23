package AdminPkg;

import java.util.Date;

import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationCompany;
import TransportationPkg.TransportationVehicle;
import TransportationPkg.TripGeneral;
import TransportationPkg.TripInstance;

public abstract class TransportationFactory {
	public AdminManagement _unnamed_AdminManagement_;

	public TransportationHub createTransportationHub(String aName, String id) {
		throw new UnsupportedOperationException();
	}

	public TransportationCompany createTransportCompany(String aName, String id) {
		throw new UnsupportedOperationException();
	}

	public TransportationVehicle createTransportVehicle(int capacity, String manufacturer, TransportationCompany company) {
		throw new UnsupportedOperationException();
	}
	
	public TripGeneral createTripGeneral(Date dateDepart, Date dateArrival, String tripID, TransportationHub depart, TransportationHub arrive ){
		throw new UnsupportedOperationException();
	}
	
	public TripInstance createTripInstance(Date dateDepart, Date dateArrival, int tripInstanceID, double price )
	{
		throw new UnsupportedOperationException();
	}
}