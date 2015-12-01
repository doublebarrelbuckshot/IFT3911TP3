package ClientPkg;

import java.util.Date;
import java.util.Vector;

import AdminPkg.Searcher;
import CommonComponentsPkg.SearchCriteria;
import ReservationPkg.Client;
import ReservationPkg.PassagerNull;
import ReservationPkg.PassagerReal;
import ReservationPkg.Reservation;
import TransportationPkg.ComfortClass;
import TransportationPkg.GenericSeat;
import TransportationPkg.InstanceSeat;
import TransportationPkg.TripInstance;

public class SystemeClient {
	private static SystemeClient _instance;
	public Searcher _searcher;
	public ClientUI _interacts;

	public static SystemeClient getInstance()
	{
		if(_instance == null)
			_instance = new SystemeClient();
		return _instance;
	}
	private SystemeClient() {
		
		
	}

	public String findTripInstance(SearchCriteria aSc) {
		Vector<TripInstance> list =Searcher.getInstance().findTripInstances(aSc);
		ClientTripVisitor visitor = new ClientTripVisitor();
		
		
			for(TripInstance instance : list){
				
				for(ComfortClass cc : instance.get_comfortClasses()){
					if(cc.getComfortClassType() == aSc.get_sectionType()){
						instance.accept(visitor);
						cc.accept(visitor);
					}
				}
			}
		
		return visitor.getResult();
	}

	public InstanceSeat findSeat(SearchCriteria aSc) {
		Searcher.getInstance().findSeat(aSc);
		
		return new InstanceSeat();
	}

	public Vector<GenericSeat> findGenericSeat(SearchCriteria aSc) {
		Vector<GenericSeat> seat = new Vector<GenericSeat>();
		try {
			seat = Searcher.getInstance().findGenericSeat(aSc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seat;
	
	}

	public int getOrderChangeDeadline(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}
	
	public String makeReservation(Vector<GenericSeat> seat,int nb, Client client){
		Reservation r = new Reservation();
		for(int i=0; i<nb; i++){
			seat.get(i).get_state().reserved(seat.get(i));
			seat.get(i).set_reservationDate(new Date());
			r.set_client_(client);
			r.addPassenger(PassagerNull.getInstance());
			r.set_tripInstance(seat.get(i).get_comfortClass().get_tripInstance());
			client.addOrder(r);
			r.addSeat(seat.get(i));
			seat.get(i).set_Ipassenger(new PassagerReal());
			}
		return r.get_number()+"";
	}
	
	public String cancelReservation(String numeroR,Client client){
		int numero ;
		
		try{
			numero=Integer.parseInt(numeroR);
		}catch(Exception e){
			return "not a valid reservation number";
		}
		String flag="";
		boolean valide =false;
		Reservation r =client.findReservation(numero);
		
		for(GenericSeat seat: r._reservedSeats){
			if(seat.isBeforeTime()){
				valide = true;
				seat.get_state().available(seat);
				flag = "Reservation is canceled";
			}
			else
				flag="Reservation can't be canceled";
		}
		
		if(valide){
			
			//remboursement du prix -10%
		}
		
		return flag;
	}
}