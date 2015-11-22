package TransportationPkg;

import java.util.Vector;
import TransportationPkg.PermanentSeat;

public abstract class VehicleLayout {
	private static int idGenerator = 0;
	private int _capacity = 1;
	public TransportationVehicle tptVeh;
	
	public int get_capacity() {
		return _capacity;
	}

	public void set_capacity(int _capacity) {
		this._capacity = _capacity;
	}

	public TransportationVehicle getTptVeh() {
		return tptVeh;
	}

	public void setTptVeh(TransportationVehicle tptVeh) {
		this.tptVeh = tptVeh;
	}

	public Vector<PermanentSeat> get_seating() {
		return _seating;
	}

	public void set_seating(Vector<PermanentSeat> _seating) {
		this._seating = _seating;
	}

	public Vector<PermanentSeat> _seating = new Vector<PermanentSeat>();

	public void configureSeating() {
		for(int i =0; i<this.get_capacity(); i++)
		{
			PermanentSeat ps = addPhysSeat();
			assignSeatingLocation(ps, idGenerator);
			this._seating.add(ps);
			idGenerator++;
		}
	}

	public abstract void removePhysSeat(PermanentSeat aPs);

	protected abstract PermanentSeat addPhysSeat();

	protected abstract void assignSeatingLocation(PermanentSeat ps, int i);
	
	
}