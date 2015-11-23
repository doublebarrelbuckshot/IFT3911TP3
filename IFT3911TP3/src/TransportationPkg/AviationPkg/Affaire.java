package TransportationPkg.AviationPkg;

import java.util.Vector;

import TransportationPkg.GenericSeat;
import TransportationPkg.ISearchable;
import TransportationPkg.ITripVisitable;
import TransportationPkg.ReservedState;
import AdminPkg.ITripVisitor;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.ComfortClass;

public class Affaire extends ComfortClass {
	private double _prixPercent = 0.75;

	public boolean matchCriteria(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public double getPricePercentage() {
		return _prixPercent;
	}

	@Override
	public void accept(ITripVisitor visitor) {
		visitor.visit(this);
	}
}