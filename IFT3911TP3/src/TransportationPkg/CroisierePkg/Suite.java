package TransportationPkg.CroisierePkg;

import TransportationPkg.ISearchable;
import AdminPkg.ITripVisitor;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.ComfortClass;

public class Suite extends ComfortClass {
	private double _prixPercent = 0.90;

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