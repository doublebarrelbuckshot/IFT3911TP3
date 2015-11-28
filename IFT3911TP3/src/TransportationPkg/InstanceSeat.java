package TransportationPkg;

import ReservationPkg.Passager;
import AdminPkg.ITripVisitor;
import CommonComponentsPkg.SearchCriteria;

public class InstanceSeat extends GenericSeat {
	private PermanentSeat _physicalSeat;
	
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

	public PermanentSeat get_physicalSeat() {
		return _physicalSeat;
	}

	public void set_physicalSeat(PermanentSeat _physicalSeat) {
		this._physicalSeat = _physicalSeat;
	}

}