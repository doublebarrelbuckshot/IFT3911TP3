package TransportationPkg;

import CommonComponentsPkg.SearchCriteria;

public interface ISearchable<sc extends SearchCriteria> {

	public ISearchable find(SearchCriteria aSc);
}