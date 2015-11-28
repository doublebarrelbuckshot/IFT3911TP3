package TransportationPkg;

import ReservationPkg.Passager;
import AdminPkg.ITripVisitor;
import CommonComponentsPkg.SearchCriteria;

public class InstanceSeat extends GenericSeat {
	public PermanentSeat _physicalSeat;
	public IPassenger _passenger;
	public Passager _unnamed_Passager_;
	
	public InstanceSeat(){
		this._state= new AvailableState();
	}
	
	public boolean matchCriteria(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void accept(ITripVisitor visitor) {
		visitor.visit(this);
		
	}
}