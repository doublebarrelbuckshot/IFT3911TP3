package AdminPkg;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

import ClientPkg.SystemeClient;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.AvailableState;
import TransportationPkg.ComfortClass;
import TransportationPkg.GenericSeat;
import TransportationPkg.InstanceSeat;
import TransportationPkg.TransportationCompany;
import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationVehicle;
import TransportationPkg.TripGeneral;
import TransportationPkg.TripInstance;

public class Searcher {
	private static Searcher _instance;
	public SystemeClient _unnamed_SystemeClient_;
	private TransportationManager transportationManager = TransportationManager.getInstance();
	
	private Searcher(){
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
		Vector<TripGeneral> listTripGenerals = transportationManager.get_listTripGenerals();
		Vector<TripGeneral> foundTripGenerals = new Vector<TripGeneral>(); 
		for(TripGeneral tripGeneral : listTripGenerals){
				if (tripGeneral.matchCriteria(aSc)){
					foundTripGenerals.addElement(tripGeneral);
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
	
	public Vector<GenericSeat> findGenericSeat(SearchCriteria aSc) throws Exception {
		if(aSc.get_tripIDNumber().isEmpty()){
			throw new Exception("Le trip id ne peut etre nul pour la recherche de siege.");
		}
		if (aSc.get_tripDepartureDate().equals(null)){
			throw new Exception("La date de depart ne peut etre nul pour la recherche.");
		}
		//Vector<TripGeneral> listTripGeneral = findTripGeneral(aSc);
		TripGeneral tripGeneral = findTripGeneralId(aSc.get_tripIDNumber());
		
		/*if (listTripGeneral.isEmpty()){
			return null;
		}
		if(listTripGeneral.size() > 1){
			throw new Exception("Ne peut pas contenir plusieurs trip generals avec le meme id");
		}
		
		TripGeneral tripGeneral = listTripGeneral.firstElement();*/
		
		Vector<TripInstance> listMatchedTripInstances = new Vector<TripInstance>();
		
		for (TripInstance tripInstance : tripGeneral.get_tripInstances()){
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			if(tripInstance.get_dateDepartStr().equals(df.format(aSc.get_tripDepartureDate()))){
				listMatchedTripInstances.addElement(tripInstance);
			}
		}
		if (listMatchedTripInstances.isEmpty()){
			return null;
		}
		if (listMatchedTripInstances.size() > 1){
			throw new Exception("Ne peut avoir plusieurs trip instances avec une meme date pour un trip general donne");
		}
		
		TripInstance tripInstance = listMatchedTripInstances.firstElement();
		Vector<GenericSeat> genericAvailableSeatList = new Vector<GenericSeat>();  
		for(ComfortClass comfortClass : tripInstance.get_comfortClasses()){
			for (GenericSeat genericSeat : comfortClass.get_seating()){
				if(genericSeat.get_state() instanceof AvailableState){
					genericAvailableSeatList.addElement(genericSeat);
				}
			}
		}
		return genericAvailableSeatList;
		
	}

	public static Searcher getInstance() {
		if(_instance == null)
			_instance = new Searcher();
		return _instance;
	}

	public int getOrderChangeDeadline(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public TripGeneral findOneTripGeneral(SearchCriteria aSc)
	{
		for(TripGeneral tg : transportationManager.get_listTripGenerals())
		{
			if(tg.get_tripID().equals(aSc.get_tripIDNumber()))
				return tg;
		}
		return null;
	}
	public TransportationCompany findTransportationCompany(SearchCriteria aSc) throws Exception {
		if(aSc.get_transportationCompanyName().isEmpty()){
			throw new Exception("Le nom de compagnie ne peut etre nul pour la recherche de compagnie.");
		}
		for(TransportationCompany tptCompany : transportationManager.get_listTptCompanies()){
			if (tptCompany.get_id().equals(aSc.get_transportationCompanyName())){
				return tptCompany;
			}
		}
		return null;
	}
	
	public TransportationHub findOneTransportationHub(SearchCriteria aSc) throws Exception{
		if(aSc.get_transportationHubName().isEmpty()){
			throw new Exception("Le nom de compagnie ne peut etre nul pour la recherche de compagnie.");
		}
		for(TransportationHub tptHub : transportationManager.get_listTptHubs()){
			if (tptHub.get_id().equals(aSc.get_transportationHubName())){
				return tptHub;
			}
		}
		return null;
	}
	
	public TripGeneral findTripGeneralId(String id){
		Vector<TripGeneral> list = TransportationManager.getInstance().get_listTripGenerals();
		TripGeneral tripG=null;
		
		for(TripGeneral trip :list){
			if(trip.get_tripID().equals(id)){
				tripG=trip;
				break;
			}
		}
		
		return tripG;
	}
}