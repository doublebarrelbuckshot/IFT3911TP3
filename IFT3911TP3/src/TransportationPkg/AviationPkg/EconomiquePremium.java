package TransportationPkg.AviationPkg;

import TransportationPkg.ISearchable;
import AdminPkg.ITripVisitor;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.ComfortClass;

public class EconomiquePremium extends ComfortClass {
	private double _prixPercent = 0.60;

	public boolean matchCriteria(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public double getPricePercentage() {
		return this._prixPercent;
	}

	@Override
	public void accept(ITripVisitor visitor) {
		visitor.visit(this);
		
	}
}