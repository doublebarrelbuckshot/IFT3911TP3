package ClientPkg;

import java.util.Date;
import java.util.Vector;

import AdminPkg.AdminManagement;
import AdminPkg.Searcher;
import CommonComponentsPkg.Adresse;
import CommonComponentsPkg.ComfortClassEnum;
import CommonComponentsPkg.SearchCriteria;
import ReservationPkg.Client;
import ReservationPkg.Entity;
import ReservationPkg.Order;
import ReservationPkg.Person;
import ReservationPkg.Reservation;
import ReservationPkg.Sexe;
import TransportationPkg.GenericSeat;
import TransportationPkg.TripGeneral;
import TransportationPkg.TripInstance;

public class ClientSimulationData {

	private static Client client = new Client();
	
	public static Client getClient(){
		return client;
	}

	public static void initClientSimulationData()
	{


		AdminManagement am = AdminManagement.getInstance();

		Adresse a = new Adresse(123, "UdeM drive",
				"3303", "Montreal", "Quebec",
				"Canada", "H3M 2P5");

		Person p = new Person("5145551234", a , "syriani@iro.umontreal.ca",
				"Eugene", Sexe.Male, "Syriani");
		
		client._clientInfo = p;
		
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
