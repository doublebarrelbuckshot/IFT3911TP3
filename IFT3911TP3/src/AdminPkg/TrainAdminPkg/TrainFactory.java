package AdminPkg.TrainAdminPkg;

import java.util.Date;

import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationCompany;
import TransportationPkg.TransportationVehicle;
import TransportationPkg.TripGeneral;
import AdminPkg.TransportationFactory;

public class TrainFactory extends TransportationFactory {
	private TrainFactory _instance;

	public TransportationHub createTransportationHub(String aName) {
		throw new UnsupportedOperationException();
	}

	public TransportationCompany createTransportCompany(String aName) {
		throw new UnsupportedOperationException();
	}

	public TransportationVehicle createTransportVehicle() {
		throw new UnsupportedOperationException();
	}

	private TrainFactory getInstance() {
		return this._instance;
	}
	public TripGeneral createTripGeneral(Date dateDepart, Date dateArrival, String tripID, TransportationHub depart, TransportationHub arrive ){
		throw new UnsupportedOperationException();
	}


	private TrainFactory() {
		throw new UnsupportedOperationException();
	}
}