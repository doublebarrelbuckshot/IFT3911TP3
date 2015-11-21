package TransportationPkg;

import ReservationPkg.Passager;
import CommonComponentsPkg.SearchCriteria;

public class InstanceSeat extends GenericSeat {
	public PermanentSeat _physicalSeat;
	public IPassenger _passenger;
	public Passager _unnamed_Passager_;

	public ISearchable find(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}
}