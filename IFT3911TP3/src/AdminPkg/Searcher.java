package AdminPkg;

import java.util.Vector;

import ClientPkg.SystemeClient;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.GenericSeat;
import TransportationPkg.ISearchable;
import TransportationPkg.InstanceSeat;
import TransportationPkg.TransportationCompany;
import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationVehicle;
import TransportationPkg.TripGeneral;
import TransportationPkg.TripInstance;

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

	public Vector<TransportationVehicle> findTransportationVehicle(SearchCriteria aSc) {
		Vector<TransportationCompany> listTptCompanies = transportationManager.get_listTptCompanies();
		Vector<TransportationVehicle> foundVehicles = new Vector<TransportationVehicle>();
		for(TransportationCompany company : listTptCompanies){
			for(TransportationVehicle vehicle : company.get_tptVehicles()){
				if(vehicle.matchCriteria(aSc)){
					foundVehicles.add(vehicle);
				}
			}
		}
		return foundVehicles;
	}
	
	public Vector<TripGeneral> findTripGeneral(SearchCriteria aSc) {
		Vector<ISearchable> listSearchable = transportationManager.get_listSearchable();
		Vector<TripGeneral> foundTripGenerals = new Vector<TripGeneral>(); 
		for(ISearchable searchable : listSearchable){
			if(searchable instanceof TripGeneral){
				if (searchable.matchCriteria(aSc)){
					foundTripGenerals.addElement((TripGeneral)searchable);
				}
			}
		}
		return foundTripGenerals;
	}
	public Vector<TripInstance> findTripInstances(SearchCriteria aSc) {
		Vector<TripGeneral> listTripGeneral = findTripGeneral(aSc);
		Vector<TripInstance> foundTripInstances = new Vector<TripInstance>(); 
		for(TripGeneral tripGeneral : listTripGeneral){
			for (TripInstance tripInstance: tripGeneral.get_tripInstances()){
				if(tripInstance.matchCriteria(aSc)){
					foundTripInstances.addElement(tripInstance);
				}
			}
		}
		return foundTripInstances;
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