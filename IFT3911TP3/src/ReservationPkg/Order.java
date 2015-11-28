package ReservationPkg;

import TransportationPkg.TripInstance;
import TransportationPkg.IOrder;

public class Order implements IOrder {
	private boolean _isActive;
	private int _number;
	private Client client;
	private TripInstance _tripInstance;


	public Order(boolean isActive, int number, Client client, TripInstance tripInstance){
		_isActive = isActive;
		_number = number;
		client = client;
		_tripInstance = tripInstance;
	}
	
	public Order(){
		
	}
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
	

	public boolean is_isActive() {
		return _isActive;
	}

	public void set_isActive(boolean _isActive) {
		this._isActive = _isActive;
	}

	public int get_number() {
		return _number;
	}

	public void set_number(int _number) {
		this._number = _number;
	}

	public Client get_client() {
		return client;
	}

	public void set_client_(Client cient) {
		this.client = client;
	}

	public TripInstance get_tripInstance() {
		return _tripInstance;
	}
}