package TransportationPkg.CroisierePkg;

import java.time.Period;
import java.util.Vector;

import TransportationPkg.CroisierePkg.ItineraryItem;
import TransportationPkg.ISearchable;
import AdminPkg.ITripVisitor;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.TripGeneral;

public class Croisiere extends TripGeneral {
	public Vector<ItineraryItem> _itineraryItem = new Vector<ItineraryItem>();

	public Period getDuree() {
		throw new UnsupportedOperationException();
	}

	public void addItineraryItem(ItineraryItem ii)
	{
		_itineraryItem.add(ii);
	}
	public void removeItinaryItem(ItineraryItem ii)
	{
		_itineraryItem.remove(ii);
		
	}

}
