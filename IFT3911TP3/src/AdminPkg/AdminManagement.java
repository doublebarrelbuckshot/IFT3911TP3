package AdminPkg;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		TransportationManager tptManager = TransportationManager.getInstance();

		TransportationFactory airFactory =  AirFactory.getInstance();
		TransportationHub airportYUL = airFactory.createTransportationHub("Pierre Elliot Trudeau");
		//System.out.println("AIRPORT: " + airportYUL.get_name());
		tptManager._listTptHubs.add(airportYUL);

		TransportationHub airportLAX = airFactory.createTransportationHub("Los Angeles International");
		tptManager._listTptHubs.add(airportLAX);

		TransportationHub airportJFK = airFactory.createTransportationHub("John F. Kennedy International");
		tptManager._listTptHubs.add(airportJFK);
		
		
		Date dDepartYUL_JFK = new Date();
		dDepartYUL_JFK.setHours(10);
		dDepartYUL_JFK.setMinutes(30);
		
		Date dArriveYUL_JFK = new Date();
		dArriveYUL_JFK.setHours(12);
		dArriveYUL_JFK.setMinutes(30);
		TripGeneral YUL_JFK = airFactory.createTripGeneral(dDepartYUL_JFK, dArriveYUL_JFK, "YULJKF1030", airportYUL, airportJFK);
		
		
		Date dDepartYUL_LAX = new Date();
		dDepartYUL_LAX.setHours(8);
		dDepartYUL_LAX.setMinutes(45);
		
		Date dArriveYUL_LAX = new Date();
		dArriveYUL_LAX.setHours(11);
		dArriveYUL_LAX.setMinutes(55);
		TripGeneral YUL_LAX = airFactory.createTripGeneral(dDepartYUL_LAX, dArriveYUL_LAX, "YULLAX845", airportYUL, airportLAX);
		
		
		Date dDepartLAX_JFK = new Date();
		dDepartLAX_JFK.setHours(4);
		dDepartLAX_JFK.setMinutes(15);
		
		Date dArriveLAX_JFK = new Date();
		dArriveLAX_JFK.setHours(9);
		dArriveLAX_JFK.setMinutes(45);
		TripGeneral LAX_JFK = airFactory.createTripGeneral(dDepartLAX_JFK, dArriveLAX_JFK, "LAXJKF415", airportLAX, airportJFK);
		
		
		System.out.println("LAX-JFK: " + LAX_JFK.get_heureArriveStr() + "  " + LAX_JFK._hubArrival.get_name() + " " + LAX_JFK._hubDeparture.get_name());
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