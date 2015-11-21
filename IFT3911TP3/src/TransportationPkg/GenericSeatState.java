package TransportationPkg;

public interface GenericSeatState {

	public void reserved(GenericSeat aS);

	public void available(GenericSeat aS);

	public void confirmed(GenericSeat aS);
}