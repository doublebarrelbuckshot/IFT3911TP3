package TransportationPkg.CroisierePkg;

import AdminPkg.ITripVisitor;
import TransportationPkg.ComfortClass;
import TransportationPkg.TripInstance;

public class DescriptionCroisiere extends TripInstance {

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