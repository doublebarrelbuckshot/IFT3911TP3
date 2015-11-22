package TransportationPkg;

import CommonComponentsPkg.SearchCriteria;

public interface ISearchable {

	public boolean matchCriteria(SearchCriteria aSc);
}