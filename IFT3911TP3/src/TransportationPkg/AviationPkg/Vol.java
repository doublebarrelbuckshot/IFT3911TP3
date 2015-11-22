package TransportationPkg.AviationPkg;

import TransportationPkg.ISearchable;
import AdminPkg.ITripVisitor;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.TripGeneral;

public class Vol extends TripGeneral {

	public boolean matchCriteria(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void accept(ITripVisitor visitor ) {
		// TODO Auto-generated method stub
		
	}
}
