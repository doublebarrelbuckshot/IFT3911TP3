package TransportationPkg.TrainPkg;

import AdminPkg.ITripVisitor;
import TransportationPkg.ComfortClass;
import TransportationPkg.TripInstance;

public class DescriptionTrajet extends TripInstance {

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