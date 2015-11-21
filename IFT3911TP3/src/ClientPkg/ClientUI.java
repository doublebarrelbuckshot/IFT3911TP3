package ClientPkg;

import TransportationPkg.TripInstance;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.InstanceSeat;
import TransportationPkg.GenericSeat;
import AdminPkg.Subject;
import ReservationPkg.IClientUI;
import AdminPkg.Observer;

public class ClientUI implements IClientUI, Observer {
	public SystemeClient _interacts;

	public TripInstance findTripInstance(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public InstanceSeat findSeat(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public GenericSeat findGenericSeat(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public int getOrderChangeDeadline(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public void showAlert(String aAlert) {
		throw new UnsupportedOperationException();
	}

	public void update(Subject aS) {
		throw new UnsupportedOperationException();
	}
}