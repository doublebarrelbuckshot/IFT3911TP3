package TransportationPkg;

public class ReservedState implements GenericSeatState {

	public void reserved(GenericSeat aS) {
	
	}

	public void available(GenericSeat aS) {
		aS.set_state( new AvailableState());
		
	}

	public void confirmed(GenericSeat aS) {
		
		aS.set_state( new ConfirmedState());
		
	}
	
}