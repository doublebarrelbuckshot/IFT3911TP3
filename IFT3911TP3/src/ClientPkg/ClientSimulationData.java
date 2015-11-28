package ClientPkg;

import AdminPkg.AdminManagement;
import AdminPkg.Searcher;
import CommonComponentsPkg.SearchCriteria;
import ReservationPkg.Client;
import ReservationPkg.Order;
import ReservationPkg.Reservation;
import TransportationPkg.TripGeneral;
import TransportationPkg.TripInstance;

public class ClientSimulationData {

	public static Client client = new Client();
	
	public static void initClientSimulationData()
	{
		Order res1 = new Reservation();
		
		AdminManagement am = AdminManagement.getInstance();

		SearchCriteria criteria = new SearchCriteria();
		criteria.set_tripIDNumber("YULJFK1030");
		Searcher searcher = Searcher.getInstance();
		TripGeneral tripGeneral = searcher.findOneTripGeneral(criteria);
		TripInstance ti = tripGeneral.get_tripInstances().get(0);
		
		
	}
}
