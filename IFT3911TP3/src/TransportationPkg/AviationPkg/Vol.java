package TransportationPkg.AviationPkg;

import TransportationPkg.ISearchable;
import AdminPkg.ITripVisitor;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.TripGeneral;

public class Vol extends TripGeneral {

	public boolean matchCriteria(SearchCriteria aSc) {
		return super.matchCriteria(aSc);
	}

}
