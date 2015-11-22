package TransportationPkg.TrainPkg;

import TransportationPkg.ISearchable;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.ComfortClass;

public class TrainPremiere extends ComfortClass {
	private double _prixPercent = 1.0;

	public boolean matchCriteria(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public double getPricePercentage() {
		throw new UnsupportedOperationException();
	}
}