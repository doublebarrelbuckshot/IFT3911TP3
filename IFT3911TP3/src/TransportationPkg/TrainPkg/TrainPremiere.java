package TransportationPkg.TrainPkg;

import TransportationPkg.ISearchable;
import TransportationPkg.ITripVisitable;
import AdminPkg.ITripVisitor;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.ComfortClass;
import TransportationPkg.CroisierePkg.Suite;

public class TrainPremiere extends ComfortClass implements ITripVisitable{
	private double _prixPercent = 1.0;

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