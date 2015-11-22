package TransportationPkg.AviationPkg;

import AdminPkg.ITripVisitor;
import TransportationPkg.ComfortClass;
import TransportationPkg.TripInstance;

public class DescriptionVol extends TripInstance {

	public void addComfortClass() {
		throw new UnsupportedOperationException();
	}

	public void removeComfortClass(ComfortClass aCc) {
		throw new UnsupportedOperationException();
	}
	
	public void accept(ITripVisitor visitor){
		visitor.visit(this);
	}
}