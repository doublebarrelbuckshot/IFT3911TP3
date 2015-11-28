package ReservationPkg;

import TransportationPkg.TripInstance;
import TransportationPkg.IOrder;

public class Order implements IOrder {
	private boolean _isActive;
	private int _number;
	private Client _unnamed_Client_;
	private TripInstance _tripInstance;

	public void cancelOrder() {
		throw new UnsupportedOperationException();
	}

	public Passager changeTripInstance(TripInstance aNewTI) {
		throw new UnsupportedOperationException();
	}

	public void getOrder() {
		throw new UnsupportedOperationException();
	}
	public void set_tripInstance(TripInstance trip){
		this._tripInstance = trip;
	}
}