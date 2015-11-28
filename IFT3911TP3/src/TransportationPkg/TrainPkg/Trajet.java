package TransportationPkg.TrainPkg;

import java.util.Vector;

import TransportationPkg.TrainPkg.ItineraryItem;
import TransportationPkg.ISearchable;
import AdminPkg.ITripVisitor;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.TripGeneral;

public class Trajet extends TripGeneral {
	public Vector<ItineraryItem> _itineraryItems = new Vector<ItineraryItem>();


}
