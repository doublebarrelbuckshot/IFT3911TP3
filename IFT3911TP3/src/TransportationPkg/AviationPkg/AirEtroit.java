package TransportationPkg.AviationPkg;

import TransportationPkg.PermanentSeat;
import TransportationPkg.VehicleLayout;

public class AirEtroit extends VehicleLayout {

	public void removePhysSeat(PermanentSeat aPs) {
		throw new UnsupportedOperationException();
	}

	protected  PermanentSeat addPhysSeat(){
		AirPhysicalSeat aps = new AirPhysicalSeat();
		return aps;
	}

	protected void assignSeatingLocation(PermanentSeat ps, int i) {
		AirPhysicalSeat aps = (AirPhysicalSeat)ps;
		aps.set_columnLetter("AE_" + assignColLetter(i));
		aps.set_rowNumber(i/4);
		
	}
	
	public String assignColLetter(int i)
	{
		String result = "";
		if(i%4 == 0)
			return "A";
		if(i%4 == 1)
			return "B";
		if(i%4 == 2)
			return "C";
		if(i%4 == 3)
			return "D";
		return "E";		
	}
}