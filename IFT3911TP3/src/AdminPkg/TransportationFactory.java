package AdminPkg;

import java.util.Date;

import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationCompany;
import TransportationPkg.TransportationVehicle;
import TransportationPkg.TripGeneral;

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
	
	public TripGeneral createTripGeneral(Date dateDepart, Date dateArrival, String tripID, TransportationHub depart, TransportationHub arrive ){
		throw new UnsupportedOperationException();
	}
}