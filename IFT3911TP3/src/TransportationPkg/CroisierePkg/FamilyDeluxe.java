package TransportationPkg.CroisierePkg;

import TransportationPkg.ISearchable;
import AdminPkg.ITripVisitor;
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

	@Override
	public void accept(ITripVisitor visitor) {
		// TODO Auto-generated method stub
		
	}
}