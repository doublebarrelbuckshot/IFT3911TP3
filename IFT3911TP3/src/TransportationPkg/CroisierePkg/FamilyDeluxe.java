package TransportationPkg.CroisierePkg;

import TransportationPkg.ISearchable;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.ComfortClass;

public class FamilyDeluxe extends ComfortClass {
	private double _prixPercent = 1.00;

	public boolean matchCriteria(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public double getPricePercentage() {
		throw new UnsupportedOperationException();
	}
}