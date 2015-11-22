package TransportationPkg.CroisierePkg;

import TransportationPkg.PermanentSeat;
import TransportationPkg.VehicleLayout;

public class LayoutInterior extends VehicleLayout {
	private int _capacity = 4;

	public int get_capacity() {
		return _capacity;
	}
	
	public void removePhysSeat(PermanentSeat aPs) {
		throw new UnsupportedOperationException();
	}

	protected  PermanentSeat addPhysSeat(){
		PhysicalCabine aps = new PhysicalCabine();
		return aps;
	}

	protected void assignSeatingLocation(PermanentSeat ps, int i) {
		PhysicalCabine aps = (PhysicalCabine)ps;
		aps.setRoomIdentifier("I" + i);
	}
}