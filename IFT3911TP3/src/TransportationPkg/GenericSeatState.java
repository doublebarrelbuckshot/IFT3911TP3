package TransportationPkg;

public interface GenericSeatState {
	
	
	public abstract void reserved(GenericSeat aS);

	public abstract void available(GenericSeat aS);

	public abstract void confirmed(GenericSeat aS);
	
}