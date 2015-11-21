package ReservationPkg;

import TransportationPkg.TripInstance;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.InstanceSeat;
import TransportationPkg.GenericSeat;

public interface IClientUI {

	public TripInstance findTripInstance(SearchCriteria aSc);

	public InstanceSeat findSeat(SearchCriteria aSc);

	public GenericSeat findGenericSeat(SearchCriteria aSc);

	public int getOrderChangeDeadline(SearchCriteria aSc);

	public void showAlert(String aAlert);
}