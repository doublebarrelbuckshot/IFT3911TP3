package TransportationPkg.CroisierePkg;

import TransportationPkg.ISearchable;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.ComfortClass;

public class Ocean extends ComfortClass {
	private double _prixPercent = 0.75;

	public boolean matchCriteria(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public double getPricePercentage() {
		throw new UnsupportedOperationException();
	}
}