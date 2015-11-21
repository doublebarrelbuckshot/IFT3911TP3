package TransportationPkg;

import java.time.Period;
import java.util.Date;
import java.util.Vector;

import TransportationPkg.TripInstance;

public abstract class TripGeneral implements ISearchable {
	protected Date _heureDepart;
	protected String _tripID;
	protected Date _heureArrive;
	public TransportationHub _hubDeparture;
	public TransportationCompany _unnamed_TransportationCompany_;
	public Vector<TripInstance> _tripInstances = new Vector<TripInstance>();
	public TransportationHub _hubArrival;

	public void addTripInstance() {
		throw new UnsupportedOperationException();
	}

	public boolean referencesTptHub(TransportationHub aA) {
		throw new UnsupportedOperationException();
	}

	public Period getDuree() {
		throw new UnsupportedOperationException();
	}

	public Date changeDepartTime(Date aD) {
		throw new UnsupportedOperationException();
	}

	public Date changeArriveTime(Date aD) {
		throw new UnsupportedOperationException();
	}
}