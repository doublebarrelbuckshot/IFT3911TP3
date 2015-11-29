package ClientPkg;

import java.util.Date;

import AdminPkg.AdminManagement;
import AdminPkg.Searcher;
import CommonComponentsPkg.ComfortClassEnum;
import CommonComponentsPkg.SearchCriteria;
import ReservationPkg.Client;
import ReservationPkg.Entity;
import ReservationPkg.Order;
import ReservationPkg.Reservation;
import TransportationPkg.GenericSeat;
import TransportationPkg.TripGeneral;
import TransportationPkg.TripInstance;

public class ClientSimulationData {

	public static Client client = new Client();
	
	public static void initClientSimulationData()
	{
		
		
		AdminManagement am = AdminManagement.getInstance();
/*
		SearchCriteria sc = new SearchCriteria();
		sc.set_tripIDNumber("YULJFK1030");
				dateDepart.setDate(Integer.parseInt(25);
				dateDepart.setMonth(Integer.parseInt(dateArray[1]) - 1);
				dateDepart.setYear(Integer.parseInt(dateArray[2]) - 1900);
				sc.set_tripDepartureDate(dateDepart);
			}
			if(!section.getText().isEmpty()){
				sc.set_sectionType(ComfortClassEnum.valueOf(section.getText().toUpperCase()));
			}
		GenericSeat seat = SystemeClient.getInstance().findGenericSeat(sc);
		
		String confirmation = SystemeClient.getInstance().makeReservation(seat, client);
		
		Order res1 = new Reservation(true, client, ti);
		client.addOrder(res1);
		
		

		*/
	}
}
