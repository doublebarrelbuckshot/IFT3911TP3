package TransportationPkg;

public class ConfirmedState extends GenericSeatState {
	public void reserved(GenericSeat aS) {
		
	}

	public void available(GenericSeat aS) {
		aS.set_state(new AvailableState());
				
	}

	public void confirmed(GenericSeat aS) {
		
	}
	
	
}