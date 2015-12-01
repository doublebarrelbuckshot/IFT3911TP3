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
import TransportationPkg.GenericSeatState;
import TransportationPkg.InstanceSeat;
import TransportationPkg.ReservedState;
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
		double reservationPrice = 0;
		for(int i=0; i<nb; i++){
			seat.get(i).get_state().reserved(seat.get(i));
			seat.get(i).set_reservationDate(new Date());
			r.set_client_(client);
			r.addPassenger(PassagerNull.getInstance());
			r.set_tripInstance(seat.get(i).get_comfortClass().get_tripInstance());
			client.addOrder(r);
			r.addSeat(seat.get(i));
			seat.get(i).set_Ipassenger(new PassagerReal());
			reservationPrice += seat.get(i).getPrice();
			}
		r.setReservationPrice(reservationPrice);
		return r.get_number()+"";
	}
	
	public String cancelReservation(String numeroR,Client client){
		int numero ;
		
		try{
			numero=Integer.parseInt(numeroR);
		}catch(Exception e){
			return "not a valid reservation number";
		}
		String flag="Reservation " + numeroR + " is cancelled";
		
		Reservation r =client.findReservation(numero);
		if(r != null){
			for(GenericSeat seat: r.get_reservedSeats()){
				
				if(seat.get_state() instanceof ReservedState){
					seat.get_state().available(seat);
					flag = "Your reservation "+numeroR+" is canceled.";
				}
				else
					flag= "Your reservation "+numeroR+" cannot be canceled.";
				/*if(seat.isBeforeTime()){
					seat.get_state().available(seat);
				}
				else{
					//je remets les seats reserve si il y eu une erreur dans la reservation
					for(GenericSeat seatReserved: r.get_reservedSeats()){
						seatReserved.get_state().reserved(seatReserved);
					}
					valide = false;
					flag="Reservation can't be canceled, your trip will depart too soon. ";
					break;
				}*/
			}
			
			/*if(valide){
				client._listOrders.remove(r);
			}*/
		} else {
			flag = "Reservation with id " + numeroR + " not found";
		}
		return flag;
	}
}