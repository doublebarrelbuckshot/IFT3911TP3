package TransportationPkg;

import ReservationPkg.Passager;
import AdminPkg.ITripVisitor;
import CommonComponentsPkg.SearchCriteria;

public class InstanceSeat extends GenericSeat {
	public PermanentSeat _physicalSeat;
	public IPassenger _Ipassenger;
	public Passager _passager;
	
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