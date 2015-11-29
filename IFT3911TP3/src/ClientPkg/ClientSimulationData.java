package ClientPkg;

import java.util.Date;
import java.util.Vector;

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

		SearchCriteria sc = new SearchCriteria();
		sc.set_tripIDNumber("WE1001");
		Date dateDepart = new Date();
		dateDepart.setDate(6);
		dateDepart.setMonth(4 - 1);
		dateDepart.setYear(2016 - 1900);
		sc.set_tripDepartureDate(dateDepart);
		sc.set_sectionType(ComfortClassEnum.E); 
		for(int i=0; i<10; i++){
			sc.set_sectionType(ComfortClassEnum.E); 
			Vector<GenericSeat> seat = SystemeClient.getInstance().findGenericSeat(sc);
			String confirmation = SystemeClient.getInstance().makeReservation(seat,1, client);
			if(i%5 == 0)
			{
				sc.set_sectionType(ComfortClassEnum.A); 
				seat = SystemeClient.getInstance().findGenericSeat(sc);
				confirmation = SystemeClient.getInstance().makeReservation(seat,1, client);
			}
		}
		
		sc.set_tripIDNumber("WE1002");
		dateDepart.setDate(7);
		dateDepart.setMonth(4 - 1);
		dateDepart.setYear(2016 - 1900);
		for(int i=0; i<16; i++){
			sc.set_sectionType(ComfortClassEnum.E); 
			Vector<GenericSeat> seat = SystemeClient.getInstance().findGenericSeat(sc);
			String confirmation = SystemeClient.getInstance().makeReservation(seat,1, client);
			if(i%2 == 0)
			{
				sc.set_sectionType(ComfortClassEnum.A); 
				seat = SystemeClient.getInstance().findGenericSeat(sc);
				confirmation = SystemeClient.getInstance().makeReservation(seat,1, client);
			}
		}
		
		sc.set_tripIDNumber("WE1002");
		dateDepart.setDate(8);
		dateDepart.setMonth(4 - 1);
		dateDepart.setYear(2016 - 1900);
		for(int i=0; i<8; i++){
			sc.set_sectionType(ComfortClassEnum.E); 
			Vector<GenericSeat> seat = SystemeClient.getInstance().findGenericSeat(sc);
			String confirmation = SystemeClient.getInstance().makeReservation(seat,1, client);
			if(i%2 == 0)
			{
				sc.set_sectionType(ComfortClassEnum.A); 
				seat = SystemeClient.getInstance().findGenericSeat(sc);
				confirmation = SystemeClient.getInstance().makeReservation(seat,1, client);
			}
		}
		
		sc.set_tripIDNumber("WE1003");
		dateDepart.setDate(10);
		dateDepart.setMonth(4 - 1);
		dateDepart.setYear(2016 - 1900);
		for(int i=0; i<8; i++){
			sc.set_sectionType(ComfortClassEnum.E); 
			Vector<GenericSeat> seat = SystemeClient.getInstance().findGenericSeat(sc);
			String confirmation = SystemeClient.getInstance().makeReservation(seat,1, client);
			if(i%3 == 0)
			{
				sc.set_sectionType(ComfortClassEnum.A); 
				seat = SystemeClient.getInstance().findGenericSeat(sc);
				confirmation = SystemeClient.getInstance().makeReservation(seat,1, client);
			}
		}
		
		sc.set_tripIDNumber("WE1003");
		dateDepart.setDate(11);
		dateDepart.setMonth(4 - 1);
		dateDepart.setYear(2016 - 1900);
		for(int i=0; i<19; i++){
			sc.set_sectionType(ComfortClassEnum.E); 
			Vector<GenericSeat> seat = SystemeClient.getInstance().findGenericSeat(sc);
			String confirmation = SystemeClient.getInstance().makeReservation(seat,1, client);
			if(i%3 == 0)
			{
				sc.set_sectionType(ComfortClassEnum.A); 
				seat = SystemeClient.getInstance().findGenericSeat(sc);
				confirmation = SystemeClient.getInstance().makeReservation(seat,1, client);
			}
		}
		
		sc = new SearchCriteria();
		sc.set_tripIDNumber("AM1004");
		dateDepart = new Date();
		dateDepart.setDate(11);
		dateDepart.setMonth(3 - 1);
		dateDepart.setYear(2016 - 1900);
		sc.set_tripDepartureDate(dateDepart);
		sc.set_sectionType(ComfortClassEnum.F); 
		for(int i=0; i<73; i++){
			Vector<GenericSeat> seat = SystemeClient.getInstance().findGenericSeat(sc);
			String confirmation = SystemeClient.getInstance().makeReservation(seat,1, client);	
		}
		
		

	}
}
