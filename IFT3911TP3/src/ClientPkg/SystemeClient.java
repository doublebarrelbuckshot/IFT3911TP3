package ClientPkg;

import java.util.ArrayList;
import java.util.Vector;

import AdminPkg.AdminManagement;
import AdminPkg.AdminTripVisitor;
import AdminPkg.Searcher;
import AdminPkg.TransportationManager;
import ReservationPkg.Client;
import ReservationPkg.Reservation;
import TransportationPkg.TripInstance;
import CommonComponentsPkg.ComfortClassEnum;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.ComfortClass;
import TransportationPkg.ITripVisitable;
import TransportationPkg.InstanceSeat;
import TransportationPkg.GenericSeat;
import TransportationPkg.TripGeneral;

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

	public GenericSeat findGenericSeat(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public int getOrderChangeDeadline(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}
	
	public void makeReservation(InstanceSeat seat, Client client){
		seat.get_state().reserved(seat);
		
		//client.addOrder(order);
		
	}
}