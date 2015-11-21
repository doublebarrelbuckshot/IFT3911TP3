package AdminPkg;

import AdminPkg.Searcher;
import ClientPkg.SystemeClient;
import TransportationPkg.TripInstance;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.InstanceSeat;
import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationCompany;
import TransportationPkg.TransportationVehicle;
import TransportationPkg.TripGeneral;
import TransportationPkg.GenericSeat;

public abstract class Searcher {
	protected AdminPkg.Searcher _instance;
	public SystemeClient _unnamed_SystemeClient_;

	public TripInstance findTripInstance(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public InstanceSeat findSeat(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public TransportationHub findTransportationHub(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public TransportationCompany findTransportCompany(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public TransportationVehicle findTransportationVehicle(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public TripGeneral findTripGeneral() {
		throw new UnsupportedOperationException();
	}

	public GenericSeat findGenericSeat(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public Searcher() {
		throw new UnsupportedOperationException();
	}

	public AdminPkg.Searcher getInstance() {
		return this._instance;
	}

	public int getOrderChangeDeadline(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public TransportationCompany findTransportationCompany(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}
}