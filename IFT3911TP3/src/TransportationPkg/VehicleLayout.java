package TransportationPkg;

import java.util.Vector;
import TransportationPkg.PermanentSeat;

public abstract class VehicleLayout {
	private int _capacity;
	public TransportationVehicle _unnamed_TransportationVehicle_;
	public Vector<PermanentSeat> _seating = new Vector<PermanentSeat>();

	public void configureSeating() {
		throw new UnsupportedOperationException();
	}

	public abstract void removePhysSeat(PermanentSeat aPs);

	protected abstract void addPhysSeat();

	protected abstract void assignSeatingLocation();
}