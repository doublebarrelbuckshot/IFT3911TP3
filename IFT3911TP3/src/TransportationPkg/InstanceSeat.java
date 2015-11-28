package TransportationPkg;

import ReservationPkg.Passager;
import AdminPkg.ITripVisitor;
import CommonComponentsPkg.SearchCriteria;

public class InstanceSeat extends GenericSeat {
	private PermanentSeat _physicalSeat;
	private IPassenger _Ipassenger;
	private Passager _passager;
	
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

	public IPassenger get_Ipassenger() {
		return _Ipassenger;
	}

	public void set_Ipassenger(IPassenger _Ipassenger) {
		this._Ipassenger = _Ipassenger;
	}

	public Passager get_passager() {
		return _passager;
	}

	public void set_passager(Passager _passager) {
		this._passager = _passager;
	}
}