package TransportationPkg.TrainPkg;

import TransportationPkg.PermanentSeat;
import TransportationPkg.VehicleLayout;
import TransportationPkg.AviationPkg.AirPhysicalSeat;

public class TrainEtroit extends VehicleLayout {

	public void removePhysSeat(PermanentSeat aPs) {
		throw new UnsupportedOperationException();
	}

	protected PermanentSeat addPhysSeat(){
		TrainPhysicalSeat pfs = new TrainPhysicalSeat();
		return pfs;
	}

	protected void assignSeatingLocation(PermanentSeat ps, int i) {
		TrainPhysicalSeat tps = (TrainPhysicalSeat)ps;
		tps.set_columnLetter("E_" + assignColLetter(i));
		tps.set_rowNumber(i/4);
		
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