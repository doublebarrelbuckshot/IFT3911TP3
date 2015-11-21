package TransportationPkg;

import ReservationPkg.Order;

import java.util.Date;
import java.util.Vector;

import TransportationPkg.ComfortClass;

public abstract class TripInstance {
	protected Date _dateDepart;
	protected double _fullPrice;
	protected int _tripInstanceID;
	protected Date _dateArrive;
	public Order _unnamed_Order_;
	public TripGeneral _tripDescription;
	public IOrder _listOrders;
	public Vector<ComfortClass> _comfortClasses = new Vector<ComfortClass>();
	public TransportationVehicle _tptVehicle;

	public GenericSeat getSeat(String aSl) {
		throw new UnsupportedOperationException();
	}

	public void addTptVehicle() {
		throw new UnsupportedOperationException();
	}

	public void removeTptVehicle(TransportationVehicle aTv) {
		throw new UnsupportedOperationException();
	}

	public void addComfortClass() {
		throw new UnsupportedOperationException();
	}

	public void removeComfortClass(ComfortClass aCc) {
		throw new UnsupportedOperationException();
	}

	public void addOrder(Order aO) {
		throw new UnsupportedOperationException();
	}

	public void removeOrder(int aOID) {
		throw new UnsupportedOperationException();
	}

	public void hasOrders() {
		throw new UnsupportedOperationException();
	}

	public double getFullPrice() {
		return this._fullPrice;
	}
}