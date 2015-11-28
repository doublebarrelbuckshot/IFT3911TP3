package ReservationPkg;

import TransportationPkg.TripInstance;
import TransportationPkg.IOrder;

public class Order implements IOrder {
	private boolean _isActive;
	private static int orderNumber = 0;
	private int _number;
	private Client client;
	private TripInstance _tripInstance;


	public Order(boolean isActive, Client client, TripInstance tripInstance){
		_isActive = isActive;
		_number = getOrderNumber();
		client = client;
		_tripInstance = tripInstance;
	}
	
	public Order(){
		
	}
	
	public int getOrderNumber()
	{
		orderNumber++;
		return orderNumber;
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

	public Client get_unnamed_Client_() {
		return client;
	}

	public void set_unnamed_Client_(Client _unnamed_Client_) {
		this.client = _unnamed_Client_;
	}

	public TripInstance get_tripInstance() {
		return _tripInstance;
	}
}