package TransportationPkg;

public class ReservedState implements GenericSeatState {

	public void reserved(GenericSeat aS) {
		//deja reserved
	}

	public void available(GenericSeat aS) {
		//annulation
		//desasigner le seat du client
		aS.set_state( new AvailableState());
	}

	public void confirmed(GenericSeat aS) {
		//effectuer un paiement
		aS.set_state( new ConfirmedState());
	}
}