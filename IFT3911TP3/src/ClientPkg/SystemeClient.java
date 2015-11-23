package ClientPkg;

import java.util.Vector;

import AdminPkg.AdminManagement;
import AdminPkg.AdminTripVisitor;
import AdminPkg.Searcher;
import AdminPkg.TransportationManager;
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
		ClientTripVisitor visitor = new ClientTripVisitor();
	/*	TransportationManager tm = TransportationManager.getInstance();
		Vector<TripGeneral> listTrip = tm.get_listTripGenerals();
		
		for(TripGeneral tripG : listTrip){
			for(TripInstance instance : tripG.get_tripInstances()){
				
				for(ComfortClass cc : instance.get_comfortClasses()){
					if(cc.getComfortClassType() == aSc.get_sectionType()){
						instance.accept(visitor);
						cc.accept(visitor);
					}
				}
			}
		}
		System.out.println(visitor.getResult());*/
		return visitor.getResult();
	}

	public InstanceSeat findSeat(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public GenericSeat findGenericSeat(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public int getOrderChangeDeadline(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}
}