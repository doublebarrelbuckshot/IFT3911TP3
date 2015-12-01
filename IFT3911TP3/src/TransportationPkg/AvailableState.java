package TransportationPkg;

public class AvailableState implements GenericSeatState {
	
	public void reserved(GenericSeat aS) {
		aS.set_state(new ReservedState());	
	}

	public void available(GenericSeat aS) {
	}

	public void confirmed(GenericSeat aS) {
	}
}