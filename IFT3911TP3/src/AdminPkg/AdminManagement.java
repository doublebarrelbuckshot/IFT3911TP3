package AdminPkg;

import TransportationPkg.TripGeneral;
import AdminPkg.AirAdminPkg.AirFactory;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.GenericSeat;
import TransportationPkg.TransportationVehicle;
import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationCompany;

public class AdminManagement extends Subject {
	protected Administrator _listAdmins;
	public UIAdmin _interacts;
	public TransportationFactory _unnamed_TransportationFactory_;
	public ICommand _commands;

	
	public static void main(String[] args)
	{
		TransportationFactory airFactory =  AirFactory.getInstance();
		TransportationHub airPort = airFactory.createTransportationHub("Pierre Elliot Trudeau");
		System.out.println("AIRPORT: " + airPort.get_name());
		
		TransportationManager tptManager = TransportationManager.getInstance();
		tptManager._listTptHubs.add(airPort);
		
	}
	
	
	private AdminManagement() {
		throw new UnsupportedOperationException();
	}

	public AdminManagement getInstance() {
		throw new UnsupportedOperationException();
	}

	public TripGeneral findTripGeneral(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public GenericSeat findGenericSeat(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public GenericSeat findSeat(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public void addTransportCompany(String aName) {
		throw new UnsupportedOperationException();
	}

	public void addTransportationHub(String aName) {
		throw new UnsupportedOperationException();
	}

	public void addTransportationVehicle(String aId) {
		throw new UnsupportedOperationException();
	}

	public void removeTransportationHub(int aId) {
		throw new UnsupportedOperationException();
	}

	public TransportationVehicle findTransportationVehicle(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public void removeTransportationVehicle(String aVehID) {
		throw new UnsupportedOperationException();
	}

	public void removeTransportCompany(int aId) {
		throw new UnsupportedOperationException();
	}

	public void addTripGeneral(String aTripID, TransportationHub aDepart, TransportationHub aArrive, TransportationCompany aTc) {
		throw new UnsupportedOperationException();
	}

	public TransportationHub findTransportationHub(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public TransportationCompany findTransportationCompany(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public void removeTripGeneral(TripGeneral aTg) {
		throw new UnsupportedOperationException();
	}
}