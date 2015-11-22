package TransportationPkg.CroisierePkg;

import TransportationPkg.PermanentSeat;

public class PhysicalCabine extends PermanentSeat {

	String roomIdentifier;

	public String getRoomIdentifier() {
		return roomIdentifier;
	}

	public void setRoomIdentifier(String roomIdentifier) {
		this.roomIdentifier = roomIdentifier;
	}
	
	
}