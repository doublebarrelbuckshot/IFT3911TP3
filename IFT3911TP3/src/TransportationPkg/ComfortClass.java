package TransportationPkg;

import java.util.Vector;

import AdminPkg.ITripVisitor;
import CommonComponentsPkg.ComfortClassEnum;

public abstract class ComfortClass implements ISearchable, ITripVisitable {
	protected double _prixPercent;
	private ComfortClassEnum comfortClassType;
	public TripInstance _tripInstance;
	public Vector<GenericSeat> _seating = new Vector<GenericSeat>();
	
	public boolean hasAvailableSeats(){
		throw new UnsupportedOperationException();
	}
	public void addGS() {
		throw new UnsupportedOperationException();
	}

	public void removeGS(String aSeatLocation) {
		throw new UnsupportedOperationException();
	}

	public void addIS() {
		throw new UnsupportedOperationException();
	}

	public void removeRS(InstanceSeat aFS) {
		throw new UnsupportedOperationException();
	}

	public abstract double getPricePercentage();

	public double getFullPrice() {
		throw new UnsupportedOperationException();
	}

	public boolean hasAdjacentSeatingFor(int aNumTravellers) {
		throw new UnsupportedOperationException();
	}

	public ComfortClassEnum getComfortClassType() {
		return comfortClassType;
	}

	public void setComfortClassType(ComfortClassEnum comfortClassType) {
		this.comfortClassType = comfortClassType;
	}
	
	public Vector<GenericSeat> get_seating(){
		return _seating;
	}
	
	public abstract void accept(ITripVisitor visitor);
}