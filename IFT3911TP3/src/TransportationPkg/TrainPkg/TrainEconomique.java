package TransportationPkg.TrainPkg;

import TransportationPkg.ISearchable;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.ComfortClass;

public class TrainEconomique extends ComfortClass {
	private double _prixPercent = 0.50;

	public boolean matchCriteria(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public double getPricePercentage() {
		throw new UnsupportedOperationException();
	}
}