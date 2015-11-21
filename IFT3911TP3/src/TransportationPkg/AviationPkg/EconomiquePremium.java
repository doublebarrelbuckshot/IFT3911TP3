package TransportationPkg.AviationPkg;

import TransportationPkg.ISearchable;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.ComfortClass;

public class EconomiquePremium extends ComfortClass {
	private double _prixPercent = 0.60;

	public ISearchable find(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public double getPricePercentage() {
		throw new UnsupportedOperationException();
	}
}