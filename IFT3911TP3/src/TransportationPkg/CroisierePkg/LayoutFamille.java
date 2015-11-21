package TransportationPkg.CroisierePkg;

import TransportationPkg.PermanentSeat;
import TransportationPkg.VehicleLayout;

public class LayoutFamille extends VehicleLayout {
	private int _capacity = 6;

	public void removePhysSeat(PermanentSeat aPs) {
		throw new UnsupportedOperationException();
	}

	protected void addPhysSeat() {
		throw new UnsupportedOperationException();
	}

	protected void assignSeatingLocation() {
		throw new UnsupportedOperationException();
	}
}