package TransportationPkg;

public class ConfirmedState implements GenericSeatState {

	public void reserved(GenericSeat aS) {
		//impossible
	}

	public void available(GenericSeat aS) {
		aS.set_state(new AvailableState());
		
	}

	public void confirmed(GenericSeat aS) {
	//deja confirmer
	}
}