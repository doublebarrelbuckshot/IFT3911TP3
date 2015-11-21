package TransportationPkg;

public class ReservedState implements GenericSeatState {

	public void reserved(GenericSeat aS) {
		throw new UnsupportedOperationException();
	}

	public void available(GenericSeat aS) {
		throw new UnsupportedOperationException();
	}

	public void confirmed(GenericSeat aS) {
		throw new UnsupportedOperationException();
	}
}