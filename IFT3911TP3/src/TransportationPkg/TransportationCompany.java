package TransportationPkg;

import CommonComponentsPkg.Adresse;
import AdminPkg.TransportationManager;
import java.util.Vector;
import TransportationPkg.TransportationVehicle;
import TransportationPkg.TripGeneral;

public abstract class TransportationCompany implements ISearchable {
	protected int _id;
	protected Adresse _adresse;
	protected String _name;
	public TransportationManager _unnamed_TransportationManager_;
	public Vector<TransportationVehicle> _tptVehicles = new Vector<TransportationVehicle>();
	public Vector<TripGeneral> _tripGenerals = new Vector<TripGeneral>();

	public void addTripGeneral(TransportationHub aThDepart, TransportationHub aThArrive) {
		throw new UnsupportedOperationException();
	}

	public void removeTripGeneral(TripGeneral aTg) {
		throw new UnsupportedOperationException();
	}

	public String rename(String aN) {
		throw new UnsupportedOperationException();
	}
}