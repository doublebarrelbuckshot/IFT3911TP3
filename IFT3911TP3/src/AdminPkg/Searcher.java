package AdminPkg;

import java.util.Vector;

import AdminPkg.Searcher;
import ClientPkg.SystemeClient;
import TransportationPkg.TripInstance;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.InstanceSeat;
import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationCompany;
import TransportationPkg.TransportationVehicle;
import TransportationPkg.TripGeneral;
import TransportationPkg.GenericSeat;

public abstract class Searcher {
	protected AdminPkg.Searcher _instance;
	public SystemeClient _unnamed_SystemeClient_;
	private TransportationManager transportationManager = TransportationManager.getInstance();

	public TripInstance findTripInstance(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public InstanceSeat findSeat(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public Vector<TransportationHub> findTransportationHub(SearchCriteria aSc) {
		Vector<TransportationHub> listTptHubs = transportationManager.get_listTptHubs();
		Vector<TransportationHub> foundTptHubs = new Vector<TransportationHub>();
		for(TransportationHub hub : listTptHubs){
			if(hub.matchCriteria(aSc)){
				foundTptHubs.add(hub);
			}
		}
		return foundTptHubs;
	}

	public Vector<TransportationCompany> findTransportCompany(SearchCriteria aSc) {
		Vector<TransportationCompany> listTptCompanies = transportationManager.get_listTptCompanies();
		Vector<TransportationCompany> foundTptCompanies = new Vector<TransportationCompany>();
		for(TransportationCompany company : listTptCompanies){
			if (company.matchCriteria(aSc)){
				foundTptCompanies.addElement(company);
			}
		}
		return foundTptCompanies;
	}

//	public Vector<TransportationVehicle> findTransportationVehicle(SearchCriteria aSc) {
//		Vector<TransportationVehicle> listTptVehicles = transportationManager.get_listTransportationVehicles();
//		Vector<TransportationVehicle> foundTptVehicles = new Vector<TransportationVehicle>();
//		for(TransportationVehicle vehicle : listTptVehicles){
//			
//		}
//	}

	public TripGeneral findTripGeneral() {
		throw new UnsupportedOperationException();
	}

	public GenericSeat findGenericSeat(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public Searcher() {
		throw new UnsupportedOperationException();
	}

	public AdminPkg.Searcher getInstance() {
		return this._instance;
	}

	public int getOrderChangeDeadline(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public TransportationCompany findTransportationCompany(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}
}